package cn.colams.biz.airbnb.api;

import cn.colams.common.CommonTest;
import cn.colams.common.dto.airbnb.CommonResponseType;
import cn.colams.common.dto.airbnb.entity.StaySearchData;
import cn.colams.common.utils.JacksonSerializerUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class StaysSearchTest extends CommonTest {


    @Autowired
    StaysSearch staysSearch;

    @Test
    public void testStaysSearch() throws IOException {
        CommonResponseType<StaySearchData> responseType = staysSearch.staysSearch();
        System.out.println(JacksonSerializerUtil.serialize(responseType));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}