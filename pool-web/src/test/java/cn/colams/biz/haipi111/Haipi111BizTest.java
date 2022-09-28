package cn.colams.biz.haipi111;

import cn.colams.biz.dalTest;
import junit.framework.TestCase;
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
public class Haipi111BizTest {

    @Autowired
    Haipi111Biz haipi111Biz;

    @Test
    public void testGetHaipi111() throws IOException {
        String result = haipi111Biz.getHaipi111("1", "501836");
        System.out.println(result);
    }
}