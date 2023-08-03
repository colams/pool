package cn.colams.common.dto.airbnb.entity;

import cn.colams.common.dto.airbnb.face.ITypeName;

import java.util.List;

public class StaysSearchResponse extends ITypeName {

    private StaysSearchPaginationInfo paginationInfo;
    private StaysSearchLoggingMetadata loggingMetadata;

    private List<StaySearchResult> searchResults;

    private StaysSearchSectionConfiguration sectionConfiguration;


    public StaysSearchPaginationInfo getPaginationInfo() {
        return paginationInfo;
    }

    public void setPaginationInfo(StaysSearchPaginationInfo paginationInfo) {
        this.paginationInfo = paginationInfo;
    }

    public StaysSearchLoggingMetadata getLoggingMetadata() {
        return loggingMetadata;
    }

    public void setLoggingMetadata(StaysSearchLoggingMetadata loggingMetadata) {
        this.loggingMetadata = loggingMetadata;
    }

    public List<StaySearchResult> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(List<StaySearchResult> searchResults) {
        this.searchResults = searchResults;
    }

    public StaysSearchSectionConfiguration getSectionConfiguration() {
        return sectionConfiguration;
    }

    public void setSectionConfiguration(StaysSearchSectionConfiguration sectionConfiguration) {
        this.sectionConfiguration = sectionConfiguration;
    }
}
