package cn.colams.web.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zhangzt on 2018/2/9.
 */
@ControllerAdvice(basePackages = "cn.colams.web.controller")
public class CustomizedExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(CustomizedExceptionHandler.class);

    @ExceptionHandler(value = RuntimeException.class)
    public ModelAndView handler(Exception e) {
        String message = String.format("sorry:%s", e.getMessage());
        logger.error(message, e);

        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("message", message);

        return modelAndView;
    }
}
