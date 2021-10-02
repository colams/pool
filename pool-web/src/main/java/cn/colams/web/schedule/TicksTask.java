package cn.colams.web.schedule;

import cn.colams.biz.ticks.TicksBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TicksTask {

    @Autowired
    TicksBiz ticksBiz;

    @Scheduled(cron = "0/10 * * * * ?")
    public void cron() throws Exception {
        ticksBiz.add();
        System.out.println("执行了一次");
    }

}
