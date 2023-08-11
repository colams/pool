package cn.colams.biz.airbnb;

import cn.colams.common.SeleniumUtils;
import cn.colams.common.constant.ChromeOptionEnum;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.Logs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 获取 airbnb接口用到的 apikey
 */
@Component
public class CrawlerApiKey {


    private static final Logger LOGGER = LoggerFactory.getLogger(CrawlerApiKey.class);


    public String crawlerApiKey(String url) {
        if (StringUtils.isBlank(url)) {
            url = "https://www.airbnb.com";
        }
        WebDriver driver = SeleniumUtils.getWebDriverV2(url, ChromeOptionEnum.HEADLESS);

        Logs logs = driver.manage().logs();
        for (String logType : logs.getAvailableLogTypes()) {
            LogEntries logEntries = logs.get(logType);
            for (LogEntry entry : logEntries.getAll()) {
                if (entry.getMessage().contains("X-Airbnb-API-Key")) {
                    Pattern pattern = Pattern.compile("X-Airbnb-API-Key\":\"(.*?)\",");
                    Matcher matcher = pattern.matcher(entry.getMessage());
                    if (matcher.find()) {
                        String apiKey = matcher.group(1);
                        return apiKey;
                    }
                }
            }
        }
        return StringUtils.EMPTY;
    }


}
