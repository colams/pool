
package cn.colams.model.dto.airbnb;

import cn.colams.model.dto.IPageRequest;

public class SearchAirbnbLordParams extends IPageRequest {
    private String createTimeStart;
    private String createTimeEnd;
    private String state;
    private String lord;

    public String getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(String createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public String getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(String createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLord() {
        return lord;
    }

    public void setLord(String lord) {
        this.lord = lord;
    }
}
