package cn.colams.common.dto.airbnb.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PageCourse {
    @JsonProperty("section_offset")
    private int sectionOffset;
    @JsonProperty("items_offset")
    private int itemsOffset;
    private int version;

    public int getSectionOffset() {
        return sectionOffset;
    }

    public void setSectionOffset(int sectionOffset) {
        this.sectionOffset = sectionOffset;
    }

    public int getItemsOffset() {
        return itemsOffset;
    }

    public void setItemsOffset(int itemsOffset) {
        this.itemsOffset = itemsOffset;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
