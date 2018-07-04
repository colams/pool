package cn.colams.web.controller;

import cn.colams.biz.weight.WeightBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhangzt on 2018/7/4.
 */
@Controller
@RequestMapping("/weight")
public class WeightController {


    @Autowired
    public WeightBiz weightBiz;

    @ResponseBody
    @GetMapping("/list")
    public Object list() throws Exception {
        return weightBiz.list();
    }

    @ResponseBody
    @GetMapping("/ticketList")
    public Object ticketList() throws Exception {
        return weightBiz.ticketList();
    }

    @ResponseBody
    @GetMapping("/insert")
    public Object insert() throws Exception {
        return weightBiz.insert();
    }
}
