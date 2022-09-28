package cn.colams.common.aspects;


import cn.colams.common.utils.JacksonSerializerUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogParamAspect {


    private static final Logger LOGGER = LoggerFactory.getLogger(LogParamAspect.class);

    @Pointcut("@annotation(cn.colams.common.aspects.LogParam)")
    private void log() {
    }

    @Around("log() && @annotation(logParam)")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint, LogParam logParam) throws Throwable {
        Object retValue = null;
        String result = "fail";
        try {
            retValue = joinPoint.proceed();
            result = "success";
        } catch (Throwable throwable) {
            LOGGER.warn("call service throwable", throwable);
            throw throwable;
        } finally {
            logParam(result, joinPoint, retValue);
        }
        return retValue;
    }

    private void logParam(String result, ProceedingJoinPoint joinPoint, Object retValue) {
        try {
            String message = String.format("logParam ============ class:%s;method:%s;result:%s;param:%s;retValue:%s",
                    joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName(), result,
                    JacksonSerializerUtil.serialize(joinPoint.getArgs()), JacksonSerializerUtil.serialize(retValue));
            System.out.println(message);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }


}
