package cn.colams.common.dto.airbnb.entity;

import cn.colams.common.dto.airbnb.ITypeName;

public class StaysSearchLoggingMetadata extends ITypeName {

    private String legacyLoggingSectionId;
    private RemarketingLoggingData remarketingLoggingData;

    public String getLegacyLoggingSectionId() {
        return legacyLoggingSectionId;
    }

    public void setLegacyLoggingSectionId(String legacyLoggingSectionId) {
        this.legacyLoggingSectionId = legacyLoggingSectionId;
    }

    public RemarketingLoggingData getRemarketingLoggingData() {
        return remarketingLoggingData;
    }

    public void setRemarketingLoggingData(RemarketingLoggingData remarketingLoggingData) {
        this.remarketingLoggingData = remarketingLoggingData;
    }
}
