package cn.colams.biz.ticks;

import cn.colams.biz.dalTest;
import cn.colams.biz.business.weight.WeightBiz;
import cn.colams.dal.entity.WeightHistory;
import cn.colams.dal.mapper.extension.WeightHistoryExtensionMapper;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.mockito.Matchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = dalTest.class)
@SpringBootApplication(scanBasePackages = {"cn.colams"})
public class WeightTest {


    @InjectMocks
    WeightBiz weightBiz;

    @Mock
    WeightHistoryExtensionMapper weightHistoryExtensionMapper;

    @Test
    public void list() {
        Mockito.doReturn(Lists.newArrayList()).when(weightHistoryExtensionMapper).selectByExample(any());
        Object resutl = weightBiz.list();
        System.out.print(((List) resutl).size());
    }

    @Test
    public void add() {
        WeightHistory weight = new WeightHistory();
        Mockito.doReturn(1).when(weightHistoryExtensionMapper).insertSelective(any());
        boolean resutl = weightBiz.insertOrUpdate(weight);
        System.out.print(resutl);
    }
}