package cn.colams.biz.db;

import cn.colams.common.utils.ResultSetUtils;
import cn.colams.dal.DataSourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@Component
public class DatabaseBiz {
    @Autowired
    DataSourceConfig dataSourceConfig;

    public List<Map<Integer, List<String>>> getTableTypes() throws Exception {
        DatabaseMetaData dbmd = dataSourceConfig.getDataBaseMetaData();
        ResultSet ts = dbmd.getTableTypes();
        return ResultSetUtils.getResultSet(ts);
    }

    public List<Map<Integer, List<String>>> getCatalogs() throws Exception {
        DatabaseMetaData dbmd = dataSourceConfig.getDataBaseMetaData();
        ResultSet ts = dbmd.getCatalogs();
        return ResultSetUtils.getResultSet(ts);
    }

    public List<Map<Integer, List<String>>> getTables() throws Exception {
        DatabaseMetaData dbmd = dataSourceConfig.getDataBaseMetaData();
        ResultSet ts = dbmd.getTables("d2mc9geiuafi3r", null, null, new String[]{"TABLE"});
        return ResultSetUtils.getResultSet(ts);
    }

    public List<Map<Integer, List<String>>> getColumns() throws Exception {
        DatabaseMetaData dbmd = dataSourceConfig.getDataBaseMetaData();
        ResultSet ts = dbmd.getColumns("d2mc9geiuafi3r", null, "weight_history", null);
        return ResultSetUtils.getResultSet(ts);
    }


}
