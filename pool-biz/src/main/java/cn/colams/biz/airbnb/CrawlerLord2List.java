package cn.colams.biz.airbnb;

import cn.colams.common.airbnb.AirbnbApiKeyUtils;
import cn.colams.common.dto.airbnb.UserPromoListsResponseType;
import cn.colams.common.dto.airbnb.entity.UserPromoListings;
import cn.colams.common.utils.HttpUtils;
import cn.colams.common.utils.JacksonSerializerUtil;
import cn.colams.dal.entity.Airbnb;
import cn.colams.dal.entity.AirbnbLord;
import cn.colams.dal.mapper.extension.AirbnbExtensionMapper;
import cn.colams.dal.mapper.extension.AirbnbLordExtensionMapper;
import com.github.rholder.retry.RetryException;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

@Component
public class CrawlerLord2List {


    private static final Logger LOGGER = LoggerFactory.getLogger(CrawlerLord.class);

    @Autowired
    AirbnbExtensionMapper airbnbExtensionMapper;
    @Autowired
    AirbnbLordExtensionMapper lordExtensionMapper;
    @Autowired
    CrawlerApiKey crawlerApiKey;

    public void lord2List(String lordId) {
        List<AirbnbLord> airbnbRoomOwners = lordExtensionMapper.selectAirbnbLordByStatus(lordId);

        for (AirbnbLord airbnbRoomOwner : airbnbRoomOwners) {
            boolean isSucc = false;
            try {
                if (airbnbRoomOwner.getRooms() > 0) {
                    isSucc = getUserListings(airbnbRoomOwner.getLoardId(), airbnbRoomOwner.getRooms());
                }
            } catch (Exception e) {
                LOGGER.error("scrapyLord:" + airbnbRoomOwner.getId(), e);
                isSucc = false;
            }
            airbnbRoomOwner.setProcessStatus(isSucc ? 1 : 2);
            lordExtensionMapper.updateByPrimaryKeySelective(airbnbRoomOwner);
        }
    }

    private boolean getUserListings(String lord_id, int rooms) throws IOException, InterruptedException, ExecutionException, RetryException {
        int groupCount = getGroupCount(rooms);
        List<Header> headers = AirbnbApiKeyUtils.getHeaders();
        int retryTime = 3;
        for (int i = 0; i < groupCount; i++) {
            int group = i;
            // 重试三次
            UserPromoListsResponseType response = RetryerBuilder.<UserPromoListsResponseType>newBuilder()
                    .retryIfResult(e -> {
                        if (e.getErrorCode() == 400) {
                            headers.clear();
                            headers.add(new BasicHeader(AirbnbApiKeyUtils.AirbnbApiKey.HEADER_KEY, crawlerApiKey.crawlerApiKey(null)));
                        }
                        return e.getErrorCode() == 400;
                    })
                    .withBlockStrategy(Objects::isNull)
                    .withStopStrategy(StopStrategies.stopAfterAttempt(retryTime))
                    .build().call(() -> queryUserPromoLists(group, lord_id, headers));
            if (Objects.isNull(response) || CollectionUtils.isEmpty(response.getUserPromoListings())) {
                return false;
            }

            response.getUserPromoListings().forEach(userPromoListings -> {
                saveAirbnbRoom(userPromoListings, lord_id);
            });
            Thread.sleep(1 * 1000);
        }
        return true;
    }

    private UserPromoListsResponseType queryUserPromoLists(int group, String lord_id, List<Header> headers) throws IOException {
        String user_lists_url = String.format("%s%s", Constant.HOST_URL, Constant.USER_PROMO_LISTINGS_URL);
        String res = HttpUtils.doGet(String.format(user_lists_url, group * Constant.GROUP_SIZE, lord_id), headers);
        return StringUtils.isNotBlank(res) ? JacksonSerializerUtil.deserialize(res, UserPromoListsResponseType.class) : null;
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
}
