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

    private static String databaseName = "d44uhfasaj4vt4";

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
//        new String[]{"TABLE"}
        ResultSet ts = dbmd.getTables(databaseName, null, null,null);
        return ResultSetUtils.getResultSet(ts);
    }

    public DataBaseEntity getColumns(String tableName) throws Exception {
        DatabaseMetaData dbmd = dataSourceConfig.getMetaData();
        ResultSet ts = dbmd.getColumns(databaseName, null, tableName, null);
        return ResultSetUtils.getResultSet(ts);
    }


}
