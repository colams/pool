package cn.colams.biz.model;

import java.sql.Timestamp;

/**
 * Created by zhangzt on 2018/2/9.
 */
public class Ticks {

    private int id;

    private Timestamp tick;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTick() {
        return tick;
    }

    public void setTick(Timestamp tick) {
        this.tick = tick;
    }
}
