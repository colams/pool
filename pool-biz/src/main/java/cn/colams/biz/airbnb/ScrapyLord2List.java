package cn.colams.biz.airbnb;

import cn.colams.common.dto.airbnb.UserPromoListsResponse;
import cn.colams.common.utils.HttpUtils;
import cn.colams.common.utils.JacksonSerializerUtil;
import cn.colams.dal.entity.AirbnbLord;
import cn.colams.dal.entity.AirbnbLordExample;
import cn.colams.dal.mapper.extension.AirbnbExtensionMapper;
import cn.colams.dal.mapper.extension.AirbnbLordExtensionMapper;
import com.google.common.collect.Lists;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ScrapyLord2List {


    private static final Logger LOGGER = LoggerFactory.getLogger(ScrapyLord.class);

    @Autowired
    AirbnbExtensionMapper airbnbExtensionMapper;
    @Autowired
    AirbnbLordExtensionMapper airbnbLordExtensionMapper;


    public void lord2List(Boolean showBrowser) {
        AirbnbLordExample example = new AirbnbLordExample();
        AirbnbLordExample.Criteria criteria = example.createCriteria();
        criteria.andProcessStatusIn(Lists.newArrayList(0, 3));
        List<AirbnbLord> airbnbRoomOwners = airbnbLordExtensionMapper.selectByExample(example);

        for (AirbnbLord airbnbRoomOwner : airbnbRoomOwners) {
            WebDriver driver = null;
            try {
                getUserListings(airbnbRoomOwner.getLoardId(), airbnbRoomOwner.getRooms());
                airbnbRoomOwner.setProcessStatus(1);
            } catch (Exception e) {
                LOGGER.error("scrapyLord:" + airbnbRoomOwner.getId(), e);
                airbnbRoomOwner.setProcessStatus(3);
            }
            if (Objects.nonNull(driver)) {
                driver.quit();
            }
            // airbnbLordExtensionMapper.updateByPrimaryKeySelective(airbnbRoomOwner);
        }
    }

    private void getUserListings(String lord_id, int rooms) throws IOException {
        if (rooms <= 0) {
            return;
        }
        String user_lists_url = String.format("%s%s", Constant.HOST_URL, Constant.USER_PROMO_LISTINGS_URL);
        int groupCount = getGroupCount(rooms);
        List<Header> headers = new ArrayList<>();
        headers.add(new BasicHeader(AirbnbApiKey.HEADER_KEY, AirbnbApiKey.HEADER_VALUE));
        for (int i = 0; i < groupCount; i++) {
            String res = HttpUtils.doGet(String.format(user_lists_url, i * Constant.GROUP_SIZE, lord_id), headers);
            UserPromoListsResponse response = JacksonSerializerUtil.deserialize(res, UserPromoListsResponse.class);
            System.out.println(res);
        }
    }

    private int getGroupCount(int rooms) {
        int groupCount = rooms / Constant.GROUP_SIZE;
        int remainder = rooms % Constant.GROUP_SIZE;
        if (remainder > 0) {
            groupCount += 1;
        }
        return groupCount;
    }

    public interface Constant {
        int GROUP_SIZE = 50;
        String HOST_URL = "https://zh.airbnb.com/";
        String USER_PROMO_LISTINGS_URL = "api/v2/user_promo_listings?locale=zh&currency=SGD&_limit=50&_offset=%s&user_id=%s";
    }

    public interface AirbnbApiKey {
        String HEADER_KEY = "X-Airbnb-API-Key";
        String HEADER_VALUE = "d306zoyjsyarp7ifhu67rjxn52tv0t20";
    }
}
