package cn.colams.common.utils;

import cn.colams.common.aspects.LogParam;
import cn.colams.common.aspects.Metric;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class HttpUtils {
    @Metric
    @LogParam
    public static String postForm(String url, List<NameValuePair> formParams) throws IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        UrlEncodedFormEntity ef = new UrlEncodedFormEntity(formParams);
        httpPost.setEntity(ef);

        CloseableHttpResponse httpResponse = httpclient.execute(httpPost);
        String result = EntityUtils.toString(httpResponse.getEntity());
        return result;
    }

    @Metric
    @LogParam
    public static String doGet(String url, List<Header> headers) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        if (!CollectionUtils.isEmpty(headers)) {
            httpGet.setHeaders(headers.toArray(new Header[headers.size()]));
        }
        CloseableHttpResponse httpResponse = httpclient.execute(httpGet);
        String result = EntityUtils.toString(httpResponse.getEntity());
        return result;
    }

    @Metric
    @LogParam
    public static String doGet(String url, List<NameValuePair> list, List<Header> headers) throws IOException, URISyntaxException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        URIBuilder builder = new URIBuilder(url);
        builder.setParameters(list);
        HttpGet httpGet = new HttpGet(builder.build());
        if (!CollectionUtils.isEmpty(headers)) {
            httpGet.setHeaders(headers.toArray(new Header[headers.size()]));
        }
        CloseableHttpResponse httpResponse = httpclient.execute(httpGet);
        String result = EntityUtils.toString(httpResponse.getEntity());
        return result;
    }

    @Metric
    @LogParam
    public static String doPost(String url, String data, List<Header> headers) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        if (!CollectionUtils.isEmpty(headers)) {
            httpPost.setHeaders(headers.toArray(new Header[headers.size()]));
        }
        StringEntity entity = new StringEntity(data);
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");//发送json数据需要设置contentType
        httpPost.setEntity(entity);
        CloseableHttpResponse httpResponse = httpclient.execute(httpPost);
        String result = EntityUtils.toString(httpResponse.getEntity());
        return result;
    }


}
