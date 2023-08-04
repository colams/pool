package cn.colams.common.dto.airbnb.entity;

import cn.colams.common.dto.airbnb.face.ITypeName;

public class SearchRootPresentation extends ITypeName {

    private ExploreData explore;

    public ExploreData getExplore() {
        return explore;
    }

    public void setExplore(ExploreData explore) {
        this.explore = explore;
    }
}
