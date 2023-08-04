package cn.colams.common.dto.airbnb.entity;

import cn.colams.common.dto.airbnb.ITypeName;

public class RemarketingLoggingData extends ITypeName {

    private String canonicalLocation;
    private String city;
    private String country;
    private String state;

    public String getCanonicalLocation() {
        return canonicalLocation;
    }

    public void setCanonicalLocation(String canonicalLocation) {
        this.canonicalLocation = canonicalLocation;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
