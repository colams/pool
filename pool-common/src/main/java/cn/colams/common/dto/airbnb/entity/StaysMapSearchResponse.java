package cn.colams.common.dto.airbnb.entity;

import cn.colams.common.dto.airbnb.face.ITypeName;

import java.util.List;

public class StaysMapSearchResponse extends ITypeName {

    private List<StaySearchResult> mapSearchResults;

    public List<StaySearchResult> getMapSearchResults() {
        return mapSearchResults;
    }

    public void setMapSearchResults(List<StaySearchResult> mapSearchResults) {
        this.mapSearchResults = mapSearchResults;
    }
}
