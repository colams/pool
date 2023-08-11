package cn.colams.biz.airbnb;

import cn.colams.common.SeleniumUtils;
import cn.colams.common.constant.ChromeOptionEnum;
import cn.colams.common.utils.OptionalUtils;
import cn.colams.common.utils.RegexUtils;
import cn.colams.dal.entity.Airbnb;
import cn.colams.dal.entity.AirbnbLord;
import cn.colams.dal.entity.AirbnbLordExample;
import cn.colams.dal.mapper.extension.AirbnbExtensionMapper;
import cn.colams.dal.mapper.extension.AirbnbLordExtensionMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 爬取airbnb房东信息
 */
@Component
public class CrawlerLord {

    private static final Logger LOGGER = LoggerFactory.getLogger(CrawlerLord.class);

    @Autowired
    AirbnbExtensionMapper airbnbExtensionMapper;
    @Autowired
    AirbnbLordExtensionMapper airbnbLordExtensionMapper;


    /**
     * 从详情页开始分析房东信息
     *
     * @param showBrowser
     */
    public void crawlerLord(Boolean showBrowser) {
        List<Airbnb> airbnbs = airbnbExtensionMapper.selectRoom2Process(null);

        for (Airbnb airbnb : airbnbs) {
            WebDriver driver = null;
            try {
                ChromeOptionEnum optionEnum = showBrowser ? null : ChromeOptionEnum.HEADLESS;
                driver = SeleniumUtils.getWebDriverImpl(airbnb.getRoomUrl(), optionEnum);
                analysisDetail(driver, airbnb);
            } catch (Exception e) {
                LOGGER.error("scrapyLord:" + airbnb.getRoomId(), e);
                airbnb.setStatus(2);
            }
            if (Objects.nonNull(driver)) {
                driver.quit();
            }
            airbnb.withDatechangeLasttime(null);
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
    private Airbnb analysisDetail(WebDriver driver, Airbnb airbnb) {
        if (driver.getPageSource().indexOf("<h6>Error code: 410</h6>") > 0) {
            airbnb.setStatus(5);
            return airbnb;
        }
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

        if (StringUtils.isBlank(lord_id)) {
            airbnb.setStatus(4);
            return airbnb;
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

        airbnb.withLordId(lord_id).withRoomLocation(location);
        if (StringUtils.isEmpty(airbnb.getPrice())) {
            airbnb.withPrice(price);
        }

        AirbnbLordExample example = new AirbnbLordExample();
        AirbnbLordExample.Criteria criteria = example.createCriteria();
        criteria.andLoardIdEqualTo(lord_id);
        List<AirbnbLord> airbnbRoomOwners = airbnbLordExtensionMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(airbnbRoomOwners)) {
            AirbnbLord airbnbRoomOwner = getAirbnbRoomOwnerInfo(lord_page, lord_id, airbnb);
            airbnbLordExtensionMapper.insertSelective(airbnbRoomOwner);
            airbnb.setStatus(1);
        } else {
            airbnb.setStatus(3);
        }
        LOGGER.info("roomId:{},lordId:{},{}", airbnb.getRoomId(), lord_id, airbnb.getStatus());
        return airbnb;
    }

    /**
     * 到房东的房间列表页 分析房间信息
     *
     * @param lordPage
     * @param lord_id
     * @param airbnb
     * @return
     */
    private AirbnbLord getAirbnbRoomOwnerInfo(String lordPage, String lord_id, Airbnb airbnb) {
        String url2 = String.format("https://zh.airbnb.com/users/show/%s", lord_id);
        WebDriver driver2 = SeleniumUtils.getWebDriverV2(url2, ChromeOptionEnum.HEADLESS);


        AirbnbLord airbnbRoomOwner = new AirbnbLord();
        airbnbRoomOwner.setRooms(getLordRooms(driver2));
        airbnbRoomOwner.setLoardId(lord_id);
        airbnbRoomOwner.setLordName(getLordName(driver2));
        airbnbRoomOwner.setLordPage(lordPage);
        airbnbRoomOwner.setAirbnbId(airbnb.getId());
        airbnbRoomOwner.setCity(airbnb.getrState());
        airbnbRoomOwner.setEvaluate(getEvaluate(driver2));
        airbnbRoomOwner.setBrief(getLordBrief(driver2));
        driver2.quit();
        return airbnbRoomOwner;
    }

    /**
     * 获取房东名
     *
     * @param driver
     * @return
     */
    private String getLordName(WebDriver driver) {
        return RegexUtils.getValueByRegex("<span .*>(.*?)的房源</span>", driver.getPageSource());
    }

    /**
     * 获取房间数
     *
     * @param driver
     * @return
     * @throws ParseException
     */
    private int getLordRooms(WebDriver driver) {
        String value1 = RegexUtils.getValueByRegex("查看所有 (\\d*?) 个房源</button", driver.getPageSource());
        String value2 = RegexUtils.getValueByRegex("id=\"listings-scroller-description\">显示 (\\d*?) 项中的 \\d 项</div>", driver.getPageSource());
        if (StringUtils.isNotBlank(value1)) {
            return NumberUtils.toInt(value1);
        } else {
            return NumberUtils.toInt(value2);
        }
    }


    /**
     * 获取房东简介
     *
     * @param driver
     * @return
     */
    private String getLordBrief(WebDriver driver) {
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
    private String getEvaluate(WebDriver driver) {
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
