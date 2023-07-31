package cn.colams.dal.entity;

import java.util.Date;

public class Airbnb {
    private Long id;

    private String roomId;

    private String roomName;

    private String roomUrl;

    private String landlordId;

    private String price;

    private String roomLocation;

    private Integer dealStatus;

    private Integer rSrouce;

    private Integer page;

    private String orgUrl;

    private String evaluate;

    private Integer pictureCount;

    private String area;

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

    public String getLandlordId() {
        return landlordId;
    }

    public Airbnb withLandlordId(String landlordId) {
        this.setLandlordId(landlordId);
        return this;
    }

    public void setLandlordId(String landlordId) {
        this.landlordId = landlordId == null ? null : landlordId.trim();
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

    public Integer getDealStatus() {
        return dealStatus;
    }

    public Airbnb withDealStatus(Integer dealStatus) {
        this.setDealStatus(dealStatus);
        return this;
    }

    public void setDealStatus(Integer dealStatus) {
        this.dealStatus = dealStatus;
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

    public String getEvaluate() {
        return evaluate;
    }

    public Airbnb withEvaluate(String evaluate) {
        this.setEvaluate(evaluate);
        return this;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate == null ? null : evaluate.trim();
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

    public String getArea() {
        return area;
    }

    public Airbnb withArea(String area) {
        this.setArea(area);
        return this;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
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