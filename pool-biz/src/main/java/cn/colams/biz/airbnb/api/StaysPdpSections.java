package cn.colams.biz.airbnb.api;

import cn.colams.common.airbnb.AirbnbApiKeyUtils;
import cn.colams.common.dto.airbnb.entity.LocationSection;
import cn.colams.common.utils.Base64Utils;
import cn.colams.common.utils.HttpUtils;
import cn.colams.common.utils.JacksonSerializerUtil;
import cn.colams.common.utils.RegexUtils;
import cn.colams.dal.entity.Airbnb;
import cn.colams.dal.entity.AirbnbLord;
import cn.colams.dal.mapper.extension.AirbnbExtensionMapper;
import cn.colams.dal.mapper.extension.AirbnbLordExtensionMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取房东信息
 */
@Component
public class StaysPdpSections {

    private static final Logger LOGGER = LoggerFactory.getLogger(StaysPdpSections.class);

    @Autowired
    private AirbnbExtensionMapper airbnbExtensionMapper;

    @Autowired
    private AirbnbLordExtensionMapper airbnbLordExtensionMapper;


    public String staysPdpSections() throws IOException, URISyntaxException, InterruptedException {
        return staysPdpSections(null);
    }

    public String staysPdpSections(String roomId) throws IOException, URISyntaxException, InterruptedException {
        List<Airbnb> airbnbs = airbnbExtensionMapper.selectAllRooms(roomId);
        for (Airbnb airbnb : airbnbs) {
            String queryID = getQueryId(airbnb.getRoomId());
            String url = "https://zh.airbnb.com/api/v3/StaysPdpSections";
            List<NameValuePair> list = getUrlTemplate(queryID);
            String result = HttpUtils.doGet(url, list, AirbnbApiKeyUtils.getHeaders());
            String address = getAddress(result);
            if (StringUtils.isEmpty(address)) {
                continue;
            }
            refreshCityInfo(airbnb, address);
            LOGGER.info(address);
            Thread.sleep(1000);
        }
        return "success";
    }

    private String getAddress(String inputText) {
        String regex = "(\\{\"__typename\":\"LocationSection\".*?})},\\{";
        String jsonPart = RegexUtils.getValueByRegex(regex, inputText);
        if (StringUtils.isBlank(jsonPart)) {
            return "";
        }
        LocationSection locationSection = JacksonSerializerUtil.deserialize(jsonPart, LocationSection.class);
        String address = "";
        if (!CollectionUtils.isEmpty(locationSection.getPreviewLocationDetails())) {
            address = locationSection.getPreviewLocationDetails().get(0).getTitle();
        } else {
            address = locationSection.getSubtitle();
        }
        return address;
    }

    private boolean refreshCityInfo(Airbnb airbnb, String address) {

        AirbnbLord airbnbLord = airbnbLordExtensionMapper.queryByLoardId(airbnb.getLordId());
        airbnbLord.setCity(address);
        airbnbLordExtensionMapper.updateByPrimaryKeySelective(airbnbLord);

        airbnb.setrState("1");
        airbnbExtensionMapper.updateByPrimaryKeySelective(airbnb);
        return true;
    }

    private List<NameValuePair> getUrlTemplate(String queryID) {
        String variables = "{\"id\":\"%s\",\"pdpSectionsRequest\":{\"adults\":\"1\",\"layouts\":[\"SIDEBAR\",\"SINGLE_COLUMN\"],\"p3ImpressionId\":\"p3_1691141850_Bskl3b6izuyuSzO+\",\"sectionIds\":null}}";

        String extensions = "{\"persistedQuery\":{\"version\":1,\"sha256Hash\":\"8d81cb13cad5ae18d52f3552f60f081b8c6d5221bafd7006150d6ba594574779\"}}";

        List<NameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("operationName", "StaysPdpSections"));
        list.add(new BasicNameValuePair("locale", "zh"));
        list.add(new BasicNameValuePair("currency", "SGD"));
        list.add(new BasicNameValuePair("variables", String.format(variables, queryID)));
        list.add(new BasicNameValuePair("extensions", extensions));
        return list;
    }

    private String getQueryId(String roomId) {
        return Base64Utils.getBase64Encode(String.format("StayListing:%s", roomId));
    }

}
