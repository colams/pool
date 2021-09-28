package cn.colams.biz.db;

import cn.colams.common.utils.ResultSetUtils;
import cn.colams.dal.DataSourceConfig;
import cn.colams.model.database.DataBaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

@Component
public class DatabaseBiz {
    @Autowired
    DataSourceConfig dataSourceConfig;

    public DataBaseEntity getTableTypes() throws Exception {
        DatabaseMetaData dbmd = dataSourceConfig.getMetaData();
        ResultSet ts = dbmd.getTableTypes();
        return ResultSetUtils.getResultSet(ts);
    }

    public DataBaseEntity getCatalogs() throws Exception {
        DatabaseMetaData dbmd = dataSourceConfig.getMetaData();
        ResultSet ts = dbmd.getCatalogs();
        return ResultSetUtils.getResultSet(ts);
    }

    public DataBaseEntity getTables() throws Exception {
        DatabaseMetaData dbmd = dataSourceConfig.getMetaData();
        ResultSet ts = dbmd.getTables("d2mc9geiuafi3r", null, null, new String[]{"TABLE"});
        return ResultSetUtils.getResultSet(ts);
    }

    public DataBaseEntity getColumns() throws Exception {
        DatabaseMetaData dbmd = dataSourceConfig.getMetaData();
        ResultSet ts = dbmd.getColumns("d2mc9geiuafi3r", null, "weight_history", null);
        return ResultSetUtils.getResultSet(ts);
    }


}
