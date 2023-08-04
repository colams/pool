package cn.colams.common.dto.airbnb.entity;

import cn.colams.common.dto.airbnb.ITypeName;

public class ExploreStructuredContent extends ITypeName {

    private MainSectionMessage secondaryLine;

    public MainSectionMessage getSecondaryLine() {
        return secondaryLine;
    }

    public void setSecondaryLine(MainSectionMessage secondaryLine) {
        this.secondaryLine = secondaryLine;
    }
}
