package cn.colams.web.restcontroller;


import cn.colams.biz.threads.ThreadPoolTaskLab;
import cn.colams.biz.threads.ThreadPoolTaskTest;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "线程 ", tags = {"线程"})
@RestController
@RequestMapping("/api/thread")
public class ThreadPoolTaskController {

    @Autowired
    ThreadPoolTaskLab threadPoolTaskLab;

    @Autowired
    ThreadPoolTaskTest threadPoolTaskTest;

    @PostMapping("/getTestResult")
    public String getTestResult() {
        return threadPoolTaskLab.getTestResult();
    }


    @PostMapping("/getTestResult2")
    public String getTestResult2() {
        return threadPoolTaskTest.getTestResult();
    }


}