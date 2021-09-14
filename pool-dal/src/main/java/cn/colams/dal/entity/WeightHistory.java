package cn.colams.dal.entity;

import java.util.Date;

public class WeightHistory {
    private Integer id;

    private Double weight;

    private Date createDate;

    public Integer getId() {
        return id;
    }

    public WeightHistory withId(Integer id) {
        this.setId(id);
        return this;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getWeight() {
        return weight;
    }

    public WeightHistory withWeight(Double weight) {
        this.setWeight(weight);
        return this;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public WeightHistory withCreateDate(Date createDate) {
        this.setCreateDate(createDate);
        return this;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}