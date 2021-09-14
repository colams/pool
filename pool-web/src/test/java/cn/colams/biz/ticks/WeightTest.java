package cn.colams.biz.ticks;

import cn.colams.biz.dalTest;
import cn.colams.biz.weight.WeightBiz;
import cn.colams.dal.entity.WeightHistory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = dalTest.class)
@SpringBootApplication(scanBasePackages = {"cn.colams"})
public class WeightTest {


    @Autowired
    WeightBiz weightBiz;

    @Test
    public void list() {
        Object resutl = weightBiz.list();
        System.out.print(((List) resutl).size());
    }

    @Test
    public void add(WeightHistory weight) {
        boolean resutl = weightBiz.insert(weight);
        System.out.print(resutl);
    }
}