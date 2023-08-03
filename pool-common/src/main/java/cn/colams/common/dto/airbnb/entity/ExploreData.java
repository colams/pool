package cn.colams.common.dto.airbnb.entity;

import cn.colams.common.dto.airbnb.face.ITypeName;

public class ExploreData extends ITypeName {

    private ExploreSections sections;

    public ExploreSections getSections() {
        return sections;
    }

    public void setSections(ExploreSections sections) {
        this.sections = sections;
    }
}
