package cn.colams.common.dto.airbnb.entity;

import cn.colams.common.dto.airbnb.ITypeName;

public class BasicListItem extends ITypeName {


    private String action;
    private LoggingEventData loggingEventData;
    private String title;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LoggingEventData getLoggingEventData() {
        return loggingEventData;
    }

    public void setLoggingEventData(LoggingEventData loggingEventData) {
        this.loggingEventData = loggingEventData;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
