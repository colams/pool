package cn.colams.common.dto.airbnb.entity;

import cn.colams.common.dto.airbnb.face.ITypeName;

public class StaySearchResult extends ITypeName {

    private StaySearchResultListing listing;

    private ExplorePricingQuote pricingQuote;

    public StaySearchResultListing getListing() {
        return listing;
    }

    public void setListing(StaySearchResultListing listing) {
        this.listing = listing;
    }

    public ExplorePricingQuote getPricingQuote() {
        return pricingQuote;
    }

    public void setPricingQuote(ExplorePricingQuote pricingQuote) {
        this.pricingQuote = pricingQuote;
    }
}
