package com.smart.algorithm.searh;

/**
 * Created by zhangzt on 2018/10/29.
 * 二分查找
 */
public class binary_search {

    public static int binarySearh(Integer[] list, int item) {
        int low = 0;
        int high = list.length;

        int i = 0;
        int index = -1;
        while (low <= high) {
            i++;
            int mid = (low + high) / 2;
            int guess = list[mid];

            if (guess == item) {
                // return mid;
                index = mid;
                break;
            } else if (guess > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println("times:" + i);
        return index;
    }


}
