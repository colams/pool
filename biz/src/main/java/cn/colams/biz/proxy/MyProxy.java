package cn.colams.biz.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

/**
 *
 */
public class MyProxy {

    private final static Logger logger = LoggerFactory.getLogger(MyProxy.class);

    /**
     * 测试使用代理
     */
    public static void main(String[] args ) {
        logger.info("my proxy main enter:");
        try {

            Proxy proxy = null;
            String ip = "127.0.0.1";
            int port = 8888;
            String uri = "http://www.baidu.com";
            String encoding = "UTF-8";
            proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
            URL url = new URL(uri);

            HttpURLConnection action = (HttpURLConnection) url.openConnection(proxy);  //使用代理打开网页
            InputStream in = action.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in, encoding));
            StringBuilder sb = new StringBuilder();
            String lin = System.getProperty("line.separator");
            for (String temp = br.readLine(); temp != null; temp = br.readLine()) {
                sb.append(temp + lin);
            }
            br.close();
            in.close();
            // System.out.println(sb);
            logger.error(sb.toString());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

}

