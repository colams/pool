package cn.colams.biz.airbnb.api;

import cn.colams.common.airbnb.AirbnbApiKeyUtils;
import cn.colams.common.utils.Base64Utils;
import cn.colams.common.utils.HttpUtils;
import cn.colams.dal.entity.Airbnb;
import cn.colams.dal.mapper.extension.AirbnbExtensionMapper;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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


    public String staysPdpSections() throws IOException, URISyntaxException {
        return staysPdpSections(null);
    }

    public String staysPdpSections(String roomId) throws IOException, URISyntaxException {
        List<Airbnb> airbnbs = airbnbExtensionMapper.selectRoom2Process(roomId);
        for (Airbnb airbnb : airbnbs) {
            String queryID = getQueryId(airbnb.getRoomId());
            String url = "https://zh.airbnb.com/api/v3/StaysPdpSections";
            List<NameValuePair> list = getUrlTemplate(queryID);
            String result = HttpUtils.doGet(url, list, AirbnbApiKeyUtils.getHeaders());
            LOGGER.info(result);
        }
        return "success";
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
