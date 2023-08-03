package cn.colams;

import cn.colams.web.WebApplication;
import org.springframework.boot.SpringApplication;

import java.awt.*;
import java.net.URI;

/**
 * Created by zhangzt on 2018/12/26.
 */
public class ServiceStarter {

    public static void main(String[] args) throws Exception {
        System.setProperty("java.awt.headless", "false");

        SpringApplication.run(WebApplication.class);

        // port 8080 is configured in src/test/resources/application.properties(key: server.port)
        Desktop.getDesktop().browse(new URI("http://127.0.0.1:5001/"));
    }
}
