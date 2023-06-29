package cn.colams.biz.haipi111;

import cn.colams.biz.dalTest;
import cn.colams.common.utils.JacksonSerializerUtil;
import cn.colams.dal.mapper.extension.Haipi111DetailLogExtensionMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Matchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = dalTest.class)
@SpringBootApplication(scanBasePackages = {"cn.colams"})
public class Haipi111BizTest {


    private static final Logger logger = LoggerFactory.getLogger(Haipi111BizTest.class);

    @InjectMocks
    Haipi111Biz haipi111Biz;
    @Mock
    Haipi111DetailLogExtensionMapper haipi111DetailLogExtensionMapper;

    @Test
    public void testGetHaipi1111() {
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

//    @Test
//    public void getHaipiDetailTask() throws InterruptedException {
//        Mockito.doReturn(1).when(haipi111DetailLogExtensionMapper).insertSelective(any());
//        Object obj = haipi111Biz.getHaipiDetailTask("510123");
//        System.out.println(JacksonSerializerUtil.serialize(obj));
//    }

    @Test
    public void testGetHaipi111() {
        Mockito.doReturn(1).when(haipi111DetailLogExtensionMapper).insertSelective(any());
        Object obj = haipi111Biz.getHaipi111("510123", "2323");
        System.out.println(JacksonSerializerUtil.serialize(obj));
    }
}