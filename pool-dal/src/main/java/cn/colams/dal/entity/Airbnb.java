package cn.colams.dal.entity;

import java.util.Date;

public class Airbnb {
    private Long id;

    private String roomId;

    private String roomName;

    private String roomUrl;

    private String landlordId;

    private String price;

    private Integer dealStatus;

    private Integer pictureCount;

    private String area;

    private String evaluate;

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