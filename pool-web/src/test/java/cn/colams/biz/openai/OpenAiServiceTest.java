package cn.colams.biz.openai;

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
public class OpenAiServiceTest {


    @Autowired
    OpenAiService openAiService;

    @Test
    public void testGetGlobalState() {
        int code = openAiService.getGlobalState();
        System.out.println(code);
    }
}