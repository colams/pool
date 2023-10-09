package cn.colams.common;

import cn.colams.biz.business.BasicConfigBiz;
import cn.colams.dal.mapper.extension.AirbnbLordExtensionMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class RedisUtilsTest extends CommonTest {

    @Autowired
    private BasicConfigBiz basicConfigBiz;
    @Autowired
    private AirbnbLordExtensionMapper lordExtensionMapper;

    @Autowired
    RedisService redisService;

    @Test
    public void redisTest() {
        lordExtensionMapper.queryByLoardId("322112");

        String configValue = basicConfigBiz.getConfigValue("test_key");
        System.out.println(configValue);

        Object value = redisService.get("test");
        System.out.println(value);
        if (Objects.isNull(value)) {
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            redisService.set("test", "jojo");
            value = redisService.get("test");
            System.out.println(value);
        }

        long ttl = redisService.ttl("test");
        System.out.println("expire time: " + ttl);


        Boolean res1 = redisService.setIfAbsent("test", "jojo");
        System.out.println("setIfAbsent time test : " + res1);

        Boolean res2 = redisService.setIfAbsent("zhangzt", "jojo");
        System.out.println("setIfAbsent time zhangzt : " + res2);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

}
