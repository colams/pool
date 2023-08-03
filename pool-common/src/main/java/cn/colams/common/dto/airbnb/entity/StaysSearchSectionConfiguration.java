package cn.colams.common.dto.airbnb.entity;

import cn.colams.common.dto.airbnb.face.ITypeName;

public class StaysSearchSectionConfiguration extends ITypeName {

    private PlacementPerFormFactor pageTitleSections;

    public PlacementPerFormFactor getPageTitleSections() {
        return pageTitleSections;
    }

    public void setPageTitleSections(PlacementPerFormFactor pageTitleSections) {
        this.pageTitleSections = pageTitleSections;
    }
}
