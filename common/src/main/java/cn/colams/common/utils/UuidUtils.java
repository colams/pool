package cn.colams.common.utils;


import java.util.UUID;

public class UuidUtils {

    public static String getUuid() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
}
