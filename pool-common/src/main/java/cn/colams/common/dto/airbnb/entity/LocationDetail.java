package cn.colams.common.dto.airbnb.entity;

import cn.colams.common.dto.airbnb.ITypeName;

public class LocationDetail extends ITypeName {

    private ReadMoreHtml content;
    private String displayType;
    private String id;
    private String items;
    private String title;
    private String walkScoresContent;

    public ReadMoreHtml getContent() {
        return content;
    }

    public void setContent(ReadMoreHtml content) {
        this.content = content;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWalkScoresContent() {
        return walkScoresContent;
    }

    public void setWalkScoresContent(String walkScoresContent) {
        this.walkScoresContent = walkScoresContent;
    }
}
