package cn.colams.dal.entity;

import java.util.Date;

public class Haipi111DetailLog {
    private Integer id;

    private String uid;

    private String infoid;

    private String action;

    private String requestdata;

    private String responsedata;

    private Date createDate;

    public Integer getId() {
        return id;
    }

    public Haipi111DetailLog withId(Integer id) {
        this.setId(id);
        return this;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public Haipi111DetailLog withUid(String uid) {
        this.setUid(uid);
        return this;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getInfoid() {
        return infoid;
    }

    public Haipi111DetailLog withInfoid(String infoid) {
        this.setInfoid(infoid);
        return this;
    }

    public void setInfoid(String infoid) {
        this.infoid = infoid == null ? null : infoid.trim();
    }

    public String getAction() {
        return action;
    }

    public Haipi111DetailLog withAction(String action) {
        this.setAction(action);
        return this;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    public String getRequestdata() {
        return requestdata;
    }

    public Haipi111DetailLog withRequestdata(String requestdata) {
        this.setRequestdata(requestdata);
        return this;
    }

    public void setRequestdata(String requestdata) {
        this.requestdata = requestdata == null ? null : requestdata.trim();
    }

    public String getResponsedata() {
        return responsedata;
    }

    public Haipi111DetailLog withResponsedata(String responsedata) {
        this.setResponsedata(responsedata);
        return this;
    }

    public void setResponsedata(String responsedata) {
        this.responsedata = responsedata == null ? null : responsedata.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Haipi111DetailLog withCreateDate(Date createDate) {
        this.setCreateDate(createDate);
        return this;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}