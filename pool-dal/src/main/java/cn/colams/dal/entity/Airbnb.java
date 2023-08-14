package cn.colams.dal.entity;

import java.util.Date;

public class Airbnb {
    private Long id;

    private String roomId;

    private String roomName;

    private String roomUrl;

    private String lordId;

    private String price;

    private String roomLocation;

    private Integer status;

    private Integer rSrouce;

    private Integer page;

    private String orgUrl;

    private Integer pictureCount;

    private String state;

    private Date datechangeLasttime;

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

    public String getRoomName() {
        return roomName;
    }

    public Airbnb withRoomName(String roomName) {
        this.setRoomName(roomName);
        return this;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName == null ? null : roomName.trim();
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

    public String getLordId() {
        return lordId;
    }

    public Airbnb withLordId(String lordId) {
        this.setLordId(lordId);
        return this;
    }

    public void setLordId(String lordId) {
        this.lordId = lordId == null ? null : lordId.trim();
    }

    public String getPrice() {
        return price;
    }

    public Airbnb withPrice(String price) {
        this.setPrice(price);
        return this;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getRoomLocation() {
        return roomLocation;
    }

    public Airbnb withRoomLocation(String roomLocation) {
        this.setRoomLocation(roomLocation);
        return this;
    }

    public void setRoomLocation(String roomLocation) {
        this.roomLocation = roomLocation == null ? null : roomLocation.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public Airbnb withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getrSrouce() {
        return rSrouce;
    }

    public Airbnb withrSrouce(Integer rSrouce) {
        this.setrSrouce(rSrouce);
        return this;
    }

    public void setrSrouce(Integer rSrouce) {
        this.rSrouce = rSrouce;
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

    public String getOrgUrl() {
        return orgUrl;
    }

    public Airbnb withOrgUrl(String orgUrl) {
        this.setOrgUrl(orgUrl);
        return this;
    }

    public void setOrgUrl(String orgUrl) {
        this.orgUrl = orgUrl == null ? null : orgUrl.trim();
    }

    public Integer getPictureCount() {
        return pictureCount;
    }

    public Airbnb withPictureCount(Integer pictureCount) {
        this.setPictureCount(pictureCount);
        return this;
    }

    public void setPictureCount(Integer pictureCount) {
        this.pictureCount = pictureCount;
    }

    public String getState() {
        return state;
    }

    public Airbnb withState(String state) {
        this.setState(state);
        return this;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getDatechangeLasttime() {
        return datechangeLasttime;
    }

    public Airbnb withDatechangeLasttime(Date datechangeLasttime) {
        this.setDatechangeLasttime(datechangeLasttime);
        return this;
    }

    public void setDatechangeLasttime(Date datechangeLasttime) {
        this.datechangeLasttime = datechangeLasttime;
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