package cn.colams.common.aspects;

import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MetricAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(MetricAspect.class);

    @Pointcut("@annotation(cn.colams.common.aspects.Metric)")
    private void log() {
    }

    @Around("log() && @annotation(metric)")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint, Metric metric) throws Throwable {
        Object retValue;
        String result = "fail";
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            retValue = joinPoint.proceed();
            result = "success";
        } catch (Throwable throwable) {
            LOGGER.warn("call service throwable", throwable);
            throw throwable;
        } finally {
            stopWatch.stop();
            doMetric(stopWatch.getTime(), result, joinPoint);
        }
        return retValue;
    }

    private void doMetric(long intervals, String result, ProceedingJoinPoint joinPoint) {
        try {
            String message = String.format("doMetric ============ class:%s;method:%s;cost:%s;result:%s",
                    joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName(), intervals, result);
            System.out.println(message);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }


}
