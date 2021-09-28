package cn.colams.common.utils;

import cn.colams.model.database.DataBaseEntity;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultSetUtils {

    public static DataBaseEntity getResultSet(ResultSet resultSet) throws SQLException {

        List<String> columnNames = new ArrayList<>();
        List<List<String>> dataList = new ArrayList<>();

        ResultSetMetaData rsmd = resultSet.getMetaData();
        for (int i = 0; i < rsmd.getColumnCount(); i++) {
            columnNames.add(rsmd.getColumnName(i + 1));
        }

        while (resultSet.next()) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                list.add((resultSet.getString(i + 1)));
            }
            dataList.add(list);
        }
        resultSet.close();

        DataBaseEntity dataBaseEntity = new DataBaseEntity();
        dataBaseEntity.setColumnsNames(columnNames);
        dataBaseEntity.setDataList(dataList);
        return dataBaseEntity;
    }
}
