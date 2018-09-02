package cn.colams.common.utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultSetUtils {

    public static List<Map<Integer, List<String>>> getResultSet(ResultSet resultSet) throws SQLException {
        ResultSetMetaData rsmd = resultSet.getMetaData();
        List<Map<Integer, List<String>>> list = new ArrayList<>();
        Map<Integer, List<String>> headMap = new HashMap<>();
        List<String> header = new ArrayList<>();
        for (int i = 0; i < rsmd.getColumnCount(); i++) {
            header.add(rsmd.getColumnName(i + 1));
        }

        headMap.put(0, header);
        list.add(headMap);

        int j = 1;
        while (resultSet.next()) {
            Map<Integer, List<String>> map = new HashMap<>();
            List<String> dataList = new ArrayList<>();
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                dataList.add((resultSet.getString(i + 1)));
            }
            map.put(j, dataList);
            j++;
            list.add(map);
        }
        resultSet.close();
        return list;
    }
}
