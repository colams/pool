package cn.colams.biz.airbnb;

import cn.colams.common.SeleniumUtils;
import cn.colams.common.constant.ChromeOptionEnum;
import cn.colams.dal.entity.Airbnb;
import cn.colams.dal.entity.AirbnbExample;
import cn.colams.dal.entity.AirbnbRoomOwner;
import cn.colams.dal.entity.AirbnbRoomOwnerExample;
import cn.colams.dal.mapper.extension.AirbnbExtensionMapper;
import cn.colams.dal.mapper.extension.AirbnbRoomOwnerExtensionMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
public class AirbnbBusiness {

    private static final Logger LOGGER = LoggerFactory.getLogger(AirbnbBusiness.class);

    @Autowired
    AirbnbExtensionMapper airbnbExtensionMapper;
    @Autowired
    AirbnbRoomOwnerExtensionMapper airbnbRoomOwnerExtensionMapper;

    public boolean scrapyList(String targetUrl, Integer pageIndex, Boolean showBrowser) {
        ChromeOptionEnum optionEnum = showBrowser ? null : ChromeOptionEnum.HEADLESS;
        WebDriver driver = SeleniumUtils.getWebDriverImpl(targetUrl, optionEnum);
        if (Objects.isNull(pageIndex)) {
            pageIndex = 1;
        }
        analysisCardContainer(driver, pageIndex);
        analysisNavPage(driver, pageIndex);
        return false;
    }


    private void analysisNavPage(WebDriver driver, Integer pageIndex) {
        WebElement element = driver.findElement(By.cssSelector("nav[aria-label='搜索结果分页']"));
        WebElement nextElement = findElement(element, By.cssSelector("a[aria-label='下一个']"));
        if (Objects.nonNull(nextElement)) {
            String nextUrl = nextElement.getAttribute("href");
            scrapyList(nextUrl, pageIndex + 1, false);
        }
    }


    private void analysisCardContainer(WebDriver driver, int pageIndex) {
        List<WebElement> webElements = driver.findElements(By.cssSelector("div[data-testid='card-container']"));

        for (WebElement element : webElements) {
            try {
                Airbnb airbnb = analysisElement(element, pageIndex);
                AirbnbExample example = new AirbnbExample();
                AirbnbExample.Criteria criteria = example.createCriteria();
                criteria.andRoomIdEqualTo(airbnb.getRoomId());
                List<Airbnb> airbnbs = airbnbExtensionMapper.selectByExample(example);
                if (CollectionUtils.isEmpty(airbnbs)) {
                    airbnbExtensionMapper.insertSelective(airbnb);
                }
            } catch (Exception e) {
                LOGGER.error("scrapy_for", e);
            }
        }
    }


    private Airbnb analysisElement(WebElement element, Integer pageIndex) {

        String strElement = element.getText();
        String roomId = element.getAttribute("aria-labelledby").split("_")[1];
        String url = element.findElement(By.tagName("a")).getAttribute("href");
        String roomName = element.findElement(By.cssSelector("div[data-testid='listing-card-title']")).getText();
        int picture_count = element.findElements(By.tagName("picture")).size();
        String evaluate = "";
        WebElement evaluateElement = findElement(element, By.cssSelector("span[aria-hidden='true']"));
        if (Objects.nonNull(evaluateElement)) {
            evaluate = evaluateElement.getText();
        }
        return getAirbnb(pageIndex, strElement, roomId, url, roomName, picture_count, evaluate);
    }

    private static Airbnb getAirbnb(Integer pageIndex, String strElement, String roomId, String url, String roomName, int picture_count, String evaluate) {
        Airbnb airbnb = new Airbnb();
        airbnb.setExtra(strElement);
        airbnb.setRoomUrl(url);
        airbnb.setRoomId(roomId);

        airbnb.setArea("");
        airbnb.setLandlordId("");
        airbnb.setPrice("");

        airbnb.setEvaluate(evaluate);
        airbnb.setPictureCount(picture_count);
        airbnb.setRoomName(roomName);

        airbnb.setPage(pageIndex);
        airbnb.setCreateTime(new Date());
        return airbnb;
    }

    private WebElement findElement(WebElement element, By by) {
        WebElement webElement = null;
        try {
            webElement = element.findElement(by);
        } catch (Exception e) {
            LOGGER.error("findElement", e);
        }
        return webElement;
    }

    public void scrapyLord(Boolean showBrowser) {
        AirbnbExample airbnbExample = new AirbnbExample();
        AirbnbExample.Criteria criteria = airbnbExample.createCriteria();
        criteria.andDealStatusNotEqualTo(1);
        List<Airbnb> airbnbs = airbnbExtensionMapper.selectByExampleWithBLOBs(airbnbExample);

        for (Airbnb airbnb : airbnbs) {
            try {
                ChromeOptionEnum optionEnum = showBrowser ? null : ChromeOptionEnum.HEADLESS;
                WebDriver driver = SeleniumUtils.getWebDriverImpl(airbnb.getRoomUrl(), optionEnum);
                Airbnb temp = analysisDetail(driver);
                airbnb.setLandlordId(temp.getLandlordId());
                airbnb.setDealStatus(1);
            } catch (Exception e) {
                LOGGER.error("scrapyLord", e);
                airbnb.setDealStatus(2);
            }
            airbnbExtensionMapper.updateByPrimaryKeySelective(airbnb);
        }
    }

    private Airbnb analysisDetail(WebDriver driver) {
        WebElement lordElement = driver.findElement(By.cssSelector("div[data-section-id='HOST_PROFILE_DEFAULT']"));
        String lord_page = lordElement.findElement(By.cssSelector("a[target='_blank']")).getAttribute("href");
        String lord_id = lord_page.substring(lord_page.lastIndexOf("/") + 1);


        Airbnb airbnb = new Airbnb()
                .withLandlordId(lord_id);
        AirbnbRoomOwnerExample example = new AirbnbRoomOwnerExample();
        AirbnbRoomOwnerExample.Criteria criteria = example.createCriteria();
        criteria.andLoardIdEqualTo(lord_id);
        List<AirbnbRoomOwner> airbnbRoomOwners = airbnbRoomOwnerExtensionMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(airbnbRoomOwners)) {
            AirbnbRoomOwner airbnbRoomOwner = getAirbnbRoomOwnerInfo(lord_page, lord_id);
            airbnbRoomOwnerExtensionMapper.insertSelective(airbnbRoomOwner);
        }
        return airbnb;
    }

    private AirbnbRoomOwner getAirbnbRoomOwnerInfo(String lordPage, String lord_id) {
        String url = String.format("https://zh.airbnb.com/users/%s/listings", lord_id);

        WebDriver driver = SeleniumUtils.getWebDriverImpl(url, ChromeOptionEnum.HEADLESS);

        String lord_name = driver.findElement(By.cssSelector("a[href='/users/show/" + lord_id + "']")).getText();
        int lord_rooms = Integer.valueOf(driver.findElement(By.cssSelector("div[class='_h6avcp2']")).getText().split("个")[0]);

        AirbnbRoomOwner airbnbRoomOwner = new AirbnbRoomOwner();
        airbnbRoomOwner.setRooms(lord_rooms);
        airbnbRoomOwner.setLoardId(lord_id);
        airbnbRoomOwner.setLordName(lord_name);
        airbnbRoomOwner.setLordPage(lordPage);
        return airbnbRoomOwner;
    }
}
