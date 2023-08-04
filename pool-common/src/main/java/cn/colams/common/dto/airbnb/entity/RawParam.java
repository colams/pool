package cn.colams.common.dto.airbnb.entity;

import java.util.List;

public class RawParam {

    private String filterName;
    private List<String> filterValues;

    public RawParam(String filterName, List<String> filterValues) {
        this.filterName = filterName;
        this.filterValues = filterValues;
    }

    public RawParam() {
    }

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public List<String> getFilterValues() {
        return filterValues;
    }

    public void setFilterValues(List<String> filterValues) {
        this.filterValues = filterValues;
    }
}
