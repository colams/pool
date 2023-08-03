package cn.colams.common.airbnb;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.util.ArrayList;
import java.util.List;

public class AirbnbApiKeyUtils {

    public static List<Header> getHeaders() {

        List<Header> headers = new ArrayList<>();
        headers.add(new BasicHeader(AirbnbApiKey.HEADER_KEY, AirbnbApiKey.HEADER_VALUE));
        return headers;
    }

    public interface AirbnbApiKey {
        String HEADER_KEY = "X-Airbnb-API-Key";
        String HEADER_VALUE = "d306zoyjsyarp7ifhu67rjxn52tv0t20";
    }

}
