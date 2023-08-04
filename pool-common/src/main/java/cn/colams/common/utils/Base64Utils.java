package cn.colams.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Base64;

public class Base64Utils {


    /**
     * Base64加密
     *
     * @param str
     * @return
     */
    public static String getBase64Encode(String str) {
        if (StringUtils.isBlank(str)) {
            return StringUtils.EMPTY;
        }
        return Base64.getEncoder().encodeToString(str.getBytes());
    }

    /**
     * Base64解密
     *
     * @param encodeStr
     * @return
     */
    public static String getBase64Decode(String encodeStr) {
        if (StringUtils.isBlank(encodeStr)) {
            return StringUtils.EMPTY;
        }
        return new String(Base64.getDecoder().decode(encodeStr));
    }


    public static void main(String[] args) {
//        String encodeStr = "eyJzZWN0aW9uX29mZnNldCI6MSwiaXRlbXNfb2Zmc2V0IjoxOCwidmVyc2lvbiI6MX0=";
//        String decodeStr = getBase64Decode(encodeStr);
//        String encodeStr2 = getBase64Encode(decodeStr);
        System.out.println(getBase64Decode("eyJzZWN0aW9uX29mZnNldCI6MCwiaXRlbXNfb2Zmc2V0IjowLCJ2ZXJzaW9uIjoxfQ=="));
        System.out.println(getBase64Decode("eyJzZWN0aW9uX29mZnNldCI6MSwiaXRlbXNfb2Zmc2V0IjoxOCwidmVyc2lvbiI6MX0="));
        System.out.println(getBase64Decode("eyJzZWN0aW9uX29mZnNldCI6MSwiaXRlbXNfb2Zmc2V0IjozNiwidmVyc2lvbiI6MX0="));
        System.out.println(getBase64Decode("eyJzZWN0aW9uX29mZnNldCI6MSwiaXRlbXNfb2Zmc2V0Ijo1NCwidmVyc2lvbiI6MX0="));
        System.out.println(getBase64Decode("eyJzZWN0aW9uX29mZnNldCI6MSwiaXRlbXNfb2Zmc2V0Ijo3MiwidmVyc2lvbiI6MX0="));
        System.out.println(getBase64Decode("eyJzZWN0aW9uX29mZnNldCI6MSwiaXRlbXNfb2Zmc2V0Ijo5MCwidmVyc2lvbiI6MX0="));
        System.out.println(getBase64Decode("eyJzZWN0aW9uX29mZnNldCI6MSwiaXRlbXNfb2Zmc2V0IjoxMDgsInZlcnNpb24iOjF9"));
        System.out.println(getBase64Decode("eyJzZWN0aW9uX29mZnNldCI6MSwiaXRlbXNfb2Zmc2V0IjoxMjYsInZlcnNpb24iOjF9"));
        System.out.println(getBase64Decode("eyJzZWN0aW9uX29mZnNldCI6MSwiaXRlbXNfb2Zmc2V0IjoxNDQsInZlcnNpb24iOjF9"));
        System.out.println(getBase64Decode("eyJzZWN0aW9uX29mZnNldCI6MSwiaXRlbXNfb2Zmc2V0IjoxNjIsInZlcnNpb24iOjF9"));
        System.out.println(getBase64Decode("eyJzZWN0aW9uX29mZnNldCI6MSwiaXRlbXNfb2Zmc2V0IjoxODAsInZlcnNpb24iOjF9"));
        System.out.println(getBase64Decode("eyJzZWN0aW9uX29mZnNldCI6MSwiaXRlbXNfb2Zmc2V0IjoxOTgsInZlcnNpb24iOjF9"));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

}
