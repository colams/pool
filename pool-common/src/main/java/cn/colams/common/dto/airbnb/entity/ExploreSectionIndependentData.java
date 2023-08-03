package cn.colams.common.dto.airbnb.entity;

import cn.colams.common.dto.airbnb.face.ITypeName;

public class ExploreSectionIndependentData extends ITypeName {

    private StaysSearchResponse staysSearch;

    private StaysMapSearchResponse staysMapSearch;

    public StaysSearchResponse getStaysSearch() {
        return staysSearch;
    }

    public void setStaysSearch(StaysSearchResponse staysSearch) {
        this.staysSearch = staysSearch;
    }

    public StaysMapSearchResponse getStaysMapSearch() {
        return staysMapSearch;
    }

    public void setStaysMapSearch(StaysMapSearchResponse staysMapSearch) {
        this.staysMapSearch = staysMapSearch;
    }
}
