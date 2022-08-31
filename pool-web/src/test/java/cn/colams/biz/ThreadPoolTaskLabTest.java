package cn.colams.biz;

import cn.colams.biz.threads.ThreadPoolTaskLab;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = dalTest.class)
@SpringBootApplication(scanBasePackages = {"cn.colams"})
public class ThreadPoolTaskLabTest {

    @Autowired
    ThreadPoolTaskLab threadPoolTaskLab;

    @Test
    public void getTestResult() {
        threadPoolTaskLab.getTestResult();
    }


}