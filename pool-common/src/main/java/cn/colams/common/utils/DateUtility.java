package cn.colams.common.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateUtility {

    /**
     * 时间戳转换为日期格式
     *
     * @param timeStamp
     * @return
     */
    public static LocalDateTime longToLocalDateTime(long timeStamp) {
        return Instant.ofEpochMilli(timeStamp).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 获取时间戳
     *
     * @return
     */
    private long getTimeStamp() {
        return System.currentTimeMillis();
    }

}
