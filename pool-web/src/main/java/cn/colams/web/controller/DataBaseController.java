package cn.colams.web.controller;

import cn.colams.biz.db.DatabaseBiz;
import cn.colams.common.setting.PageNameSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class DataBaseController {

    @Autowired
    DatabaseBiz databaseBiz;

    @GetMapping("database/list")
    public String list(Model model) throws Exception {
//        List<Map<Integer, List<String>>> result = databaseBiz.getTables();
//
//        if (result != null && !CollectionUtils.isEmpty(result)) {
//            model.addAttribute("header", result.get(0));
//            model.addAttribute("list", result.subList(1, result.size()));
//        }
        return PageNameSetting.DataBase_List;
    }

    @GetMapping("admin/list")
    public String index(Model map) throws Exception {
        Map user = new HashMap();
        user.put("name", "姓名");
        user.put("age", "年龄");
        user.put("sex", "性别");
        user.put("birthday", "生日");
        user.put("phonenumber", "手机");
        map.addAttribute("userhead", user);
        List userinfo = new ArrayList();
        userinfo.add("周美玲");
        userinfo.add("32");
        userinfo.add("女");
        userinfo.add("1985");
        userinfo.add("19850014665");
        map.addAttribute("userinfo", userinfo);
        List outerList = new ArrayList();
        Map innerMap = new HashMap();
        for (int i = 0; i < 10; i++) {
            innerMap.put("1", i);
            innerMap.put("1", i++);
            i++;
            outerList.add(innerMap);
        }
        map.addAttribute("listmap", outerList);

        return PageNameSetting.DataBase_Index;
    }
}
