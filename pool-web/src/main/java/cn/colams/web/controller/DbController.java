package cn.colams.web.controller;

import cn.colams.biz.ticks.TicksBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/db")
public class DbController {

    @Value("${spring.datasource.url}")
    private String url;

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

    @ResponseBody
    @GetMapping("/conn")
    public String conn() throws Exception {
        return url;
    }
}
