package cn.colams.common.dto.airbnb.entity;

import java.util.List;

public class StaysSearchRequest {


    private boolean metadataOnly;
    private List<RawParam> rawParams;
    private String requestedPageType;
    private String searchType;
    private List<String> treatmentFlags;

    private String cursor;

    private String source;

    public boolean isMetadataOnly() {
        return metadataOnly;
    }

    public void setMetadataOnly(boolean metadataOnly) {
        this.metadataOnly = metadataOnly;
    }

    public List<RawParam> getRawParams() {
        return rawParams;
    }

    public void setRawParams(List<RawParam> rawParams) {
        this.rawParams = rawParams;
    }

    public String getRequestedPageType() {
        return requestedPageType;
    }

    public void setRequestedPageType(String requestedPageType) {
        this.requestedPageType = requestedPageType;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public List<String> getTreatmentFlags() {
        return treatmentFlags;
    }

    public void setTreatmentFlags(List<String> treatmentFlags) {
        this.treatmentFlags = treatmentFlags;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
