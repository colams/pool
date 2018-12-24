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
        Integer[] list = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int item = 9;
        int index = binary_search.binarySearh(list, item);
        System.out.println("current index :" + index);
    }
}

