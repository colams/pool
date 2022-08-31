package cn.colams.dal.entity;

import java.util.Date;

public class Haipi111Log {
    private Integer id;

    private String requestdata;

    private String responsedata;

    private Date createDate;

    public Integer getId() {
        return id;
    }

    public Haipi111Log withId(Integer id) {
        this.setId(id);
        return this;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRequestdata() {
        return requestdata;
    }

    public Haipi111Log withRequestdata(String requestdata) {
        this.setRequestdata(requestdata);
        return this;
    }

    public void setRequestdata(String requestdata) {
        this.requestdata = requestdata == null ? null : requestdata.trim();
    }

    public String getResponsedata() {
        return responsedata;
    }

    public Haipi111Log withResponsedata(String responsedata) {
        this.setResponsedata(responsedata);
        return this;
    }

    public void setResponsedata(String responsedata) {
        this.responsedata = responsedata == null ? null : responsedata.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Haipi111Log withCreateDate(Date createDate) {
        this.setCreateDate(createDate);
        return this;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}