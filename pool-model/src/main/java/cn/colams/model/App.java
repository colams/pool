package cn.colams.model;

import cn.colams.model.mythread.MyThread;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        MyThread myThread1 = new MyThread();
        myThread1.start();
        myThread1.start();
        System.out.println("game over");

    }




}
