package cn.colams.common.utils;

import cn.colams.biz.dalTest;
import cn.colams.common.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        if (Objects.isNull(value)) {
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            redisService.set("test", "jojo");
            value = redisService.get("test");
            System.out.println(value);
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    @Test
    public void collectTest() {
        List<String> arrayList = new ArrayList<>();
        arrayList.add(null);
        System.out.println(StringUtils.isBlank(""));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}