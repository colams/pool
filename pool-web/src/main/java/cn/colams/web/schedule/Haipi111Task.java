package cn.colams.web.schedule;

import cn.colams.biz.haipi111.Haipi111Biz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Haipi111Task extends BaseScheduling {

    @Autowired
    Haipi111Biz haipi111Biz;

    @Scheduled(cron = "0/10 * * * * ?")
    public void cron() {
        try {
            haipi111Biz.getHaipi111("100", "501836");
            System.out.println("执行了一次");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public String getCronTrigger() {
        return "0/5 * * * * ?";
    }
}
