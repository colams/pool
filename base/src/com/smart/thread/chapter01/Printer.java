package com.smart.thread.chapter01;

/**
 * Created by zhangzt on 2018/10/15.
 */
public class Printer implements Runnable {
    private String message;

    public Printer(String message) {
        this.message = message;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(i + "  " + message);
        }
    }
}
