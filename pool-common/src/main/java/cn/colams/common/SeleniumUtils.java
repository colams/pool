package cn.colams.common;

import cn.colams.common.constant.ChromeOptionEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class SeleniumUtils {

    public static WebDriver getWebDriverImpl(String targetUrl, ChromeOptionEnum options) {
        System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemResource("driver/chromedriver.exe").getPath());
        ChromeOptions chromeOptions = new ChromeOptions();
        if (Objects.nonNull(options)) {
            chromeOptions.addArguments(options.getValue());
        }
        WebDriver webDriver = new ChromeDriver(chromeOptions);

        webDriver.get(targetUrl);
        webDriver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        return webDriver;
    }


}
