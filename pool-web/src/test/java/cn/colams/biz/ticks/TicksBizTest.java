package cn.colams.biz.ticks;

import cn.colams.biz.dalTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = dalTest.class)
@SpringBootApplication(scanBasePackages = {"cn.colams"})
public class TicksBizTest {

    @Autowired
    TicksBiz ticksBiz;

    @Test
    public void list() {
    }

    @Test
    public void add() throws Exception {
        boolean result = ticksBiz.add();
        System.out.print(result);
    }
}