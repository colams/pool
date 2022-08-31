package cn.colams.web.schedule;

import cn.colams.biz.ticks.TicksBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
//@EnableScheduling
//public class TicksTask implements SchedulingConfigurer {
public class TicksTask {

    @Autowired
    TicksBiz ticksBiz;

    //    @Scheduled(cron = "0/10 * * * * ?")
    // {"tishi":"查看成功！","flag":"1","qq":"113279736","lxr":"云总","wx":"","dh":"","dz":"上海市区上门"}
    // {"tishi":"查看成功！","flag":"1","qq":"2632108095","lxr":"顺其自然","wx":"","dh":"","dz":"兼职上门，松江九亭附近"}
    // {"tishi":"查看成功！","flag":"1","qq":"","lxr":"千寻","wx":"hkyzfc1519","dh":"","dz":"上海市徐汇区"}
    public void cron() {
        try {
            ticksBiz.add();
            System.out.println("执行了一次");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    @Override
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
