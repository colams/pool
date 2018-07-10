package cn.colams.web.controller;

import cn.colams.common.setting.PageNameSetting;
import cn.colams.biz.weight.WeightBiz;
import cn.colams.dal.entity.WeightHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

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
    public List<WeightHistory> list() throws Exception {
        return weightBiz.list();
    }

    @ResponseBody
    @GetMapping("/insert")
    public Object insert() throws Exception {
        return weightBiz.insert();
    }

    @GetMapping("/")
    public String index(ModelMap map) {
        map.put("hello", "world");
        return PageNameSetting.DailyWeightListPage;
    }
}
