package cn.colams.biz.threads;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncService {

    private static final int ONE_SECOND = 1000;

    @Async
    public String getResult() {
        stopSuspend(3, "sleep async");
        System.out.println("async result");
        return "async result";
    }

    private void stopSuspend(int seconds, String sleepMsg) {
        try {
            Thread.sleep(seconds * ONE_SECOND);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("sleep %s seconds...%s", seconds, sleepMsg));
    }


}
