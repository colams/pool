package cn.colams.dal.entity;

import java.util.Date;

public class AirbnbLord {
    private Long id;

    private String loardId;

    private String lordName;

    private String lordPage;

    private Integer rooms;

    private Long airbnbId;

    private Integer processStatus;

    private String evaluate;

    private String brief;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public AirbnbLord withId(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoardId() {
        return loardId;
    }

    public AirbnbLord withLoardId(String loardId) {
        this.setLoardId(loardId);
        return this;
    }

    public void setLoardId(String loardId) {
        this.loardId = loardId == null ? null : loardId.trim();
    }

    public String getLordName() {
        return lordName;
    }

    public AirbnbLord withLordName(String lordName) {
        this.setLordName(lordName);
        return this;
    }

    public void setLordName(String lordName) {
        this.lordName = lordName == null ? null : lordName.trim();
    }

    public String getLordPage() {
        return lordPage;
    }

    public AirbnbLord withLordPage(String lordPage) {
        this.setLordPage(lordPage);
        return this;
    }

    public void setLordPage(String lordPage) {
        this.lordPage = lordPage == null ? null : lordPage.trim();
    }

    public Integer getRooms() {
        return rooms;
    }

    public AirbnbLord withRooms(Integer rooms) {
        this.setRooms(rooms);
        return this;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public Long getAirbnbId() {
        return airbnbId;
    }

    public AirbnbLord withAirbnbId(Long airbnbId) {
        this.setAirbnbId(airbnbId);
        return this;
    }

    public void setAirbnbId(Long airbnbId) {
        this.airbnbId = airbnbId;
    }

    public Integer getProcessStatus() {
        return processStatus;
    }

    public AirbnbLord withProcessStatus(Integer processStatus) {
        this.setProcessStatus(processStatus);
        return this;
    }

    public void setProcessStatus(Integer processStatus) {
        this.processStatus = processStatus;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public AirbnbLord withEvaluate(String evaluate) {
        this.setEvaluate(evaluate);
        return this;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate == null ? null : evaluate.trim();
    }

    public String getBrief() {
        return brief;
    }

    public AirbnbLord withBrief(String brief) {
        this.setBrief(brief);
        return this;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public AirbnbLord withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}