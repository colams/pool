package cn.colams.common.dto.airbnb.entity;

import cn.colams.common.dto.airbnb.face.ITypeName;

public class SectionDataContainer extends ITypeName {

    private String sectionId;
    private ExplorePageTitleSection sectionData;

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public ExplorePageTitleSection getSectionData() {
        return sectionData;
    }

    public void setSectionData(ExplorePageTitleSection sectionData) {
        this.sectionData = sectionData;
    }
}
