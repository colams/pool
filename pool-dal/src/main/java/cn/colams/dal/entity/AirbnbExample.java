package cn.colams.dal.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AirbnbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AirbnbExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNull() {
            addCriterion("room_id is null");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNotNull() {
            addCriterion("room_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomIdEqualTo(String value) {
            addCriterion("room_id =", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotEqualTo(String value) {
            addCriterion("room_id <>", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThan(String value) {
            addCriterion("room_id >", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThanOrEqualTo(String value) {
            addCriterion("room_id >=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThan(String value) {
            addCriterion("room_id <", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThanOrEqualTo(String value) {
            addCriterion("room_id <=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLike(String value) {
            addCriterion("room_id like", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotLike(String value) {
            addCriterion("room_id not like", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIn(List<String> values) {
            addCriterion("room_id in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotIn(List<String> values) {
            addCriterion("room_id not in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdBetween(String value1, String value2) {
            addCriterion("room_id between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotBetween(String value1, String value2) {
            addCriterion("room_id not between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomNameIsNull() {
            addCriterion("room_name is null");
            return (Criteria) this;
        }

        public Criteria andRoomNameIsNotNull() {
            addCriterion("room_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoomNameEqualTo(String value) {
            addCriterion("room_name =", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotEqualTo(String value) {
            addCriterion("room_name <>", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameGreaterThan(String value) {
            addCriterion("room_name >", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameGreaterThanOrEqualTo(String value) {
            addCriterion("room_name >=", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLessThan(String value) {
            addCriterion("room_name <", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLessThanOrEqualTo(String value) {
            addCriterion("room_name <=", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLike(String value) {
            addCriterion("room_name like", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotLike(String value) {
            addCriterion("room_name not like", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameIn(List<String> values) {
            addCriterion("room_name in", values, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotIn(List<String> values) {
            addCriterion("room_name not in", values, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameBetween(String value1, String value2) {
            addCriterion("room_name between", value1, value2, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotBetween(String value1, String value2) {
            addCriterion("room_name not between", value1, value2, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomUrlIsNull() {
            addCriterion("room_url is null");
            return (Criteria) this;
        }

        public Criteria andRoomUrlIsNotNull() {
            addCriterion("room_url is not null");
            return (Criteria) this;
        }

        public Criteria andRoomUrlEqualTo(String value) {
            addCriterion("room_url =", value, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlNotEqualTo(String value) {
            addCriterion("room_url <>", value, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlGreaterThan(String value) {
            addCriterion("room_url >", value, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlGreaterThanOrEqualTo(String value) {
            addCriterion("room_url >=", value, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlLessThan(String value) {
            addCriterion("room_url <", value, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlLessThanOrEqualTo(String value) {
            addCriterion("room_url <=", value, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlLike(String value) {
            addCriterion("room_url like", value, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlNotLike(String value) {
            addCriterion("room_url not like", value, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlIn(List<String> values) {
            addCriterion("room_url in", values, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlNotIn(List<String> values) {
            addCriterion("room_url not in", values, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlBetween(String value1, String value2) {
            addCriterion("room_url between", value1, value2, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andRoomUrlNotBetween(String value1, String value2) {
            addCriterion("room_url not between", value1, value2, "roomUrl");
            return (Criteria) this;
        }

        public Criteria andLandlordIdIsNull() {
            addCriterion("landlord_id is null");
            return (Criteria) this;
        }

        public Criteria andLandlordIdIsNotNull() {
            addCriterion("landlord_id is not null");
            return (Criteria) this;
        }

        public Criteria andLandlordIdEqualTo(String value) {
            addCriterion("landlord_id =", value, "landlordId");
            return (Criteria) this;
        }

        public Criteria andLandlordIdNotEqualTo(String value) {
            addCriterion("landlord_id <>", value, "landlordId");
            return (Criteria) this;
        }

        public Criteria andLandlordIdGreaterThan(String value) {
            addCriterion("landlord_id >", value, "landlordId");
            return (Criteria) this;
        }

        public Criteria andLandlordIdGreaterThanOrEqualTo(String value) {
            addCriterion("landlord_id >=", value, "landlordId");
            return (Criteria) this;
        }

        public Criteria andLandlordIdLessThan(String value) {
            addCriterion("landlord_id <", value, "landlordId");
            return (Criteria) this;
        }

        public Criteria andLandlordIdLessThanOrEqualTo(String value) {
            addCriterion("landlord_id <=", value, "landlordId");
            return (Criteria) this;
        }

        public Criteria andLandlordIdLike(String value) {
            addCriterion("landlord_id like", value, "landlordId");
            return (Criteria) this;
        }

        public Criteria andLandlordIdNotLike(String value) {
            addCriterion("landlord_id not like", value, "landlordId");
            return (Criteria) this;
        }

        public Criteria andLandlordIdIn(List<String> values) {
            addCriterion("landlord_id in", values, "landlordId");
            return (Criteria) this;
        }

        public Criteria andLandlordIdNotIn(List<String> values) {
            addCriterion("landlord_id not in", values, "landlordId");
            return (Criteria) this;
        }

        public Criteria andLandlordIdBetween(String value1, String value2) {
            addCriterion("landlord_id between", value1, value2, "landlordId");
            return (Criteria) this;
        }

        public Criteria andLandlordIdNotBetween(String value1, String value2) {
            addCriterion("landlord_id not between", value1, value2, "landlordId");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(String value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(String value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(String value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(String value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(String value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(String value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLike(String value) {
            addCriterion("price like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotLike(String value) {
            addCriterion("price not like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<String> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<String> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(String value1, String value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(String value1, String value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andRoomLocationIsNull() {
            addCriterion("room_location is null");
            return (Criteria) this;
        }

        public Criteria andRoomLocationIsNotNull() {
            addCriterion("room_location is not null");
            return (Criteria) this;
        }

        public Criteria andRoomLocationEqualTo(String value) {
            addCriterion("room_location =", value, "roomLocation");
            return (Criteria) this;
        }

        public Criteria andRoomLocationNotEqualTo(String value) {
            addCriterion("room_location <>", value, "roomLocation");
            return (Criteria) this;
        }

        public Criteria andRoomLocationGreaterThan(String value) {
            addCriterion("room_location >", value, "roomLocation");
            return (Criteria) this;
        }

        public Criteria andRoomLocationGreaterThanOrEqualTo(String value) {
            addCriterion("room_location >=", value, "roomLocation");
            return (Criteria) this;
        }

        public Criteria andRoomLocationLessThan(String value) {
            addCriterion("room_location <", value, "roomLocation");
            return (Criteria) this;
        }

        public Criteria andRoomLocationLessThanOrEqualTo(String value) {
            addCriterion("room_location <=", value, "roomLocation");
            return (Criteria) this;
        }

        public Criteria andRoomLocationLike(String value) {
            addCriterion("room_location like", value, "roomLocation");
            return (Criteria) this;
        }

        public Criteria andRoomLocationNotLike(String value) {
            addCriterion("room_location not like", value, "roomLocation");
            return (Criteria) this;
        }

        public Criteria andRoomLocationIn(List<String> values) {
            addCriterion("room_location in", values, "roomLocation");
            return (Criteria) this;
        }

        public Criteria andRoomLocationNotIn(List<String> values) {
            addCriterion("room_location not in", values, "roomLocation");
            return (Criteria) this;
        }

        public Criteria andRoomLocationBetween(String value1, String value2) {
            addCriterion("room_location between", value1, value2, "roomLocation");
            return (Criteria) this;
        }

        public Criteria andRoomLocationNotBetween(String value1, String value2) {
            addCriterion("room_location not between", value1, value2, "roomLocation");
            return (Criteria) this;
        }

        public Criteria andDealStatusIsNull() {
            addCriterion("deal_status is null");
            return (Criteria) this;
        }

        public Criteria andDealStatusIsNotNull() {
            addCriterion("deal_status is not null");
            return (Criteria) this;
        }

        public Criteria andDealStatusEqualTo(Integer value) {
            addCriterion("deal_status =", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusNotEqualTo(Integer value) {
            addCriterion("deal_status <>", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusGreaterThan(Integer value) {
            addCriterion("deal_status >", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("deal_status >=", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusLessThan(Integer value) {
            addCriterion("deal_status <", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusLessThanOrEqualTo(Integer value) {
            addCriterion("deal_status <=", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusIn(List<Integer> values) {
            addCriterion("deal_status in", values, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusNotIn(List<Integer> values) {
            addCriterion("deal_status not in", values, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusBetween(Integer value1, Integer value2) {
            addCriterion("deal_status between", value1, value2, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("deal_status not between", value1, value2, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andPictureCountIsNull() {
            addCriterion("picture_count is null");
            return (Criteria) this;
        }

        public Criteria andPictureCountIsNotNull() {
            addCriterion("picture_count is not null");
            return (Criteria) this;
        }

        public Criteria andPictureCountEqualTo(Integer value) {
            addCriterion("picture_count =", value, "pictureCount");
            return (Criteria) this;
        }

        public Criteria andPictureCountNotEqualTo(Integer value) {
            addCriterion("picture_count <>", value, "pictureCount");
            return (Criteria) this;
        }

        public Criteria andPictureCountGreaterThan(Integer value) {
            addCriterion("picture_count >", value, "pictureCount");
            return (Criteria) this;
        }

        public Criteria andPictureCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("picture_count >=", value, "pictureCount");
            return (Criteria) this;
        }

        public Criteria andPictureCountLessThan(Integer value) {
            addCriterion("picture_count <", value, "pictureCount");
            return (Criteria) this;
        }

        public Criteria andPictureCountLessThanOrEqualTo(Integer value) {
            addCriterion("picture_count <=", value, "pictureCount");
            return (Criteria) this;
        }

        public Criteria andPictureCountIn(List<Integer> values) {
            addCriterion("picture_count in", values, "pictureCount");
            return (Criteria) this;
        }

        public Criteria andPictureCountNotIn(List<Integer> values) {
            addCriterion("picture_count not in", values, "pictureCount");
            return (Criteria) this;
        }

        public Criteria andPictureCountBetween(Integer value1, Integer value2) {
            addCriterion("picture_count between", value1, value2, "pictureCount");
            return (Criteria) this;
        }

        public Criteria andPictureCountNotBetween(Integer value1, Integer value2) {
            addCriterion("picture_count not between", value1, value2, "pictureCount");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andEvaluateIsNull() {
            addCriterion("evaluate is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateIsNotNull() {
            addCriterion("evaluate is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateEqualTo(String value) {
            addCriterion("evaluate =", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateNotEqualTo(String value) {
            addCriterion("evaluate <>", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateGreaterThan(String value) {
            addCriterion("evaluate >", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateGreaterThanOrEqualTo(String value) {
            addCriterion("evaluate >=", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateLessThan(String value) {
            addCriterion("evaluate <", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateLessThanOrEqualTo(String value) {
            addCriterion("evaluate <=", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateLike(String value) {
            addCriterion("evaluate like", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateNotLike(String value) {
            addCriterion("evaluate not like", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateIn(List<String> values) {
            addCriterion("evaluate in", values, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateNotIn(List<String> values) {
            addCriterion("evaluate not in", values, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateBetween(String value1, String value2) {
            addCriterion("evaluate between", value1, value2, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateNotBetween(String value1, String value2) {
            addCriterion("evaluate not between", value1, value2, "evaluate");
            return (Criteria) this;
        }

        public Criteria andRSrouceIsNull() {
            addCriterion("r_srouce is null");
            return (Criteria) this;
        }

        public Criteria andRSrouceIsNotNull() {
            addCriterion("r_srouce is not null");
            return (Criteria) this;
        }

        public Criteria andRSrouceEqualTo(Integer value) {
            addCriterion("r_srouce =", value, "rSrouce");
            return (Criteria) this;
        }

        public Criteria andRSrouceNotEqualTo(Integer value) {
            addCriterion("r_srouce <>", value, "rSrouce");
            return (Criteria) this;
        }

        public Criteria andRSrouceGreaterThan(Integer value) {
            addCriterion("r_srouce >", value, "rSrouce");
            return (Criteria) this;
        }

        public Criteria andRSrouceGreaterThanOrEqualTo(Integer value) {
            addCriterion("r_srouce >=", value, "rSrouce");
            return (Criteria) this;
        }

        public Criteria andRSrouceLessThan(Integer value) {
            addCriterion("r_srouce <", value, "rSrouce");
            return (Criteria) this;
        }

        public Criteria andRSrouceLessThanOrEqualTo(Integer value) {
            addCriterion("r_srouce <=", value, "rSrouce");
            return (Criteria) this;
        }

        public Criteria andRSrouceIn(List<Integer> values) {
            addCriterion("r_srouce in", values, "rSrouce");
            return (Criteria) this;
        }

        public Criteria andRSrouceNotIn(List<Integer> values) {
            addCriterion("r_srouce not in", values, "rSrouce");
            return (Criteria) this;
        }

        public Criteria andRSrouceBetween(Integer value1, Integer value2) {
            addCriterion("r_srouce between", value1, value2, "rSrouce");
            return (Criteria) this;
        }

        public Criteria andRSrouceNotBetween(Integer value1, Integer value2) {
            addCriterion("r_srouce not between", value1, value2, "rSrouce");
            return (Criteria) this;
        }

        public Criteria andPageIsNull() {
            addCriterion("page is null");
            return (Criteria) this;
        }

        public Criteria andPageIsNotNull() {
            addCriterion("page is not null");
            return (Criteria) this;
        }

        public Criteria andPageEqualTo(Integer value) {
            addCriterion("page =", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageNotEqualTo(Integer value) {
            addCriterion("page <>", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageGreaterThan(Integer value) {
            addCriterion("page >", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageGreaterThanOrEqualTo(Integer value) {
            addCriterion("page >=", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageLessThan(Integer value) {
            addCriterion("page <", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageLessThanOrEqualTo(Integer value) {
            addCriterion("page <=", value, "page");
            return (Criteria) this;
        }

        public Criteria andPageIn(List<Integer> values) {
            addCriterion("page in", values, "page");
            return (Criteria) this;
        }

        public Criteria andPageNotIn(List<Integer> values) {
            addCriterion("page not in", values, "page");
            return (Criteria) this;
        }

        public Criteria andPageBetween(Integer value1, Integer value2) {
            addCriterion("page between", value1, value2, "page");
            return (Criteria) this;
        }

        public Criteria andPageNotBetween(Integer value1, Integer value2) {
            addCriterion("page not between", value1, value2, "page");
            return (Criteria) this;
        }

        public Criteria andOrgUrlIsNull() {
            addCriterion("org_url is null");
            return (Criteria) this;
        }

        public Criteria andOrgUrlIsNotNull() {
            addCriterion("org_url is not null");
            return (Criteria) this;
        }

        public Criteria andOrgUrlEqualTo(String value) {
            addCriterion("org_url =", value, "orgUrl");
            return (Criteria) this;
        }

        public Criteria andOrgUrlNotEqualTo(String value) {
            addCriterion("org_url <>", value, "orgUrl");
            return (Criteria) this;
        }

        public Criteria andOrgUrlGreaterThan(String value) {
            addCriterion("org_url >", value, "orgUrl");
            return (Criteria) this;
        }

        public Criteria andOrgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("org_url >=", value, "orgUrl");
            return (Criteria) this;
        }

        public Criteria andOrgUrlLessThan(String value) {
            addCriterion("org_url <", value, "orgUrl");
            return (Criteria) this;
        }

        public Criteria andOrgUrlLessThanOrEqualTo(String value) {
            addCriterion("org_url <=", value, "orgUrl");
            return (Criteria) this;
        }

        public Criteria andOrgUrlLike(String value) {
            addCriterion("org_url like", value, "orgUrl");
            return (Criteria) this;
        }

        public Criteria andOrgUrlNotLike(String value) {
            addCriterion("org_url not like", value, "orgUrl");
            return (Criteria) this;
        }

        public Criteria andOrgUrlIn(List<String> values) {
            addCriterion("org_url in", values, "orgUrl");
            return (Criteria) this;
        }

        public Criteria andOrgUrlNotIn(List<String> values) {
            addCriterion("org_url not in", values, "orgUrl");
            return (Criteria) this;
        }

        public Criteria andOrgUrlBetween(String value1, String value2) {
            addCriterion("org_url between", value1, value2, "orgUrl");
            return (Criteria) this;
        }

        public Criteria andOrgUrlNotBetween(String value1, String value2) {
            addCriterion("org_url not between", value1, value2, "orgUrl");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andRoomIdLikeInsensitive(String value) {
            addCriterion("upper(room_id) like", value.toUpperCase(), "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomNameLikeInsensitive(String value) {
            addCriterion("upper(room_name) like", value.toUpperCase(), "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomUrlLikeInsensitive(String value) {
            addCriterion("upper(room_url) like", value.toUpperCase(), "roomUrl");
            return (Criteria) this;
        }

        public Criteria andLandlordIdLikeInsensitive(String value) {
            addCriterion("upper(landlord_id) like", value.toUpperCase(), "landlordId");
            return (Criteria) this;
        }

        public Criteria andPriceLikeInsensitive(String value) {
            addCriterion("upper(price) like", value.toUpperCase(), "price");
            return (Criteria) this;
        }

        public Criteria andRoomLocationLikeInsensitive(String value) {
            addCriterion("upper(room_location) like", value.toUpperCase(), "roomLocation");
            return (Criteria) this;
        }

        public Criteria andAreaLikeInsensitive(String value) {
            addCriterion("upper(area) like", value.toUpperCase(), "area");
            return (Criteria) this;
        }

        public Criteria andEvaluateLikeInsensitive(String value) {
            addCriterion("upper(evaluate) like", value.toUpperCase(), "evaluate");
            return (Criteria) this;
        }

        public Criteria andOrgUrlLikeInsensitive(String value) {
            addCriterion("upper(org_url) like", value.toUpperCase(), "orgUrl");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}