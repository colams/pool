package cn.colams.common.dto.airbnb.response;

import cn.colams.common.dto.airbnb.entity.Metadata;
import cn.colams.common.dto.airbnb.entity.UserPromoListings;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserPromoListsResponseType {
    @JsonProperty("error_code")
    private int errorCode;
    private String error;
    @JsonProperty("error_message")
    private String errorMessage;

    private Metadata metadata;
    @JsonProperty("user_promo_listings")
    private List<UserPromoListings> userPromoListings;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public List<UserPromoListings> getUserPromoListings() {
        return userPromoListings;
    }

    public void setUserPromoListings(List<UserPromoListings> userPromoListings) {
        this.userPromoListings = userPromoListings;
    }
}
