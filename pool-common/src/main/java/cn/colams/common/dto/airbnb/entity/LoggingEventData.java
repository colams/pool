package cn.colams.common.dto.airbnb.entity;

import cn.colams.common.dto.airbnb.ITypeName;

public class LoggingEventData extends ITypeName {
    private String component;
    private String eventData;
    private String eventDataSchemaName;
    private String experiments;
    private String loggingId;
    private String section;

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getEventData() {
        return eventData;
    }

    public void setEventData(String eventData) {
        this.eventData = eventData;
    }

    public String getEventDataSchemaName() {
        return eventDataSchemaName;
    }

    public void setEventDataSchemaName(String eventDataSchemaName) {
        this.eventDataSchemaName = eventDataSchemaName;
    }

    public String getExperiments() {
        return experiments;
    }

    public void setExperiments(String experiments) {
        this.experiments = experiments;
    }

    public String getLoggingId() {
        return loggingId;
    }

    public void setLoggingId(String loggingId) {
        this.loggingId = loggingId;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
