package cn.colams.common;

import cn.colams.common.constant.ChromeOptionEnum;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

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
        WebDriver driver = getWebDriverV2(targetUrl, options);
        try {
            Thread.sleep(9 * 1000);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            boolean result = (Boolean) executor.executeScript("return document.body.style.overflow!=\"hidden\"");
            if (!result) {
                WebElement modalButton = findElement(driver, By.cssSelector("div[data-testid='modal-container'] button")).orElse(null);
                modalButton.click();
            }
            Thread.sleep(4 * 1000);
            executor.executeScript("window.scrollTo(0, document.body.scrollHeight / 2)");
        } catch (InterruptedException e) {
            LOGGER.error("getWebDriverImpl", e);
        }
        return driver;
    }

    /**
     * 获取 webDriver
     *
     * @param targetUrl 目标地址
     * @param options
     * @return
     */
    public static WebDriver getWebDriverV2(String targetUrl, ChromeOptionEnum options) {
        URL url = SeleniumUtils.class.getResource("/" + "driver/chromedriver.exe");
        LOGGER.info(">>>>>>>>>>>>>>>>>>>>>>:" + url.getPath());
        System.setProperty("webdriver.chrome.driver", url.getPath());
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36");

        if (Objects.nonNull(options)) {
            chromeOptions.addArguments(options.getValue());
        }
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        WebDriver driver = new ChromeDriver(caps);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(targetUrl);
        driver.manage().getCookies().add(new Cookie("SRCHHPGUSR", "SRCHLANG=zh-Hans&BRW=XW&BRH=M&CW=1920&CH=969&SCW=1903&SCH=2975&DPR=1.0&UTC=480&DM=0&WTS=63821186637&HV=1685589848&PRVCW=1920&PRVCH=969&BZA=0&PV=10.0.0"));

        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            LOGGER.error("getWebDriverV2", e);
        }
        return driver;
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
