package cn.colams.common.dto.airbnb.entity;

import cn.colams.common.dto.airbnb.ITypeName;

public class ExploreData extends ITypeName {

    private ExploreSections sections;

    public ExploreSections getSections() {
        return sections;
    }

    public void setSections(ExploreSections sections) {
        this.sections = sections;
    }
}
