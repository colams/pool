package cn.colams.model.mythread;

public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        System.out.println("My Thread:" + Thread.currentThread().getName());
    }
}
