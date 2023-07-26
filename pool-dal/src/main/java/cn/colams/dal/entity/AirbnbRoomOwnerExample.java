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

        public Criteria andNameIsNull() {
            addCriterion("\"name\" is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("\"name\" is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("\"name\" =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("\"name\" <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("\"name\" >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("\"name\" >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("\"name\" <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("\"name\" <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("\"name\" like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("\"name\" not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("\"name\" in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("\"name\" not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("\"name\" between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("\"name\" not between", value1, value2, "name");
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

        public Criteria andNameLikeInsensitive(String value) {
            addCriterion("upper(\"name\") like", value.toUpperCase(), "name");
            return (Criteria) this;
        }

        public Criteria andLordPageLikeInsensitive(String value) {
            addCriterion("upper(lord_page) like", value.toUpperCase(), "lordPage");
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