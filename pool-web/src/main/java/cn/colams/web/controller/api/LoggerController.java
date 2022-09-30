package cn.colams.web.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangzt on 2018/7/4.
 */
@RestController
@RequestMapping("api/log")
public class LoggerController {

    private static final Logger logger = LoggerFactory.getLogger(LoggerController.class);


    @ResponseBody
    @GetMapping("test")
    public Object test() throws Exception {
        logger.info("test message!!!!");


        MDC.put("test", "value");
        MDC.put("test1", "value");
        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.warn("warn level");
        logger.error("error level");
        return "success";
    }

}
