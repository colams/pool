package cn.colams.web.controller;

import cn.colams.common.setting.PageNameSetting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by zhangzt on 2018/2/9.
 */
@Controller
public class IndexController {

    @GetMapping(value = "/")
    public String root() {
        String page = PageNameSetting.DefaultPage;
        System.out.println(page);
        return page;
    }

    @GetMapping("/hello")
    public String hello(Map<String, Object> map) throws Exception {

        map.put("name", "colams");

        return "hello";
    }

    @GetMapping("/about")
    public String about() {
        String page = PageNameSetting.AboutPage;
        System.out.println(page);
        return page;
    }


    @ResponseBody
    @GetMapping("/error")
    public String error() {
        String page = PageNameSetting.ErrorPage;
        System.out.println(page);
        return page;
    }

    @GetMapping("/change_password")
    public String changePassword() {
        String page = PageNameSetting.ChangePasswordPage;
        System.out.println(page);
        return page;
    }
}
