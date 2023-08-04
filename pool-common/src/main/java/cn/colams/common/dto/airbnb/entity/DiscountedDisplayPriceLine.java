package cn.colams.common.dto.airbnb.entity;

import cn.colams.common.dto.airbnb.ITypeName;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DiscountedDisplayPriceLine extends ITypeName {

    @JsonProperty("accessibilityLabel")
    private String accessibilitylabel;
    @JsonProperty("concatQualifierLeft")
    private boolean concatqualifierleft;
    @JsonProperty("discountedPrice")
    private String discountedprice;
    @JsonProperty("displayComponentType")
    private String displaycomponenttype;
    @JsonProperty("originalPrice")
    private String originalprice;
    private String qualifier;
    @JsonProperty("shortQualifier")
    private String shortqualifier;

    public String getAccessibilitylabel() {
        return accessibilitylabel;
    }

    public void setAccessibilitylabel(String accessibilitylabel) {
        this.accessibilitylabel = accessibilitylabel;
    }

    public boolean isConcatqualifierleft() {
        return concatqualifierleft;
    }

    public void setConcatqualifierleft(boolean concatqualifierleft) {
        this.concatqualifierleft = concatqualifierleft;
    }

    public String getDiscountedprice() {
        return discountedprice;
    }

    public void setDiscountedprice(String discountedprice) {
        this.discountedprice = discountedprice;
    }

    public String getDisplaycomponenttype() {
        return displaycomponenttype;
    }

    public void setDisplaycomponenttype(String displaycomponenttype) {
        this.displaycomponenttype = displaycomponenttype;
    }

    public String getOriginalprice() {
        return originalprice;
    }

    public void setOriginalprice(String originalprice) {
        this.originalprice = originalprice;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public String getShortqualifier() {
        return shortqualifier;
    }

    public void setShortqualifier(String shortqualifier) {
        this.shortqualifier = shortqualifier;
    }
}
