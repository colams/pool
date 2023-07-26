package cn.colams.biz.airbnb;

import cn.colams.common.SeleniumUtils;
import cn.colams.common.constant.ChromeOptionEnum;
import cn.colams.dal.entity.Airbnb;
import cn.colams.dal.mapper.extension.AirbnbExtensionMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
public class AirbnbBusiness {

    private static final Logger LOGGER = LoggerFactory.getLogger(AirbnbBusiness.class);

    @Autowired
    AirbnbExtensionMapper airbnbExtensionMapper;

    public boolean scrapy(String targetUrl, Integer pageIndex, Boolean showBrowser) {
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
            scrapy(nextUrl, pageIndex + 1, false);
        }
    }


    private void analysisCardContainer(WebDriver driver, int pageIndex) {
        List<WebElement> webElements = driver.findElements(By.cssSelector("div[data-testid='card-container']"));

        for (WebElement element : webElements) {
            try {
                Airbnb airbnb = analysisElement(element, pageIndex);
                airbnbExtensionMapper.insertSelective(airbnb);
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

}
