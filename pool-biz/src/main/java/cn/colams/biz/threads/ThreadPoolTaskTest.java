package cn.colams.biz.threads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;

@Component
public class ThreadPoolTaskTest {

    @Autowired
    AsyncService asyncService;

    private static final int ONE_SECOND = 1000;

    public String getTestResult() {
        long startTime = System.currentTimeMillis();
        String result = "test:";
        stopSuspend(2, "sleep 1");
        String res = asyncService.getResult();
        stopSuspend(2, "sleep 2");
        result = String.format("%s%s*********%s", result, System.currentTimeMillis() - startTime, res);
        System.out.println(result);
        return result;
    }

    private void stopSuspend(int seconds, String sleepMsg) {
        try {
            Thread.sleep(seconds * ONE_SECOND);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("sleep %s seconds...%s", seconds, sleepMsg));
    }

    @Async
    public String getResult() {
        stopSuspend(5, "sleep async");
        return "async result";
    }


}
