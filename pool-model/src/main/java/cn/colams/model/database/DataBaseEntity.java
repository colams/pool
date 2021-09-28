package cn.colams.model.database;

import java.util.List;

public class DataBaseEntity {

    private List<String> columnNames;
    private List<List<String>> dataList;

    public List<String> getColumnsNames() {
        return columnNames;
    }

    public void setColumnsNames(List<String> columnNames) {
        this.columnNames = columnNames;
    }

    public List<List<String>> getDataList() {
        return dataList;
    }

    public void setDataList(List<List<String>> dataList) {
        this.dataList = dataList;
    }
}
