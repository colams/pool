package com.smart.thread.chapter01;

/**
 * Created by zhangzt on 2018/10/15.
 */
public class Program1 {

    public static void main(String[] args) {



        new Thread(new Printer("Good")).start();
        new Thread(new Printer("Nice")).start();

//        MyThread myThread = new MyThread();
//        myThread.start();
//
//        for (int i = 0; i < 10000; i++) {
//            System.out.print(i + "  Good!");
//        }

    }
}
