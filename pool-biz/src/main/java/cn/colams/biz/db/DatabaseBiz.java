package cn.colams.biz.db;

import cn.colams.common.utils.ResultSetUtils;
import cn.colams.dal.DataSourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@Component
public class DatabaseBiz {
    @Autowired
    DataSourceConfig dataSourceConfig;

    public List<Map<Integer, List<String>>> getDatabaseList() throws Exception {
        DataSource ds = dataSourceConfig.dataSource();
        Connection conn = ds.getConnection();
        DatabaseMetaData dbmd = conn.getMetaData();
        ResultSet ts = dbmd.getTableTypes();


        return ResultSetUtils.getResultSet(ts);
    }


}
