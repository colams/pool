package cn.colams.common.dto.airbnb.entity;

public class StaysSearchVariables {

    private boolean decomposeCleanupEnabled;
    private boolean decomposeFiltersEnabled;
    private boolean feedMapDecoupleEnabled;
    private StaysSearchRequest staysMapSearchRequestV2;
    private StaysSearchRequest staysSearchRequest;

    public boolean isDecomposeCleanupEnabled() {
        return decomposeCleanupEnabled;
    }

    public void setDecomposeCleanupEnabled(boolean decomposeCleanupEnabled) {
        this.decomposeCleanupEnabled = decomposeCleanupEnabled;
    }

    public boolean isDecomposeFiltersEnabled() {
        return decomposeFiltersEnabled;
    }

    public void setDecomposeFiltersEnabled(boolean decomposeFiltersEnabled) {
        this.decomposeFiltersEnabled = decomposeFiltersEnabled;
    }

    public boolean isFeedMapDecoupleEnabled() {
        return feedMapDecoupleEnabled;
    }

    public void setFeedMapDecoupleEnabled(boolean feedMapDecoupleEnabled) {
        this.feedMapDecoupleEnabled = feedMapDecoupleEnabled;
    }

    public StaysSearchRequest getStaysMapSearchRequestV2() {
        return staysMapSearchRequestV2;
    }

    public void setStaysMapSearchRequestV2(StaysSearchRequest staysMapSearchRequestV2) {
        this.staysMapSearchRequestV2 = staysMapSearchRequestV2;
    }

    public StaysSearchRequest getStaysSearchRequest() {
        return staysSearchRequest;
    }

    public void setStaysSearchRequest(StaysSearchRequest staysSearchRequest) {
        this.staysSearchRequest = staysSearchRequest;
    }
}
