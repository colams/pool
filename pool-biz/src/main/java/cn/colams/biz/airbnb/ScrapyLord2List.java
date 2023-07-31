package cn.colams.biz.airbnb;

import cn.colams.common.SeleniumUtils;
import cn.colams.common.constant.ChromeOptionEnum;
import cn.colams.dal.entity.AirbnbRoomOwner;
import cn.colams.dal.entity.AirbnbRoomOwnerExample;
import cn.colams.dal.mapper.extension.AirbnbExtensionMapper;
import cn.colams.dal.mapper.extension.AirbnbRoomOwnerExtensionMapper;
import com.google.common.collect.Lists;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class ScrapyLord2List {


    private static final Logger LOGGER = LoggerFactory.getLogger(ScrapyLord.class);

    @Autowired
    AirbnbExtensionMapper airbnbExtensionMapper;
    @Autowired
    AirbnbRoomOwnerExtensionMapper airbnbRoomOwnerExtensionMapper;


    public void lord2List(Boolean showBrowser) {
        AirbnbRoomOwnerExample example = new AirbnbRoomOwnerExample();
        AirbnbRoomOwnerExample.Criteria criteria = example.createCriteria();
        criteria.andProcessStatusIn(Lists.newArrayList(0, 3));
        List<AirbnbRoomOwner> airbnbRoomOwners = airbnbRoomOwnerExtensionMapper.selectByExample(example);

        for (AirbnbRoomOwner airbnbRoomOwner : airbnbRoomOwners) {
            WebDriver driver = null;
            try {
                ChromeOptionEnum optionEnum = showBrowser ? null : ChromeOptionEnum.HEADLESS;
                driver = SeleniumUtils.getWebDriverImpl(airbnbRoomOwner.getLordPage(), optionEnum, null);
                analysisListCard(driver);
                airbnbRoomOwner.setProcessStatus(1);
            } catch (Exception e) {
                LOGGER.error("scrapyLord:" + airbnbRoomOwner.getId(), e);
                airbnbRoomOwner.setProcessStatus(3);
            }
            if (Objects.nonNull(driver)) {
                driver.quit();
            }
            airbnbRoomOwnerExtensionMapper.updateByPrimaryKeySelective(airbnbRoomOwner);
        }
    }

    private void analysisListCard(WebDriver driver) {

    }
}
