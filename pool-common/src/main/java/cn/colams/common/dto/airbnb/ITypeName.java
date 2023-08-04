package cn.colams.common.dto.airbnb;

import com.fasterxml.jackson.annotation.JsonProperty;


public abstract class ITypeName {
    @JsonProperty("__typename")
    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
