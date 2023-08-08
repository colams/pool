package cn.colams.biz.airbnb.api;

import cn.colams.common.CommonTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URISyntaxException;

public class StaysPdpSectionsTest extends CommonTest {

    @Autowired
    StaysPdpSections staysPdpSections;

    /**
     * 爬取房东信息
     *
     * @throws IOException
     * @throws URISyntaxException
     */
    @Test
    public void testStaysPdpSections() throws IOException, URISyntaxException, InterruptedException {
        String resut = staysPdpSections.staysPdpSections("920878657404836142");
        System.out.println(resut);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.");
    }
}