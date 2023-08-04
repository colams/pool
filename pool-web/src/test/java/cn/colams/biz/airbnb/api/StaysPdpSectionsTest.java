package cn.colams.biz.airbnb.api;

import cn.colams.common.CommonTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URISyntaxException;

public class StaysPdpSectionsTest extends CommonTest {

    @Autowired
    StaysPdpSections staysPdpSections;

    @Test
    public void testStaysPdpSections() throws IOException, URISyntaxException {
        String resut = staysPdpSections.staysPdpSections("920878657404836142");
        System.out.println(resut);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.");
    }
}