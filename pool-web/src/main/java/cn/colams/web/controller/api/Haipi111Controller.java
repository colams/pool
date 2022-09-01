package cn.colams.web.controller.api;


import cn.colams.biz.haipi111.Haipi111Biz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/haipi")
public class Haipi111Controller {

    @Autowired
    Haipi111Biz haipi111Biz;

    @ResponseBody
    @GetMapping("/list")
    public Object list() throws Exception {
        return haipi111Biz.list();
    }



}
