package cn.colams.web.controller;

import cn.colams.biz.ticks.TicksBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DbTestController {

    @Value("${spring.datasource.url}")
    private String url;

    @Autowired
    public TicksBiz ticksBiz;


    @ResponseBody
    @GetMapping("/list1")
    public Object list() throws Exception {
        return ticksBiz.list();
    }

    @ResponseBody
    @PostMapping("/add1")
    public Object add() throws Exception {
        return ticksBiz.add();
    }

    @ResponseBody
    @GetMapping("/conn1")
    public String conn() throws Exception {
        return url;
    }

    @GetMapping("/hello1")
    public String hello(Map<String, Object> map) throws Exception {

        map.put("name", "colams");

        return "hello";
    }


}
