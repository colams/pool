package cn.colams.biz.haipi111;

import cn.colams.biz.dalTest;
import cn.colams.common.utils.JacksonSerializerUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = dalTest.class)
@SpringBootApplication(scanBasePackages = {"cn.colams",
        "cn.colams.dal"})
public class Haipi111BizTest {

    @Autowired
    Haipi111Biz haipi111Biz;

    @Test
    public void getHaipiDetail() {
        Object obj = haipi111Biz.getHaipiDetail("501836");
        System.out.println(JacksonSerializerUtil.serialize(obj));
    }

    @Test
    public void getHaipiDetailTask() throws InterruptedException {
        Object obj = haipi111Biz.getHaipiDetailTask("510123");
        System.out.println(JacksonSerializerUtil.serialize(obj));
    }
}