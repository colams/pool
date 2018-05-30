package cn.colams.web.aspect;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhangzt on 2018/5/29.
 */
@Aspect
@Configuration
public class ExceptionAspect {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionAspect.class);

    // @Around("org.springframework.boot.autoconfigure.web.execution()")
    @Around("execution(* org.springframework.boot.autoconfigure.web.BasicErrorController.errorHtml(..))")

    public void loggerError(){

    }

}
