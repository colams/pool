package cn.colams.biz.airbnb;

import cn.colams.common.dto.airbnb.UserPromoListsResponse;
import cn.colams.common.dto.airbnb.entity.UserPromoListings;
import cn.colams.common.utils.HttpUtils;
import cn.colams.common.utils.JacksonSerializerUtil;
import cn.colams.dal.entity.Airbnb;
import cn.colams.dal.entity.AirbnbLord;
import cn.colams.dal.entity.AirbnbLordExample;
import cn.colams.dal.mapper.extension.AirbnbExtensionMapper;
import cn.colams.dal.mapper.extension.AirbnbLordExtensionMapper;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
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
public class CrawlerLord2List {


    private static final Logger LOGGER = LoggerFactory.getLogger(CrawlerLord.class);

    @Autowired
    AirbnbExtensionMapper airbnbExtensionMapper;
    @Autowired
    AirbnbLordExtensionMapper airbnbLordExtensionMapper;


    public void lord2List(Boolean showBrowser, String lordId) {
        AirbnbLordExample example = new AirbnbLordExample();
        AirbnbLordExample.Criteria criteria = example.createCriteria();
        criteria.andProcessStatusIn(Lists.newArrayList(0, 2));
        if (Objects.nonNull(lordId)) {
            criteria.andLoardIdEqualTo(lordId);
        }
        List<AirbnbLord> airbnbRoomOwners = airbnbLordExtensionMapper.selectByExample(example);

        for (AirbnbLord airbnbRoomOwner : airbnbRoomOwners) {
            WebDriver driver = null;
            try {
                if (airbnbRoomOwner.getRooms() > 0) {
                    boolean isSucc = getUserListings(airbnbRoomOwner.getLoardId(), airbnbRoomOwner.getRooms());
                    airbnbRoomOwner.setProcessStatus(isSucc ? 1 : 2);
                } else {
                    airbnbRoomOwner.setProcessStatus(1);
                }
            } catch (Exception e) {
                LOGGER.error("scrapyLord:" + airbnbRoomOwner.getId(), e);
                airbnbRoomOwner.setProcessStatus(2);
            }
            if (Objects.nonNull(driver)) {
                driver.quit();
            }
            airbnbLordExtensionMapper.updateByPrimaryKeySelective(airbnbRoomOwner);
        }
    }

    private boolean getUserListings(String lord_id, int rooms) throws IOException, InterruptedException {
        String user_lists_url = String.format("%s%s", Constant.HOST_URL, Constant.USER_PROMO_LISTINGS_URL);
        int groupCount = getGroupCount(rooms);
        List<Header> headers = new ArrayList<>();
        headers.add(new BasicHeader(AirbnbApiKey.HEADER_KEY, AirbnbApiKey.HEADER_VALUE));
        for (int i = 0; i < groupCount; i++) {
            String res = HttpUtils.doGet(String.format(user_lists_url, i * Constant.GROUP_SIZE, lord_id), headers);
            if (StringUtils.isEmpty(res)) {
                return false;
            }
            UserPromoListsResponse response = JacksonSerializerUtil.deserialize(res, UserPromoListsResponse.class);
            response.getUserPromoListings().forEach(userPromoListings -> {
                saveAirbnbRoom(userPromoListings, lord_id);
            });
            Thread.sleep(1 * 1000);
        }
        return true;
    }

    private void saveAirbnbRoom(UserPromoListings userPromoListings, String lord_id) {
        try {
            Airbnb airbnb = airbnbExtensionMapper.selectByRoomId(userPromoListings.getIdStr());
            if (airbnb == null) {
                airbnb = new Airbnb();
            }
            airbnb.setRoomName(userPromoListings.getName());
            airbnb.setRoomId(userPromoListings.getIdStr());
            airbnb.setLordId(lord_id);
            airbnbExtensionMapper.insertOrUpdate(airbnb);
        } catch (Exception e) {
            LOGGER.error("saveAirbnbRoom error", e);
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
