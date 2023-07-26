package cn.colams.dal.entity;

import java.util.Date;

public class Airbnb {
    private Long id;

    private String detailUrl;

    private Date createTime;

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

    public String getDetailUrl() {
        return detailUrl;
    }

    public Airbnb withDetailUrl(String detailUrl) {
        this.setDetailUrl(detailUrl);
        return this;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl == null ? null : detailUrl.trim();
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
}