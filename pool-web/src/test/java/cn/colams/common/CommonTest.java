package cn.colams.common;

import cn.colams.web.WebApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
public class CommonTest {

    @Test
    public void testEntry() {
        BigDecimal[] array = new BigDecimal[]{new BigDecimal("2.1"), new BigDecimal("3.8")};
        int max = 100;
        test(array, max);
    }

    private void test(BigDecimal[] array, int max) {
        int[] result = new int[array.length];

        BigDecimal totalMult = BigDecimal.ONE;
        for (BigDecimal i : array) {
            totalMult = totalMult.multiply(i);
        }

        for (int i = 0; i < array.length; i++) {
            
        }


        BigDecimal totalTempDou = BigDecimal.ZERO;
        for (int i = 0; i < array.length; i++) {
            BigDecimal tempDou = BigDecimal.ONE;
            for (int j = 0; j < array.length; j++) {
                if (i != j) {
                    tempDou = tempDou.multiply(array[j]);
                }
            }
            totalTempDou = totalTempDou.add(tempDou);
        }

        BigDecimal res = totalMult.multiply(new BigDecimal(max)).divide(totalMult.add(totalTempDou), RoundingMode.HALF_DOWN);
        System.out.println(res);
    }
}
