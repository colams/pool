package cn.colams.web.controller;

import cn.colams.common.PageNameSetting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhangzt on 2018/2/9.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String root() {
        return PageNameSetting.DefaultPage;
    }


}
