package cn.colams.common.dto.airbnb.face;

import com.fasterxml.jackson.annotation.JsonProperty;


public abstract class ITypeName {
    @JsonProperty("__typename")
    public String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
