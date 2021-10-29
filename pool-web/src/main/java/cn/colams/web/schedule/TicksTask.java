package cn.colams.web.schedule;

import cn.colams.biz.ticks.TicksBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@EnableScheduling
public class TicksTask implements SchedulingConfigurer {

    @Autowired
    TicksBiz ticksBiz;

    //    @Scheduled(cron = "0/10 * * * * ?")
    public void cron() {
        try {
            ticksBiz.add();
            System.out.println("执行了一次");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar registrar) {
        registrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                cron();
            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                CronTrigger trigger = new CronTrigger("0/10 * * * * ?");
                Date date = trigger.nextExecutionTime(triggerContext);
                return date;
            }
        });
    }
}
