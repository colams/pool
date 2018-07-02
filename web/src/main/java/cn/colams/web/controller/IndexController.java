package cn.colams.web.controller;

import cn.colams.common.setting.PageNameSetting;
import cn.colams.common.setting.PageNameSettingV1;
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

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String root() {
        String page = PageNameSettingV1.DefaultPage;
        System.out.println(page);
        return page;
    }

    @RequestMapping(value = "/v", method = {RequestMethod.GET, RequestMethod.POST})
    public String rootV() {
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
        String page = PageNameSettingV1.AboutPage;
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
        String page = PageNameSettingV1.ChangePasswordPage;
        System.out.println(page);
        return page;
    }
}
