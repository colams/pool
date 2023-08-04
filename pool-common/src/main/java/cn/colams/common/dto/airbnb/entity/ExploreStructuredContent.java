package cn.colams.common.dto.airbnb.entity;

import cn.colams.common.dto.airbnb.ITypeName;

import java.util.List;

public class ExploreStructuredContent extends ITypeName {

    private List<MainSectionMessage> secondaryLine;

    public List<MainSectionMessage> getSecondaryLine() {
        return secondaryLine;
    }

    public void setSecondaryLine(List<MainSectionMessage> secondaryLine) {
        this.secondaryLine = secondaryLine;
    }
}
