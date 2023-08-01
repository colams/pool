package cn.colams.common;

import cn.colams.common.constant.ChromeOptionEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        chromeOptions.addArguments("--start-maximized");
        if (Objects.nonNull(options)) {
            chromeOptions.addArguments(options.getValue());
        }
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get(targetUrl);
        try {
            Thread.sleep(10 * 1000);
            JavascriptExecutor executor = (JavascriptExecutor) webDriver;
            boolean result = (Boolean) executor.executeScript("return document.body.style.overflow!=\"hidden\"");
            if (!result) {
                WebElement modalButton = findElement(webDriver, By.cssSelector("div[data-testid='modal-container'] button")).orElse(null);
                modalButton.click();
            }
            Thread.sleep(3 * 1000);
            executor.executeScript("window.scrollTo(0, document.body.scrollHeight / 2)");
            Thread.sleep(3 * 1000);
            executor.executeScript("window.scrollTo(0, document.body.scrollHeight / 2)");
        } catch (InterruptedException e) {
            LOGGER.error("getWebDriverImpl", e);
        }
        return webDriver;
    }

    /**
     * 获取 webDriver
     *
     * @param targetUrl 目标地址
     * @param options
     * @return
     */
    public static WebDriver getWebDriverV2(String targetUrl, ChromeOptionEnum options) {
        System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemResource("driver/chromedriver.exe").getPath());
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        if (Objects.nonNull(options)) {
            chromeOptions.addArguments(options.getValue());
        }
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.get(targetUrl);

        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            LOGGER.error("getWebDriverV2", e);
        }
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
