package cn.colams.biz.proxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


// @RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyProxy.class)
//@SpringBootApplication(scanBasePackages = {"cn.colams"})
public class MyProxyTest {

    private static MyProxy myProxy;
    private final Logger logger = LoggerFactory.getLogger(MyProxyTest.class);

    static {
        myProxy = new MyProxy();
    }

    @Test
    public void main() {
        try {
            // myProxy.main();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

}