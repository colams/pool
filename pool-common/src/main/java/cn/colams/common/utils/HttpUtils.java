package cn.colams.common.utils;

import cn.colams.common.aspects.LogParam;
import cn.colams.common.aspects.Metric;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class HttpUtils {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    private static String url = "http://haipi111.com/lib/info.php";

    @Metric
    @LogParam
    public static String postForm(List<NameValuePair> formParams) throws IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        UrlEncodedFormEntity ef = new UrlEncodedFormEntity(formParams);
        httpPost.setEntity(ef);

        CloseableHttpResponse httpResponse = httpclient.execute(httpPost);
        String result = EntityUtils.toString(httpResponse.getEntity());
        logger.info(result);
        return result;
    }
}
