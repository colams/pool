package cn.colams.biz.airbnb;

import cn.colams.common.CommonTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CrawlerLordTest extends CommonTest {

    @Autowired
    CrawlerLord crawlerLord;

    @Test
    public void testCrawlerLord() {
        crawlerLord.crawlerLord(true);
        System.out.println("over");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

}