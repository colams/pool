package cn.colams.dal.entity;

import java.util.Date;

public class Airbnb {
    private Long id;

    private String roomId;

    private String roomUrl;

    private String status;

    private Integer page;

    private Date createTime;

    private String extra;

    public Long getId() {
        return id;
    }

    public Airbnb withId(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public Airbnb withRoomId(String roomId) {
        this.setRoomId(roomId);
        return this;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId == null ? null : roomId.trim();
    }

    public String getRoomUrl() {
        return roomUrl;
    }

    public Airbnb withRoomUrl(String roomUrl) {
        this.setRoomUrl(roomUrl);
        return this;
    }

    public void setRoomUrl(String roomUrl) {
        this.roomUrl = roomUrl == null ? null : roomUrl.trim();
    }

    public String getStatus() {
        return status;
    }

    public Airbnb withStatus(String status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getPage() {
        return page;
    }

    public Airbnb withPage(Integer page) {
        this.setPage(page);
        return this;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Airbnb withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getExtra() {
        return extra;
    }

    public Airbnb withExtra(String extra) {
        this.setExtra(extra);
        return this;
    }

    public void setExtra(String extra) {
        this.extra = extra == null ? null : extra.trim();
    }
}