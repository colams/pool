package cn.colams.biz.airbnb;

import cn.colams.common.CommonTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CrawlerApiKeyTest extends CommonTest {

    @Autowired
    CrawlerApiKey crawlerApiKey;

    @Test
    public void testCrawlerApiKey() {
        String k = crawlerApiKey.crawlerApiKey("");
        System.out.println(k);
    }
}