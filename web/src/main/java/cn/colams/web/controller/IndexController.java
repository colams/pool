package cn.colams.web.controller;

import cn.colams.ticks.TicksBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by zhangzt on 2018/2/9.
 */
@Controller
public class IndexController {

    @Value("${spring.datasource.url}")
    private String url;

    @Autowired
    public TicksBiz ticksBiz;

    @ResponseBody
    @RequestMapping("/")
    public String root() {
        return "hello world";
    }

    @ResponseBody
    @RequestMapping("/list")
    public Object list() throws Exception {
        return ticksBiz.list();
    }

    @ResponseBody
    @RequestMapping("/add")
    public Object add() throws Exception {
        return ticksBiz.add();
    }

    @ResponseBody
    @RequestMapping("/conn")
    public String conn() throws Exception {
        return url;
    }

    @RequestMapping("/hello")
    public String hello(Map<String, Object> map) throws Exception {

        map.put("name", "colams");

        return "hello";
    }
}
