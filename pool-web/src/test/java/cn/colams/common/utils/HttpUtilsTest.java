package cn.colams.common.utils;

import cn.colams.biz.dalTest;
import cn.colams.common.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = dalTest.class)
@SpringBootApplication(scanBasePackages = {"cn.colams"})
public class HttpUtilsTest {

    @Autowired
    RedisService redisService;

    @Test
    public void HttpUtilsTest() throws IOException {
//        HttpUtils.postForm(formParams);
    }

    @Test
    public void redisTest() {
        Object value = redisService.get("test");
        System.out.println(value);
        redisService.set("test", "jojo");
        value = redisService.get("test");
        System.out.println(value);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}