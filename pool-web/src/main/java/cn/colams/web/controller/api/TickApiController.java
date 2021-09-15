package cn.colams.web.controller.api;


import cn.colams.biz.ticks.TicksBiz;
import cn.colams.dal.entity.Ticks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tick")
public class TickApiController {


    @Autowired
    public TicksBiz ticksBiz;

    @ResponseBody
    @GetMapping("/list")
    public Object list() throws Exception {
        return ticksBiz.list();
    }

    @ResponseBody
    @RequestMapping("/addOrUpdate")
    public Object addOrUpdate(@RequestBody Ticks data) throws Exception {
        if (data == null || data.getTick() == null) {
            return "parameter error";
        }

        if (data.getId() == null) {
            return ticksBiz.add();
        } else {
            return ticksBiz.update(data);
        }
    }

}
