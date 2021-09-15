package cn.colams.biz;

import cn.colams.dal.entity.WeightHistoryExample;
import cn.colams.dal.mapper.extension.TicksExtensionMapper;
import cn.colams.dal.mapper.extension.WeightHistoryExtensionMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


// @RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = dalTest.class)
@SpringBootApplication(scanBasePackages = {"cn.colams",
        "cn.colams.dal"})
public class dalTest {

    @Autowired
    TicksExtensionMapper ticksEntityMapper;
    @Autowired
    WeightHistoryExtensionMapper weightHistoryMapper;

//    @Autowired
//    TicksEntityDao ticksEntityDao;

    @Test
    public void main() {
        try {
            //        Object obj = ticksEntityExtensionDao.selectByPrimaryKey(1);
//        // Object obj = ticksEntityExtensionDao.selectByExample(1);
//        System.out.println(obj);

            WeightHistoryExample example = new WeightHistoryExample();
            Object obj = weightHistoryMapper.selectByExample(example);
            System.out.println(obj);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}