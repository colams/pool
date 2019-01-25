package com.smart.algorithm;

import com.smart.algorithm.searh.binary_search;

/**
 * Created by zhangzt on 2018/10/29.
 */
public class Program {

    public static void main(String[] args) {
        binarySeachTest();
    }

    public static void binarySeachTest() {
        Integer[] list = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39};
        int item = 9;
        int index = binary_search.binarySearh(list, item);
        System.out.println("current index :" + index);
    }
}

