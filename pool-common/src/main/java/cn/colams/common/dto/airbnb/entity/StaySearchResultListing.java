package cn.colams.common.dto.airbnb.entity;

public class StaySearchResultListing {

    private String avgRatingA11yLabel;
    private String avgRatingLocalized;
    private String city;
    private int contextualPicturesCount;
    private Coordinate coordinate;
    private String id;
    private String localizedCityName;
    private String name;

    private ExploreStructuredContent structuredContent;

    public String getAvgRatingA11yLabel() {
        return avgRatingA11yLabel;
    }

    public void setAvgRatingA11yLabel(String avgRatingA11yLabel) {
        this.avgRatingA11yLabel = avgRatingA11yLabel;
    }

    public String getAvgRatingLocalized() {
        return avgRatingLocalized;
    }

    public void setAvgRatingLocalized(String avgRatingLocalized) {
        this.avgRatingLocalized = avgRatingLocalized;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getContextualPicturesCount() {
        return contextualPicturesCount;
    }

    public void setContextualPicturesCount(int contextualPicturesCount) {
        this.contextualPicturesCount = contextualPicturesCount;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocalizedCityName() {
        return localizedCityName;
    }

    public void setLocalizedCityName(String localizedCityName) {
        this.localizedCityName = localizedCityName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExploreStructuredContent getStructuredContent() {
        return structuredContent;
    }

    public void setStructuredContent(ExploreStructuredContent structuredContent) {
        this.structuredContent = structuredContent;
    }
}
