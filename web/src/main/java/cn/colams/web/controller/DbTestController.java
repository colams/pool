package cn.colams.web.controller;

import cn.colams.biz.ticks.TicksBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping("/list1")
    public Object list() throws Exception {
        return ticksBiz.list();
    }

    @ResponseBody
    @RequestMapping("/add1")
    public Object add() throws Exception {
        return ticksBiz.add();
    }

    @ResponseBody
    @RequestMapping("/conn1")
    public String conn() throws Exception {
        return url;
    }

    @RequestMapping("/hello1")
    public String hello(Map<String, Object> map) throws Exception {

        map.put("name", "colams");

        return "hello";
    }


}
