package cn.colams.common.dto.airbnb.entity;

import cn.colams.common.dto.airbnb.ITypeName;

import java.util.List;

public class PlacementPerFormFactor extends ITypeName {

    private List<SectionDataContainer> sections;

    public List<SectionDataContainer> getSections() {
        return sections;
    }

    public void setSections(List<SectionDataContainer> sections) {
        this.sections = sections;
    }
}
