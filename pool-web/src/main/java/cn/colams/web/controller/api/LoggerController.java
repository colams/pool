package cn.colams.web.controller.api;

import cn.colams.biz.weight.WeightBiz;
import cn.colams.dal.entity.WeightHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.warn("warn level");
        logger.error("error level");
        return "success";
    }

}
