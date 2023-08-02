package cn.colams.common.dto.airbnb;

import cn.colams.common.dto.airbnb.entity.Metadata;
import cn.colams.common.dto.airbnb.entity.UserPromoListings;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserPromoListsResponse {

    private Metadata metadata;
    @JsonProperty("user_promo_listings")
    private List<UserPromoListings> userPromoListings;

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
