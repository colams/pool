package com.smart.thread.chapter01;

import java.lang.Thread;

/**
 * Created by zhangzt on 2018/10/15.
 */
public class MyThread extends Thread {

    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.print(i + " Nice!");
        }
    }
}
