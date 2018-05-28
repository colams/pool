package cn.colams.biz.proxy;

import cn.colams.dal.dao.TicksEntityDao;
import cn.colams.dal.extension.TicksEntityExtensionDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


// @RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = dalTest.class)
@SpringBootApplication(scanBasePackages = {"cn.colams"})
public class dalTest {

    @Autowired
    TicksEntityExtensionDao ticksEntityExtensionDao;

//    @Autowired
//    TicksEntityDao ticksEntityDao;

    @Test
    public void main() {
        Object obj = ticksEntityExtensionDao.selectByPrimaryKey(1);
        System.out.println(obj);
    }

}