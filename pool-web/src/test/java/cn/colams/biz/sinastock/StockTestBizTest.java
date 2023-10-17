package cn.colams.biz.sinastock;

import cn.colams.common.CommonTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URISyntaxException;

public class StockTestBizTest extends CommonTest {

    @Autowired
    StockTestBiz stockTestBiz;

    @Test
    public void testQueryStockList() throws IOException, URISyntaxException {
        String result = stockTestBiz.queryStockList();
        System.out.println("======================");
    }
}