package cn.colams.common.dto.airbnb.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserPromoListings {
    private int bathrooms;
    private int bedrooms;
    private int beds;
    @JsonProperty("guest_currency")
    private String guestCurrency;
    private int id;
    @JsonProperty("id_str")
    private String idStr;
    @JsonProperty("instant_bookable")
    private boolean instantBookable;
    @JsonProperty("is_new_listing")
    private boolean isNewListing;
    @JsonProperty("is_superhost")
    private boolean isSuperhost;
    @JsonProperty("localized_city")
    private String localizedCity;
    private String name;
    @JsonProperty("nightly_price_as_guest")
    private int nightlyPriceAsGuest;
    @JsonProperty("picture_url")
    private String pictureUrl;
    @JsonProperty("room_and_property_type")
    private String roomAndPropertyType;
    @JsonProperty("space_type")
    private String spaceType;
    @JsonProperty("star_rating")
    private double starRating;
    @JsonProperty("visible_review_count")
    private int visibleReviewCount;

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getBeds() {
        return beds;
    }

    public void setGuestCurrency(String guestCurrency) {
        this.guestCurrency = guestCurrency;
    }

    public String getGuestCurrency() {
        return guestCurrency;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setInstantBookable(boolean instantBookable) {
        this.instantBookable = instantBookable;
    }

    public boolean getInstantBookable() {
        return instantBookable;
    }

    public void setIsNewListing(boolean isNewListing) {
        this.isNewListing = isNewListing;
    }

    public boolean getIsNewListing() {
        return isNewListing;
    }

    public void setIsSuperhost(boolean isSuperhost) {
        this.isSuperhost = isSuperhost;
    }

    public boolean getIsSuperhost() {
        return isSuperhost;
    }

    public void setLocalizedCity(String localizedCity) {
        this.localizedCity = localizedCity;
    }

    public String getLocalizedCity() {
        return localizedCity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNightlyPriceAsGuest(int nightlyPriceAsGuest) {
        this.nightlyPriceAsGuest = nightlyPriceAsGuest;
    }

    public int getNightlyPriceAsGuest() {
        return nightlyPriceAsGuest;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setRoomAndPropertyType(String roomAndPropertyType) {
        this.roomAndPropertyType = roomAndPropertyType;
    }

    public String getRoomAndPropertyType() {
        return roomAndPropertyType;
    }

    public void setSpaceType(String spaceType) {
        this.spaceType = spaceType;
    }

    public String getSpaceType() {
        return spaceType;
    }

    public void setStarRating(double starRating) {
        this.starRating = starRating;
    }

    public double getStarRating() {
        return starRating;
    }

    public void setVisibleReviewCount(int visibleReviewCount) {
        this.visibleReviewCount = visibleReviewCount;
    }

    public int getVisibleReviewCount() {
        return visibleReviewCount;
    }
}
