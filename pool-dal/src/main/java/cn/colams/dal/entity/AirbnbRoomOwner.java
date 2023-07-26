package cn.colams.dal.entity;

import java.util.Date;

public class AirbnbRoomOwner {
    private Long id;

    private String name;

    private String lordPage;

    private Integer rooms;

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

    public String getName() {
        return name;
    }

    public AirbnbRoomOwner withName(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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