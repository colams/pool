package cn.colams.common;

import cn.colams.common.constant.ChromeOptionEnum;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class SeleniumUtilsTest extends CommonTest {

    @Test
    public void testGetWebDriverImpl() {

        WebDriver driver = SeleniumUtils.getWebDriverImpl("http://www.baidu.com", ChromeOptionEnum.HEADLESS, null);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}