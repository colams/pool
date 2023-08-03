package cn.colams.common.dto.airbnb.entity;

import cn.colams.common.dto.airbnb.face.ITypeName;

public class ExplorePricingQuote extends ITypeName {

    private StructuredDisplayPrice structuredStayDisplayPrice;

    public StructuredDisplayPrice getStructuredStayDisplayPrice() {
        return structuredStayDisplayPrice;
    }

    public void setStructuredStayDisplayPrice(StructuredDisplayPrice structuredStayDisplayPrice) {
        this.structuredStayDisplayPrice = structuredStayDisplayPrice;
    }
}
