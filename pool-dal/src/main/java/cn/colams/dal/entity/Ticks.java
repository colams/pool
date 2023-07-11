package cn.colams.dal.entity;

import java.util.Date;

public class Ticks {
    private Long id;

    private Date tick;

    private Date createDate;

    public Long getId() {
        return id;
    }

    public Ticks withId(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTick() {
        return tick;
    }

    public Ticks withTick(Date tick) {
        this.setTick(tick);
        return this;
    }

    public void setTick(Date tick) {
        this.tick = tick;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Ticks withCreateDate(Date createDate) {
        this.setCreateDate(createDate);
        return this;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}