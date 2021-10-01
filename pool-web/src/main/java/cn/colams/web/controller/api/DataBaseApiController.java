package cn.colams.web.controller.api;

import cn.colams.biz.db.DatabaseBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@Api(value = "数据库管理controller", tags = {"database"})
@RestController
@RequestMapping("/api/database")
public class DataBaseApiController {

    @Autowired
    DatabaseBiz databaseBiz;
    @Value("${spring.datasource.url}")
    private String url;

    @ApiOperation(value = "数据库连接字符串")
    @PostMapping("/conn")
    public String conn() {
        return url;
    }

    @ApiOperation(value = "查找数据库支持的表的类型")
    @PostMapping("/tabletypes")
    public Object getTableTypes() throws Exception {
        return databaseBiz.getTableTypes();
    }

    @ApiOperation(value = "获取数据库目录")
    @PostMapping("/catalogs")
    public Object getCatalogs() throws Exception {
        return databaseBiz.getCatalogs();
    }

    @ApiOperation(value = "获取当前数据库所有表")
    @PostMapping("/table")
    public Object getTables() throws Exception {
        return databaseBiz.getTables();
    }

    @ApiOperation(value = "获取表中所有的列")
    @PostMapping("/columns")
    public Object getColumns(@RequestParam(required = false) String tableName) throws Exception {
        return databaseBiz.getColumns(tableName);
    }


}
