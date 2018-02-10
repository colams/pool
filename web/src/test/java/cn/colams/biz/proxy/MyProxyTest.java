package cn.colams.biz.proxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MyProxyTest {

    private static MyProxy myProxy;

    static {
        myProxy = new MyProxy();
    }

    @Test
    public void main() {
        myProxy.main();
    }

}