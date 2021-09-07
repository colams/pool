package cn.colams.web.controller.api;


import cn.colams.biz.ticks.TicksBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/add")
    public Object add() throws Exception {
        return ticksBiz.add();
    }

}
