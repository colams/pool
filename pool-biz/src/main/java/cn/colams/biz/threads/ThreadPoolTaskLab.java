package cn.colams.biz.threads;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@Component
public class ThreadPoolTaskLab {

    @Resource
    private Executor poolExecutor;

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
            append = future.get();
            cost2 = System.currentTimeMillis() - startTime2;
        } catch (Exception e) {
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
        System.out.println(String.format("%s:sleep %s seconds...%s", Thread.currentThread().getName(), seconds, sleepMsg));
    }

    private CompletableFuture<String> getAsyncResult() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> getResult(), poolExecutor).whenComplete((res, exp) -> {
            if (Objects.nonNull(exp)) {
                System.out.println(String.format("%s:%s,%s", Thread.currentThread().getName(), res, exp.getMessage()));
            } else {
                System.out.println(String.format("%s:%s", Thread.currentThread().getName(), res));
            }

        });
        return future;
    }

    private String getResult() throws RuntimeException {
        stopSuspend(5, "sleep async");
        throw new RuntimeException("ssadfasd");
        // return "async result";
    }


}
