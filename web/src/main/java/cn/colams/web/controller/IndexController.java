package cn.colams.web.controller;

import cn.colams.common.setting.PageNameSetting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by zhangzt on 2018/2/9.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String root() {
        System.out.println(PageNameSetting.DefaultPage);
        return PageNameSetting.DefaultPage;
    }


    @GetMapping("/hello")
    public String hello(Map<String, Object> map) throws Exception {

        map.put("name", "colams");

        return "hello";
    }
}
