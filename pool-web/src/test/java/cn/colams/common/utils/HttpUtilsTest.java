package cn.colams.common.utils;

import cn.colams.biz.dalTest;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = dalTest.class)
@SpringBootApplication(scanBasePackages = {"cn.colams"})
public class HttpUtilsTest {

    @Test
    public void HttpUtilsTest() throws IOException {
//        HttpUtils.postForm(formParams);
    }

    @Test
    public void collectTest() {
        List<String> arrayList = new ArrayList<>();
        arrayList.add(null);
        System.out.println(StringUtils.isBlank(""));


        List<Long> arrayList1 = new ArrayList<>();
        arrayList1.add(123L);
        arrayList1.add(353L);
        arrayList1.forEach(e -> {
            if (e.equals(123L)) {
                e = 789L;
            }
        });


        List<Long> arrayList2 = null;
        Object tem = Optional.ofNullable(arrayList1).map(ls -> ls.stream().filter(e -> e == 123).collect(Collectors.toList())).orElse(Lists.newArrayList());
        System.out.println(tem);

        Object tem2 = Optional.ofNullable(arrayList2).map(ls -> ls.stream().filter(e -> e == 123).collect(Collectors.toList())).orElse(Lists.newArrayList());
        System.out.println(tem2);

        System.out.println(arrayList1);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}