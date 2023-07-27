package cn.colams.common;

import cn.colams.common.constant.ChromeOptionEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class SeleniumUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(SeleniumUtils.class);

    /**
     * 获取 webDriver
     *
     * @param targetUrl 目标地址
     * @param options
     * @return
     */
    public static WebDriver getWebDriverImpl(String targetUrl, ChromeOptionEnum options) {
        System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemResource("driver/chromedriver.exe").getPath());
        ChromeOptions chromeOptions = new ChromeOptions();
        if (Objects.nonNull(options)) {
            chromeOptions.addArguments(options.getValue());
        }
        WebDriver webDriver = new ChromeDriver(chromeOptions);

        webDriver.get(targetUrl);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        String js = "window.scrollTo(0, document.body.scrollHeight)";
//        ((JavascriptExecutor) webDriver).executeScript(js);
        Optional<WebElement> opFooter = findElement(webDriver, By.cssSelector("footer[aria-labelledby='footerHeading']"));
        if (opFooter.isPresent()) {
            Actions actions = new Actions(webDriver);
            actions.moveToElement(opFooter.get());
        }
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return webDriver;
    }

    public static Optional<WebElement> findElement(WebDriver driver, By by) {
        WebElement element = null;
        try {
            element = driver.findElement(by);
        } catch (Exception e) {
            LOGGER.error("findElement", e);
        }
        return Optional.ofNullable(element);
    }

    public static Optional<List<WebElement>> findElements(WebDriver driver, By by) {
        List<WebElement> elements = null;
        try {
            elements = driver.findElements(by);
        } catch (Exception e) {
            LOGGER.error("findElement", e);
        }
        return Optional.ofNullable(elements);
    }

    public static Optional<WebElement> findElement(WebElement element, By by) {
        WebElement webElement = null;
        try {
            webElement = element.findElement(by);
        } catch (Exception e) {
            LOGGER.error("findElement", e);
        }
        return Optional.ofNullable(webElement);
    }

    public static Optional<List<WebElement>> findElements(WebElement element, By by) {
        List<WebElement> webElements = null;
        try {
            webElements = element.findElements(by);
        } catch (Exception e) {
            LOGGER.error("findElement", e);
        }
        return Optional.ofNullable(webElements);
    }
}
