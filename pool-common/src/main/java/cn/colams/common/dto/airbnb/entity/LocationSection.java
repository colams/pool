package cn.colams.common.dto.airbnb.entity;

import cn.colams.common.dto.airbnb.ITypeName;

import java.util.List;

public class LocationSection extends ITypeName {

    private String address;
    private String addressTitle;
    private String homeIcon;
    private String hostGuidebookButton;
    private double lat;
    private double lng;
    private String locationDisclaimer;
    private String mapMarkerAccessibilityLabel;
    private int mapMarkerRadiusInMeters;
    private String mapMarkerType;
    private List<LocationDetail> previewLocationDetails;
    private BasicListItem seeAllDetailsButton;
    private List<LocationDetail> seeAllLocationDetails;
    private String subtitle;
    private List<String> summaryLocationDetails;
    private String title;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressTitle() {
        return addressTitle;
    }

    public void setAddressTitle(String addressTitle) {
        this.addressTitle = addressTitle;
    }

    public String getHomeIcon() {
        return homeIcon;
    }

    public void setHomeIcon(String homeIcon) {
        this.homeIcon = homeIcon;
    }

    public String getHostGuidebookButton() {
        return hostGuidebookButton;
    }

    public void setHostGuidebookButton(String hostGuidebookButton) {
        this.hostGuidebookButton = hostGuidebookButton;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getLocationDisclaimer() {
        return locationDisclaimer;
    }

    public void setLocationDisclaimer(String locationDisclaimer) {
        this.locationDisclaimer = locationDisclaimer;
    }

    public String getMapMarkerAccessibilityLabel() {
        return mapMarkerAccessibilityLabel;
    }

    public void setMapMarkerAccessibilityLabel(String mapMarkerAccessibilityLabel) {
        this.mapMarkerAccessibilityLabel = mapMarkerAccessibilityLabel;
    }

    public int getMapMarkerRadiusInMeters() {
        return mapMarkerRadiusInMeters;
    }

    public void setMapMarkerRadiusInMeters(int mapMarkerRadiusInMeters) {
        this.mapMarkerRadiusInMeters = mapMarkerRadiusInMeters;
    }

    public String getMapMarkerType() {
        return mapMarkerType;
    }

    public void setMapMarkerType(String mapMarkerType) {
        this.mapMarkerType = mapMarkerType;
    }

    public List<LocationDetail> getPreviewLocationDetails() {
        return previewLocationDetails;
    }

    public void setPreviewLocationDetails(List<LocationDetail> previewLocationDetails) {
        this.previewLocationDetails = previewLocationDetails;
    }

    public BasicListItem getSeeAllDetailsButton() {
        return seeAllDetailsButton;
    }

    public void setSeeAllDetailsButton(BasicListItem seeAllDetailsButton) {
        this.seeAllDetailsButton = seeAllDetailsButton;
    }

    public List<LocationDetail> getSeeAllLocationDetails() {
        return seeAllLocationDetails;
    }

    public void setSeeAllLocationDetails(List<LocationDetail> seeAllLocationDetails) {
        this.seeAllLocationDetails = seeAllLocationDetails;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public List<String> getSummaryLocationDetails() {
        return summaryLocationDetails;
    }

    public void setSummaryLocationDetails(List<String> summaryLocationDetails) {
        this.summaryLocationDetails = summaryLocationDetails;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
