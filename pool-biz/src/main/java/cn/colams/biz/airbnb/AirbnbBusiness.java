package cn.colams.biz.airbnb;

import cn.colams.common.SeleniumUtils;
import cn.colams.common.constant.ChromeOptionEnum;
import cn.colams.dal.entity.Airbnb;
import cn.colams.dal.mapper.extension.AirbnbExtensionMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
public class AirbnbBusiness {

    @Autowired
    AirbnbExtensionMapper airbnbExtensionMapper;

    public boolean scrapy(String targetUrl, Integer pageIndex, Boolean showBrowser) {
        ChromeOptionEnum optionEnum = showBrowser ? null : ChromeOptionEnum.HEADLESS;
        WebDriver driver = SeleniumUtils.getWebDriverImpl(targetUrl, optionEnum);

        List<WebElement> webElements = driver.findElements(By.cssSelector("div[data-testid='card-container']"));
        if (Objects.isNull(pageIndex)) {
            pageIndex = 1;
        }
        for (WebElement element : webElements) {
            String strElement = element.getText();
            String roomId = element.getAttribute("aria-labelledby").split("_")[1];
            String url = element.findElement(By.tagName("a")).getAttribute("href");

            saveAirbnbUrl(url, pageIndex, strElement, roomId);
        }
        return false;
    }


    private void saveAirbnbUrl(String url, int pageIndex, String extra, String room_id) {
        Airbnb airbnb = new Airbnb();
        airbnb.setCreateTime(new Date());
        airbnb.setPage(pageIndex);
        airbnb.setExtra(extra);
        airbnb.setDetailUrl(url);
        airbnb.setRoomId(room_id);
        airbnbExtensionMapper.insertSelective(airbnb);
    }


}
