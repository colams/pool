package cn.colams.biz.airbnb;

import cn.colams.common.SeleniumUtils;
import cn.colams.common.constant.ChromeOptionEnum;
import cn.colams.dal.entity.Airbnb;
import cn.colams.dal.entity.AirbnbExample;
import cn.colams.dal.mapper.extension.AirbnbExtensionMapper;
import com.google.common.collect.Lists;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.net.URLDecoder;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Component
public class CrawlerList {

    private static final Logger LOGGER = LoggerFactory.getLogger(CrawlerList.class);

    @Autowired
    AirbnbExtensionMapper airbnbExtensionMapper;

    /**
     * 分析airbnb 列表页数据
     *
     * @param targetUrl
     * @param pageIndex
     * @param showBrowser
     * @return
     */
    public boolean crawlerList(String targetUrl, Integer pageIndex, Boolean showBrowser) {
        return scrapyListWithCookies(targetUrl, pageIndex, showBrowser, null);
    }

    /**
     * 分析airbnb 列表页数据
     *
     * @param targetUrl
     * @param pageIndex
     * @param showBrowser
     * @param cookies
     * @return
     */
    public boolean scrapyListWithCookies(String targetUrl, Integer pageIndex, Boolean showBrowser, Set<Cookie> cookies) {
        ChromeOptionEnum optionEnum = showBrowser ? null : ChromeOptionEnum.HEADLESS;
        WebDriver driver = SeleniumUtils.getWebDriverImpl(targetUrl, optionEnum);
        if (Objects.isNull(pageIndex)) {
            pageIndex = 1;
        }
        analysisCardContainer(driver, pageIndex);
        analysisNavPage(driver, pageIndex);
        driver.quit();
        return false;
    }


    /**
     * 分析分页导航
     *
     * @param driver
     * @param pageIndex
     */
    private void analysisNavPage(WebDriver driver, Integer pageIndex) {
        // 获取分页导航nav
        Optional<WebElement> element = SeleniumUtils.findElement(driver, By.cssSelector("nav[aria-label='搜索结果分页']"));

        Optional<WebElement> nextElement = Optional.empty();
        if (element.isPresent()) {
            // 获取下一页链接element
            nextElement = SeleniumUtils.findElement(element.get(), By.cssSelector("a[aria-label='下一个']"));
        }
        if (nextElement.isPresent()) {
            // 读取 下一页 链接，并将页码+1，循环执行
            String nextUrl = nextElement.get().getAttribute("href");
            scrapyListWithCookies(nextUrl, pageIndex + 1, false, driver.manage().getCookies());
        }
    }


    /**
     * 分析列表页 酒店card信息
     *
     * @param driver
     * @param pageIndex
     */
    private void analysisCardContainer(WebDriver driver, int pageIndex) {
        Optional<List<WebElement>> optionalList = SeleniumUtils.findElements(driver, By.cssSelector("div[data-testid='card-container']"));

        for (WebElement element : optionalList.orElse(Lists.newArrayList())) {
            try {
                Airbnb airbnb = analysisElement(element, pageIndex);
                AirbnbExample example = new AirbnbExample();
                AirbnbExample.Criteria criteria = example.createCriteria();
                criteria.andRoomIdEqualTo(airbnb.getRoomId());
                List<Airbnb> airbnbs = airbnbExtensionMapper.selectByExample(example);
                if (CollectionUtils.isEmpty(airbnbs)) {
                    airbnb.setOrgUrl(URLDecoder.decode(driver.getCurrentUrl(), "UTF-8"));
                    airbnbExtensionMapper.insertSelective(airbnb);
                } else {
                    LOGGER.info("exist airbnb room infos :" + airbnb.getRoomId());
                }
            } catch (Exception e) {
                LOGGER.error("scrapy_for", e);
            }
        }
    }


    private Airbnb analysisElement(WebElement element, Integer pageIndex) {
        String strElement = element.getText();
        String roomId = element.getAttribute("aria-labelledby").split("_")[1];
        String url = SeleniumUtils.findElement(element, By.tagName("a")).map(e -> e.getAttribute("href")).orElse("");
        String roomName = SeleniumUtils.findElement(element, By.cssSelector("div[data-testid='listing-card-title']")).map(e -> e.getText()).orElse("");
        int picture_count = element.findElements(By.tagName("picture")).size();
//        Optional<WebElement> optional = SeleniumUtils.findElement(element, By.cssSelector("span[aria-hidden='true']"));
//        String evaluate = OptionalUtils.stringVal(optional, e -> e.getText());
        String evaluate = "";
        return getAirbnb(pageIndex, strElement, roomId, url, roomName, picture_count, evaluate);
    }

    private static Airbnb getAirbnb(Integer pageIndex, String strElement, String roomId, String url, String roomName, int picture_count, String evaluate) {
        Airbnb airbnb = new Airbnb();
        airbnb.withExtra(strElement)
                .withRoomUrl(url)
                .withRoomId(roomId)
                .withrSrouce(0);

        airbnb.withArea("")
                .withLordId("")
                .withPrice("");

        airbnb.withPictureCount(picture_count)
                .withRoomName(roomName)
                .withPage(pageIndex);
        return airbnb;
    }

}
