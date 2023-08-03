package cn.colams.common;

import cn.colams.common.constant.ChromeOptionEnum;
import cn.colams.common.utils.DateUtility;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.Logs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeleniumUtilsTest extends CommonTest {

    @Test
    public void testGetWebDriverImpl() {

        WebDriver driver = SeleniumUtils.getWebDriverImpl("http://www.baidu.com", ChromeOptionEnum.HEADLESS);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }


    @Test
    public void testGetWebDriverV2() {
        String url = "https://zh.airbnb.com/s/Fujairah--%E9%98%BF%E6%8B%89%E4%BC%AF%E8%81%94%E5%90%88%E9%85%8B%E9%95%BF%E5%9B%BD/homes?adults=1&place_id=ChIJaZcmmShW9D4R5Ybq-OUnBro&refinement_paths%5B%5D=%2Fhomes";
        WebDriver driver = SeleniumUtils.getWebDriverV2(url, null);

        Logs logs = driver.manage().logs();
        for (String logType : logs.getAvailableLogTypes()) {
            LogEntries logEntries = logs.get(logType);
            for (LogEntry entry : logEntries.getAll()) {
                if (entry.getMessage().contains("X-Airbnb-API-Key")) {
                    Pattern pattern = Pattern.compile("X-Airbnb-API-Key\":\"(.*?)\",");
                    Matcher matcher = pattern.matcher(entry.getMessage());
                    if (matcher.find()) {
                        String api_key = matcher.group(1);
                        System.out.println("X-Airbnb-API-Key:" + api_key);
                    }
                    System.out.println(String.format("%s========%s\n%s", entry.getLevel(),
                            DateUtility.longToLocalDateTime(entry.getTimestamp()), entry.getMessage()));
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
                    return;
                }
            }
        }

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}