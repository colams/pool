package cn.colams.common.utils;

public class CommonUtils {

    public static int aggregationInter(long totalCount, long groupSize) {
        int append = totalCount % groupSize > 0 ? 1 : 0;
        Long group = totalCount / groupSize;
        return Long.valueOf((group + append)).intValue();
    }

}
