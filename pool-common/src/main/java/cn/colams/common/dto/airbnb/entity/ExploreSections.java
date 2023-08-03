package cn.colams.common.dto.airbnb.entity;

import cn.colams.common.dto.airbnb.face.ITypeName;

public class ExploreSections extends ITypeName {

    private String responseType;
    private ExploreSectionIndependentData sectionIndependentData;

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public ExploreSectionIndependentData getSectionIndependentData() {
        return sectionIndependentData;
    }

    public void setSectionIndependentData(ExploreSectionIndependentData sectionIndependentData) {
        this.sectionIndependentData = sectionIndependentData;
    }
}
