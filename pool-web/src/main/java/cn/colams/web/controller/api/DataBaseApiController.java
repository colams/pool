package cn.colams.web.controller.api;

import cn.colams.biz.db.DatabaseBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/database")
public class DataBaseApiController {


    @Autowired
    DatabaseBiz databaseBiz;
    @Value("${spring.datasource.url}")
    private String url;

    @ResponseBody
    @GetMapping("/conn")
    public String conn() {
        return url;
    }


    @RequestMapping("/tables")
    public Object getTableTypes() throws Exception {
        return databaseBiz.getTableTypes();
    }


    @RequestMapping("/catalogs")
    public Object getCatalogs() throws Exception {
        return databaseBiz.getCatalogs();
    }

    @RequestMapping("/table")
    public Object getTables() throws Exception {
        return databaseBiz.getTables();
    }

    @RequestMapping("/columns")
    public Object getColumns() throws Exception {
        return databaseBiz.getColumns();
    }


}
