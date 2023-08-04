package cn.colams.common.dto.airbnb.entity;

import cn.colams.common.dto.airbnb.ITypeName;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StructuredDisplayPrice extends ITypeName {

    @JsonProperty("explanationData")
    private String explanationdata;
    @JsonProperty("explanationDataDisplayPosition")
    private String explanationdatadisplayposition;
    @JsonProperty("explanationDataDisplayPriceTriggerType")
    private String explanationdatadisplaypricetriggertype;
    private String layout;
    @JsonProperty("primaryLine")
    private DiscountedDisplayPriceLine primaryline;

    public void setExplanationdata(String explanationdata) {
        this.explanationdata = explanationdata;
    }

    public String getExplanationdata() {
        return explanationdata;
    }

    public void setExplanationdatadisplayposition(String explanationdatadisplayposition) {
        this.explanationdatadisplayposition = explanationdatadisplayposition;
    }

    public String getExplanationdatadisplayposition() {
        return explanationdatadisplayposition;
    }

    public void setExplanationdatadisplaypricetriggertype(String explanationdatadisplaypricetriggertype) {
        this.explanationdatadisplaypricetriggertype = explanationdatadisplaypricetriggertype;
    }

    public String getExplanationdatadisplaypricetriggertype() {
        return explanationdatadisplaypricetriggertype;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getLayout() {
        return layout;
    }

    public void setPrimaryline(DiscountedDisplayPriceLine primaryline) {
        this.primaryline = primaryline;
    }

    public DiscountedDisplayPriceLine getPrimaryline() {
        return primaryline;
    }


}
