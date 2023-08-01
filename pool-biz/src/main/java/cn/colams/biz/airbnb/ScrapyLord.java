package cn.colams.biz.airbnb;

import cn.colams.common.SeleniumUtils;
import cn.colams.common.constant.ChromeOptionEnum;
import cn.colams.common.utils.OptionalUtils;
import cn.colams.dal.entity.Airbnb;
import cn.colams.dal.entity.AirbnbExample;
import cn.colams.dal.entity.AirbnbRoomOwner;
import cn.colams.dal.entity.AirbnbRoomOwnerExample;
import cn.colams.dal.mapper.extension.AirbnbExtensionMapper;
import cn.colams.dal.mapper.extension.AirbnbRoomOwnerExtensionMapper;
import com.google.common.collect.Lists;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

@Component
public class ScrapyLord {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScrapyLord.class);

    @Autowired
    AirbnbExtensionMapper airbnbExtensionMapper;
    @Autowired
    AirbnbRoomOwnerExtensionMapper airbnbRoomOwnerExtensionMapper;


    /**
     * 从详情页开始分析房东信息
     *
     * @param showBrowser
     */
    public void scrapyLord(Boolean showBrowser) {
        AirbnbExample airbnbExample = new AirbnbExample();
        AirbnbExample.Criteria criteria = airbnbExample.createCriteria();
        criteria.andDealStatusIn(Lists.newArrayList(0, 2));
        List<Airbnb> airbnbs = airbnbExtensionMapper.selectByExampleWithBLOBs(airbnbExample);

        for (Airbnb airbnb : airbnbs) {
            WebDriver driver = null;
            try {
                ChromeOptionEnum optionEnum = showBrowser ? null : ChromeOptionEnum.HEADLESS;
                driver = SeleniumUtils.getWebDriverImpl(airbnb.getRoomUrl(), optionEnum);
                analysisDetail(driver, airbnb);
            } catch (Exception e) {
                LOGGER.error("scrapyLord:" + airbnb.getRoomId(), e);
                airbnb.setDealStatus(2);
            }
            if (Objects.nonNull(driver)) {
                driver.quit();
            }
            airbnbExtensionMapper.updateByPrimaryKeySelective(airbnb);
        }
    }

    /**
     * 详情页解析出房东信息
     *
     * @param driver
     * @param airbnb
     * @return
     */
    private Airbnb analysisDetail(WebDriver driver, Airbnb airbnb) throws ParseException {
        Optional<WebElement> loadPageEl = SeleniumUtils.findElement(driver,
                By.cssSelector("div[data-section-id='HOST_PROFILE_DEFAULT'] a[href^='/users/show/']"));
        if (!loadPageEl.isPresent()) {
            loadPageEl = SeleniumUtils.findElement(driver,
                    By.cssSelector("div[data-section-id='MEET_YOUR_HOST'] a[href^='/users/show/']"));
        }
        String lord_page = "";
        String lord_id = "";

        if (loadPageEl.isPresent()) {
            lord_page = OptionalUtils.stringVal(loadPageEl, e -> e.getAttribute("href"));
            lord_id = lord_page.substring(lord_page.lastIndexOf("/") + 1);
        }

        Optional<WebElement> googleElement = SeleniumUtils.findElement(driver, By.cssSelector("a[title='向 Google 报告道路地图或图像中的错误']"));
        String location = OptionalUtils.stringVal(googleElement, e -> e.getAttribute("href"));

        String price = "";
        Optional<WebElement> priceELement = SeleniumUtils.findElement(driver, By.cssSelector("div[data-section-id='BOOK_IT_SIDEBAR']"));
        if (priceELement.isPresent()) {
            Optional<WebElement> op1 = SeleniumUtils.findElement(priceELement.get(), By.className("_1emnh212"));
            if (!op1.isPresent()) {
                op1 = SeleniumUtils.findElement(priceELement.get(), By.className("_1y74zjx"));
            }
            price = OptionalUtils.stringVal(op1, e -> e.getText());
        }

        airbnb.withLandlordId(lord_id).withRoomLocation(location).withPrice(price);

        AirbnbRoomOwnerExample example = new AirbnbRoomOwnerExample();
        AirbnbRoomOwnerExample.Criteria criteria = example.createCriteria();
        criteria.andLoardIdEqualTo(lord_id);
        List<AirbnbRoomOwner> airbnbRoomOwners = airbnbRoomOwnerExtensionMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(airbnbRoomOwners)) {
            AirbnbRoomOwner airbnbRoomOwner = getAirbnbRoomOwnerInfo(lord_page, lord_id, airbnb.getId());
            airbnbRoomOwnerExtensionMapper.insertSelective(airbnbRoomOwner);
            airbnb.setDealStatus(1);
        } else {
            airbnb.setDealStatus(3);
        }
        return airbnb;
    }

    /**
     * 到房东的房间列表页 分析房间信息
     *
     * @param lordPage
     * @param lord_id
     * @param airbnbID
     * @return
     */
    private AirbnbRoomOwner getAirbnbRoomOwnerInfo(String lordPage, String lord_id, Long airbnbID) throws ParseException {
        String url = String.format("https://zh.airbnb.com/users/%s/listings", lord_id);
        String url2 = String.format("https://zh.airbnb.com/users/show/%s", lord_id);

        WebDriver driver = SeleniumUtils.getWebDriverV2(url, ChromeOptionEnum.HEADLESS);
        WebDriver driver2 = SeleniumUtils.getWebDriverV2(url2, ChromeOptionEnum.HEADLESS);


        AirbnbRoomOwner airbnbRoomOwner = new AirbnbRoomOwner();
        airbnbRoomOwner.setRooms(getLordRooms(driver));
        airbnbRoomOwner.setLoardId(lord_id);
        airbnbRoomOwner.setLordName(getLordName(driver, lord_id));
        airbnbRoomOwner.setLordPage(lordPage);
        airbnbRoomOwner.setAirbnbId(airbnbID);
        airbnbRoomOwner.setEvaluate(getEvaluate(driver2));
        airbnbRoomOwner.setBrief(getLordBrief(driver2));
        driver2.quit();
        driver.quit();
        return airbnbRoomOwner;
    }

    /**
     * 获取房东名
     *
     * @param driver
     * @param lord_id
     * @return
     */
    public String getLordName(WebDriver driver, String lord_id) {
        By by = By.cssSelector("a[href='/users/show/" + lord_id + "']");
        Optional<WebElement> userEl = SeleniumUtils.findElement(driver, by);
        return OptionalUtils.stringVal(userEl, e -> e.getText());
    }

    /**
     * 获取房间数
     *
     * @param driver
     * @return
     * @throws ParseException
     */
    public int getLordRooms(WebDriver driver) throws ParseException {
        By by = By.cssSelector("div[class='_h6avcp2']");
        Optional<WebElement> roomsEl = SeleniumUtils.findElement(driver, by);
        String numberStr = OptionalUtils.stringVal(roomsEl, e -> e.getText()).split("个")[0];
        return NumberFormat.getNumberInstance(Locale.US).parse(numberStr).intValue();
    }

    /**
     * 获取房东简介
     *
     * @param driver
     * @return
     */
    public String getLordBrief(WebDriver driver) {
        By by = By.cssSelector("div[data-testid='user-profile-content'] section");
        Optional<WebElement> briefEl = SeleniumUtils.findElement(driver, by);
        return OptionalUtils.stringVal(briefEl, e -> e.getText());
    }

    /**
     * 获取评价信息
     *
     * @param driver
     * @return
     */
    public String getEvaluate(WebDriver driver) {
        By by = By.cssSelector("div[data-veloute='user_profile_frame'] section section .sxz955h > div > span");
        Optional<List<WebElement>> evaluateEls = SeleniumUtils.findElements(driver, by);
        StringBuffer stringBuffer = new StringBuffer();
        if (evaluateEls.isPresent()) {
            for (WebElement el : evaluateEls.get()) {
                stringBuffer.append(el.getText() + ";");
            }
        }
        return stringBuffer.toString();
    }

}
