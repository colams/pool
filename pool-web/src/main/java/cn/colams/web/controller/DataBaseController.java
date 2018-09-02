package cn.colams.web.controller;

import cn.colams.biz.db.DatabaseBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/database")
public class DataBaseController {

    @Autowired
    DatabaseBiz databaseBiz;

    @ResponseBody
    @GetMapping("/list")
    public Object list() throws Exception {
        return null;
    }
}
