package cn.colams.common.utils;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpUtils {


    private static String url = "http://haipi111.com/lib/info.php";

    public static String postForm() throws IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> formParams = new ArrayList<>();
        formParams.add(new BasicNameValuePair("uid", "100"));
        formParams.add(new BasicNameValuePair("infoid", "501836"));
        formParams.add(new BasicNameValuePair("action", "ckinfo"));
        formParams.add(new BasicNameValuePair("t", "0.013940201448949585"));
        UrlEncodedFormEntity ef = new UrlEncodedFormEntity(formParams);
        httpPost.setEntity(ef);

        CloseableHttpResponse httpResponse = httpclient.execute(httpPost);
        String result = EntityUtils.toString(httpResponse.getEntity());
        System.out.println(result);
        return result;
    }
}
