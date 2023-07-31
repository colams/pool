package cn.colams.dal.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AirbnbRoomOwnerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AirbnbRoomOwnerExample() {
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

        public Criteria andLoardIdIsNull() {
            addCriterion("loard_id is null");
            return (Criteria) this;
        }

        public Criteria andLoardIdIsNotNull() {
            addCriterion("loard_id is not null");
            return (Criteria) this;
        }

        public Criteria andLoardIdEqualTo(String value) {
            addCriterion("loard_id =", value, "loardId");
            return (Criteria) this;
        }

        public Criteria andLoardIdNotEqualTo(String value) {
            addCriterion("loard_id <>", value, "loardId");
            return (Criteria) this;
        }

        public Criteria andLoardIdGreaterThan(String value) {
            addCriterion("loard_id >", value, "loardId");
            return (Criteria) this;
        }

        public Criteria andLoardIdGreaterThanOrEqualTo(String value) {
            addCriterion("loard_id >=", value, "loardId");
            return (Criteria) this;
        }

        public Criteria andLoardIdLessThan(String value) {
            addCriterion("loard_id <", value, "loardId");
            return (Criteria) this;
        }

        public Criteria andLoardIdLessThanOrEqualTo(String value) {
            addCriterion("loard_id <=", value, "loardId");
            return (Criteria) this;
        }

        public Criteria andLoardIdLike(String value) {
            addCriterion("loard_id like", value, "loardId");
            return (Criteria) this;
        }

        public Criteria andLoardIdNotLike(String value) {
            addCriterion("loard_id not like", value, "loardId");
            return (Criteria) this;
        }

        public Criteria andLoardIdIn(List<String> values) {
            addCriterion("loard_id in", values, "loardId");
            return (Criteria) this;
        }

        public Criteria andLoardIdNotIn(List<String> values) {
            addCriterion("loard_id not in", values, "loardId");
            return (Criteria) this;
        }

        public Criteria andLoardIdBetween(String value1, String value2) {
            addCriterion("loard_id between", value1, value2, "loardId");
            return (Criteria) this;
        }

        public Criteria andLoardIdNotBetween(String value1, String value2) {
            addCriterion("loard_id not between", value1, value2, "loardId");
            return (Criteria) this;
        }

        public Criteria andLordNameIsNull() {
            addCriterion("lord_name is null");
            return (Criteria) this;
        }

        public Criteria andLordNameIsNotNull() {
            addCriterion("lord_name is not null");
            return (Criteria) this;
        }

        public Criteria andLordNameEqualTo(String value) {
            addCriterion("lord_name =", value, "lordName");
            return (Criteria) this;
        }

        public Criteria andLordNameNotEqualTo(String value) {
            addCriterion("lord_name <>", value, "lordName");
            return (Criteria) this;
        }

        public Criteria andLordNameGreaterThan(String value) {
            addCriterion("lord_name >", value, "lordName");
            return (Criteria) this;
        }

        public Criteria andLordNameGreaterThanOrEqualTo(String value) {
            addCriterion("lord_name >=", value, "lordName");
            return (Criteria) this;
        }

        public Criteria andLordNameLessThan(String value) {
            addCriterion("lord_name <", value, "lordName");
            return (Criteria) this;
        }

        public Criteria andLordNameLessThanOrEqualTo(String value) {
            addCriterion("lord_name <=", value, "lordName");
            return (Criteria) this;
        }

        public Criteria andLordNameLike(String value) {
            addCriterion("lord_name like", value, "lordName");
            return (Criteria) this;
        }

        public Criteria andLordNameNotLike(String value) {
            addCriterion("lord_name not like", value, "lordName");
            return (Criteria) this;
        }

        public Criteria andLordNameIn(List<String> values) {
            addCriterion("lord_name in", values, "lordName");
            return (Criteria) this;
        }

        public Criteria andLordNameNotIn(List<String> values) {
            addCriterion("lord_name not in", values, "lordName");
            return (Criteria) this;
        }

        public Criteria andLordNameBetween(String value1, String value2) {
            addCriterion("lord_name between", value1, value2, "lordName");
            return (Criteria) this;
        }

        public Criteria andLordNameNotBetween(String value1, String value2) {
            addCriterion("lord_name not between", value1, value2, "lordName");
            return (Criteria) this;
        }

        public Criteria andLordPageIsNull() {
            addCriterion("lord_page is null");
            return (Criteria) this;
        }

        public Criteria andLordPageIsNotNull() {
            addCriterion("lord_page is not null");
            return (Criteria) this;
        }

        public Criteria andLordPageEqualTo(String value) {
            addCriterion("lord_page =", value, "lordPage");
            return (Criteria) this;
        }

        public Criteria andLordPageNotEqualTo(String value) {
            addCriterion("lord_page <>", value, "lordPage");
            return (Criteria) this;
        }

        public Criteria andLordPageGreaterThan(String value) {
            addCriterion("lord_page >", value, "lordPage");
            return (Criteria) this;
        }

        public Criteria andLordPageGreaterThanOrEqualTo(String value) {
            addCriterion("lord_page >=", value, "lordPage");
            return (Criteria) this;
        }

        public Criteria andLordPageLessThan(String value) {
            addCriterion("lord_page <", value, "lordPage");
            return (Criteria) this;
        }

        public Criteria andLordPageLessThanOrEqualTo(String value) {
            addCriterion("lord_page <=", value, "lordPage");
            return (Criteria) this;
        }

        public Criteria andLordPageLike(String value) {
            addCriterion("lord_page like", value, "lordPage");
            return (Criteria) this;
        }

        public Criteria andLordPageNotLike(String value) {
            addCriterion("lord_page not like", value, "lordPage");
            return (Criteria) this;
        }

        public Criteria andLordPageIn(List<String> values) {
            addCriterion("lord_page in", values, "lordPage");
            return (Criteria) this;
        }

        public Criteria andLordPageNotIn(List<String> values) {
            addCriterion("lord_page not in", values, "lordPage");
            return (Criteria) this;
        }

        public Criteria andLordPageBetween(String value1, String value2) {
            addCriterion("lord_page between", value1, value2, "lordPage");
            return (Criteria) this;
        }

        public Criteria andLordPageNotBetween(String value1, String value2) {
            addCriterion("lord_page not between", value1, value2, "lordPage");
            return (Criteria) this;
        }

        public Criteria andRoomsIsNull() {
            addCriterion("rooms is null");
            return (Criteria) this;
        }

        public Criteria andRoomsIsNotNull() {
            addCriterion("rooms is not null");
            return (Criteria) this;
        }

        public Criteria andRoomsEqualTo(Integer value) {
            addCriterion("rooms =", value, "rooms");
            return (Criteria) this;
        }

        public Criteria andRoomsNotEqualTo(Integer value) {
            addCriterion("rooms <>", value, "rooms");
            return (Criteria) this;
        }

        public Criteria andRoomsGreaterThan(Integer value) {
            addCriterion("rooms >", value, "rooms");
            return (Criteria) this;
        }

        public Criteria andRoomsGreaterThanOrEqualTo(Integer value) {
            addCriterion("rooms >=", value, "rooms");
            return (Criteria) this;
        }

        public Criteria andRoomsLessThan(Integer value) {
            addCriterion("rooms <", value, "rooms");
            return (Criteria) this;
        }

        public Criteria andRoomsLessThanOrEqualTo(Integer value) {
            addCriterion("rooms <=", value, "rooms");
            return (Criteria) this;
        }

        public Criteria andRoomsIn(List<Integer> values) {
            addCriterion("rooms in", values, "rooms");
            return (Criteria) this;
        }

        public Criteria andRoomsNotIn(List<Integer> values) {
            addCriterion("rooms not in", values, "rooms");
            return (Criteria) this;
        }

        public Criteria andRoomsBetween(Integer value1, Integer value2) {
            addCriterion("rooms between", value1, value2, "rooms");
            return (Criteria) this;
        }

        public Criteria andRoomsNotBetween(Integer value1, Integer value2) {
            addCriterion("rooms not between", value1, value2, "rooms");
            return (Criteria) this;
        }

        public Criteria andAirbnbIdIsNull() {
            addCriterion("airbnb_id is null");
            return (Criteria) this;
        }

        public Criteria andAirbnbIdIsNotNull() {
            addCriterion("airbnb_id is not null");
            return (Criteria) this;
        }

        public Criteria andAirbnbIdEqualTo(Long value) {
            addCriterion("airbnb_id =", value, "airbnbId");
            return (Criteria) this;
        }

        public Criteria andAirbnbIdNotEqualTo(Long value) {
            addCriterion("airbnb_id <>", value, "airbnbId");
            return (Criteria) this;
        }

        public Criteria andAirbnbIdGreaterThan(Long value) {
            addCriterion("airbnb_id >", value, "airbnbId");
            return (Criteria) this;
        }

        public Criteria andAirbnbIdGreaterThanOrEqualTo(Long value) {
            addCriterion("airbnb_id >=", value, "airbnbId");
            return (Criteria) this;
        }

        public Criteria andAirbnbIdLessThan(Long value) {
            addCriterion("airbnb_id <", value, "airbnbId");
            return (Criteria) this;
        }

        public Criteria andAirbnbIdLessThanOrEqualTo(Long value) {
            addCriterion("airbnb_id <=", value, "airbnbId");
            return (Criteria) this;
        }

        public Criteria andAirbnbIdIn(List<Long> values) {
            addCriterion("airbnb_id in", values, "airbnbId");
            return (Criteria) this;
        }

        public Criteria andAirbnbIdNotIn(List<Long> values) {
            addCriterion("airbnb_id not in", values, "airbnbId");
            return (Criteria) this;
        }

        public Criteria andAirbnbIdBetween(Long value1, Long value2) {
            addCriterion("airbnb_id between", value1, value2, "airbnbId");
            return (Criteria) this;
        }

        public Criteria andAirbnbIdNotBetween(Long value1, Long value2) {
            addCriterion("airbnb_id not between", value1, value2, "airbnbId");
            return (Criteria) this;
        }

        public Criteria andProcessStatusIsNull() {
            addCriterion("process_status is null");
            return (Criteria) this;
        }

        public Criteria andProcessStatusIsNotNull() {
            addCriterion("process_status is not null");
            return (Criteria) this;
        }

        public Criteria andProcessStatusEqualTo(Integer value) {
            addCriterion("process_status =", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusNotEqualTo(Integer value) {
            addCriterion("process_status <>", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusGreaterThan(Integer value) {
            addCriterion("process_status >", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("process_status >=", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusLessThan(Integer value) {
            addCriterion("process_status <", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusLessThanOrEqualTo(Integer value) {
            addCriterion("process_status <=", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusIn(List<Integer> values) {
            addCriterion("process_status in", values, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusNotIn(List<Integer> values) {
            addCriterion("process_status not in", values, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusBetween(Integer value1, Integer value2) {
            addCriterion("process_status between", value1, value2, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("process_status not between", value1, value2, "processStatus");
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

        public Criteria andBriefIsNull() {
            addCriterion("brief is null");
            return (Criteria) this;
        }

        public Criteria andBriefIsNotNull() {
            addCriterion("brief is not null");
            return (Criteria) this;
        }

        public Criteria andBriefEqualTo(String value) {
            addCriterion("brief =", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotEqualTo(String value) {
            addCriterion("brief <>", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefGreaterThan(String value) {
            addCriterion("brief >", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefGreaterThanOrEqualTo(String value) {
            addCriterion("brief >=", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLessThan(String value) {
            addCriterion("brief <", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLessThanOrEqualTo(String value) {
            addCriterion("brief <=", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefLike(String value) {
            addCriterion("brief like", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotLike(String value) {
            addCriterion("brief not like", value, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefIn(List<String> values) {
            addCriterion("brief in", values, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotIn(List<String> values) {
            addCriterion("brief not in", values, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefBetween(String value1, String value2) {
            addCriterion("brief between", value1, value2, "brief");
            return (Criteria) this;
        }

        public Criteria andBriefNotBetween(String value1, String value2) {
            addCriterion("brief not between", value1, value2, "brief");
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

        public Criteria andLoardIdLikeInsensitive(String value) {
            addCriterion("upper(loard_id) like", value.toUpperCase(), "loardId");
            return (Criteria) this;
        }

        public Criteria andLordNameLikeInsensitive(String value) {
            addCriterion("upper(lord_name) like", value.toUpperCase(), "lordName");
            return (Criteria) this;
        }

        public Criteria andLordPageLikeInsensitive(String value) {
            addCriterion("upper(lord_page) like", value.toUpperCase(), "lordPage");
            return (Criteria) this;
        }

        public Criteria andEvaluateLikeInsensitive(String value) {
            addCriterion("upper(evaluate) like", value.toUpperCase(), "evaluate");
            return (Criteria) this;
        }

        public Criteria andBriefLikeInsensitive(String value) {
            addCriterion("upper(brief) like", value.toUpperCase(), "brief");
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