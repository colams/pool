package cn.colams.biz.haipi111;

import cn.colams.biz.dalTest;
import cn.colams.common.utils.JacksonSerializerUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = dalTest.class)
@SpringBootApplication(scanBasePackages = {"cn.colams"})
public class Haipi111BizTest {


    private static final Logger logger = LoggerFactory.getLogger(Haipi111BizTest.class);

    @Autowired
    Haipi111Biz haipi111Biz;

    @Test
    public void testGetHaipi111() {
        //        String result = haipi111Biz.getHaipi111("1", "501836");
        String result = "test";

        logger.info("test message!!!!");

        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.warn("warn level");
        logger.error("error level");

        System.out.println(result);
    }

    @Test
    public void getHaipiDetailTask() throws InterruptedException {
        Object obj = haipi111Biz.getHaipiDetailTask("510123");
        System.out.println(JacksonSerializerUtil.serialize(obj));
    }
}