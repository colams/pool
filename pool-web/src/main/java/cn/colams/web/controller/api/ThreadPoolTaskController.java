package cn.colams.web.controller.api;


import cn.colams.biz.ThreadPoolTaskLab;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "xiancheng ", tags = {"xiancheng"})
@RestController
@RequestMapping("/api/thread")
public class ThreadPoolTaskController {

    @Autowired
    ThreadPoolTaskLab threadPoolTaskLab;

    @PostMapping("/getTestResult")
    public String getTestResult() {
        return threadPoolTaskLab.getTestResult();
    }


}