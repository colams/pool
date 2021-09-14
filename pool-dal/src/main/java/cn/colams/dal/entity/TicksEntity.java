package cn.colams.dal.entity;

import java.util.Date;

public class TicksEntity {
    private Integer id;

    private Date tick;

    public Integer getId() {
        return id;
    }

    public TicksEntity withId(Integer id) {
        this.setId(id);
        return this;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTick() {
        return tick;
    }

    public TicksEntity withTick(Date tick) {
        this.setTick(tick);
        return this;
    }

    public void setTick(Date tick) {
        this.tick = tick;
    }
}