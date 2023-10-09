package cn.colams.dal.entity;

import java.util.Date;

public class BasicConfig {
    private Long id;

    private String configKey;

    private String configValue;

    private Date datechangeLasttime;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public BasicConfig withId(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConfigKey() {
        return configKey;
    }

    public BasicConfig withConfigKey(String configKey) {
        this.setConfigKey(configKey);
        return this;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey == null ? null : configKey.trim();
    }

    public String getConfigValue() {
        return configValue;
    }

    public BasicConfig withConfigValue(String configValue) {
        this.setConfigValue(configValue);
        return this;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue == null ? null : configValue.trim();
    }

    public Date getDatechangeLasttime() {
        return datechangeLasttime;
    }

    public BasicConfig withDatechangeLasttime(Date datechangeLasttime) {
        this.setDatechangeLasttime(datechangeLasttime);
        return this;
    }

    public void setDatechangeLasttime(Date datechangeLasttime) {
        this.datechangeLasttime = datechangeLasttime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public BasicConfig withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}