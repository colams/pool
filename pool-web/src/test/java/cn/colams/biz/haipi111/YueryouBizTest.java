package cn.colams.biz.haipi111;


import cn.colams.biz.dalTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    YueryouBiz yueryouBiz;

    @Test
    public void testPostYueryou() {

        char[] charArray = new char[4];

        for (int i = 236; i <= 9999; i++) {
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
            char[] charArrayTemp = initCharArrayTemp(charArray);
            String pwd = String.copyValueOf(charArrayTemp);
            String result = yueryouBiz.postYueryou(pwd);
            logger.info(result);
            if (result.equalsIgnoreCase("success")) {
                break;
            }
        }
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