package cn.colams.biz.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class MyProxy {

    private final static Logger logger = LoggerFactory.getLogger(MyProxy.class);

    public void main() {
        logger.info("my proxy main enter:");
        System.out.println("hello world");
    }
}
