package cn.colams.common.dto.airbnb.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Metadata {
    @JsonProperty("record_count")
    private int recordCount;

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getRecordCount() {
        return recordCount;
    }

}
