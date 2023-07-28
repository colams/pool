package cn.colams.dal.entity;

import java.util.Date;

public class AirbnbRoomOwner {
    private Long id;

    private String loardId;

    private String lordName;

    private String lordPage;

    private Integer rooms;

    private Long airbnbId;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public AirbnbRoomOwner withId(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoardId() {
        return loardId;
    }

    public AirbnbRoomOwner withLoardId(String loardId) {
        this.setLoardId(loardId);
        return this;
    }

    public void setLoardId(String loardId) {
        this.loardId = loardId == null ? null : loardId.trim();
    }

    public String getLordName() {
        return lordName;
    }

    public AirbnbRoomOwner withLordName(String lordName) {
        this.setLordName(lordName);
        return this;
    }

    public void setLordName(String lordName) {
        this.lordName = lordName == null ? null : lordName.trim();
    }

    public String getLordPage() {
        return lordPage;
    }

    public AirbnbRoomOwner withLordPage(String lordPage) {
        this.setLordPage(lordPage);
        return this;
    }

    public void setLordPage(String lordPage) {
        this.lordPage = lordPage == null ? null : lordPage.trim();
    }

    public Integer getRooms() {
        return rooms;
    }

    public AirbnbRoomOwner withRooms(Integer rooms) {
        this.setRooms(rooms);
        return this;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public Long getAirbnbId() {
        return airbnbId;
    }

    public AirbnbRoomOwner withAirbnbId(Long airbnbId) {
        this.setAirbnbId(airbnbId);
        return this;
    }

    public void setAirbnbId(Long airbnbId) {
        this.airbnbId = airbnbId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public AirbnbRoomOwner withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}