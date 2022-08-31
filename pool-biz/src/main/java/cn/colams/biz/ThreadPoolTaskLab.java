package cn.colams.biz;

import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Component
public class ThreadPoolTaskLab {

    @Resource
    private AsyncTaskExecutor poolExecutor;

    private static final int ONE_SECOND = 1000;

    public String getTestResult() {
        long startTime = System.currentTimeMillis();
        String result = "test:";
        stopSuspend(10, "sleep 1");
        CompletableFuture<String> future = getAsyncResult();
        stopSuspend(2, "sleep 2");
        String append = null;
        long cost2 = 0;
        try {
            long startTime2 = System.currentTimeMillis();
            append = future.get(1, TimeUnit.SECONDS);
            cost2 = System.currentTimeMillis() - startTime2;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        result = String.format("%s%s**********%s**********%s", result, append, System.currentTimeMillis() - startTime, cost2);
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

    private CompletableFuture<String> getAsyncResult() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> getResult(), poolExecutor);
        return future;
    }

    private String getResult() {
        stopSuspend(5, "sleep async");
        return "async result";
    }


}
