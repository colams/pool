package cn.colams.biz.ticks;

import cn.colams.biz.business.ticks.TicksBiz;
import cn.colams.biz.dalTest;
import cn.colams.dal.mapper.extension.TicksExtensionMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Matchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = dalTest.class)
@SpringBootApplication(scanBasePackages = {"cn.colams"})
public class TicksBizTest {

    @InjectMocks
    TicksBiz ticksBiz;
    @Mock
    TicksExtensionMapper ticksExtensionMapper;

    @Test
    public void list() {
    }

    @Test
    public void add() throws Exception {
        Mockito.doReturn(1).when(ticksExtensionMapper).insertSelective(any());
        boolean result = ticksBiz.add();
        System.out.print(result);
    }
}