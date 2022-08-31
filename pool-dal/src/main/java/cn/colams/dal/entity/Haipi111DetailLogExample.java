package cn.colams.dal.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Haipi111DetailLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Haipi111DetailLogExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("\"uid\" is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("\"uid\" is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("\"uid\" =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("\"uid\" <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("\"uid\" >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("\"uid\" >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("\"uid\" <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("\"uid\" <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("\"uid\" like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("\"uid\" not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("\"uid\" in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("\"uid\" not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("\"uid\" between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("\"uid\" not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andInfoidIsNull() {
            addCriterion("infoid is null");
            return (Criteria) this;
        }

        public Criteria andInfoidIsNotNull() {
            addCriterion("infoid is not null");
            return (Criteria) this;
        }

        public Criteria andInfoidEqualTo(String value) {
            addCriterion("infoid =", value, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidNotEqualTo(String value) {
            addCriterion("infoid <>", value, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidGreaterThan(String value) {
            addCriterion("infoid >", value, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidGreaterThanOrEqualTo(String value) {
            addCriterion("infoid >=", value, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidLessThan(String value) {
            addCriterion("infoid <", value, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidLessThanOrEqualTo(String value) {
            addCriterion("infoid <=", value, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidLike(String value) {
            addCriterion("infoid like", value, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidNotLike(String value) {
            addCriterion("infoid not like", value, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidIn(List<String> values) {
            addCriterion("infoid in", values, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidNotIn(List<String> values) {
            addCriterion("infoid not in", values, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidBetween(String value1, String value2) {
            addCriterion("infoid between", value1, value2, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidNotBetween(String value1, String value2) {
            addCriterion("infoid not between", value1, value2, "infoid");
            return (Criteria) this;
        }

        public Criteria andActionIsNull() {
            addCriterion("\"action\" is null");
            return (Criteria) this;
        }

        public Criteria andActionIsNotNull() {
            addCriterion("\"action\" is not null");
            return (Criteria) this;
        }

        public Criteria andActionEqualTo(String value) {
            addCriterion("\"action\" =", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotEqualTo(String value) {
            addCriterion("\"action\" <>", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionGreaterThan(String value) {
            addCriterion("\"action\" >", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionGreaterThanOrEqualTo(String value) {
            addCriterion("\"action\" >=", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionLessThan(String value) {
            addCriterion("\"action\" <", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionLessThanOrEqualTo(String value) {
            addCriterion("\"action\" <=", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionLike(String value) {
            addCriterion("\"action\" like", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotLike(String value) {
            addCriterion("\"action\" not like", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionIn(List<String> values) {
            addCriterion("\"action\" in", values, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotIn(List<String> values) {
            addCriterion("\"action\" not in", values, "action");
            return (Criteria) this;
        }

        public Criteria andActionBetween(String value1, String value2) {
            addCriterion("\"action\" between", value1, value2, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotBetween(String value1, String value2) {
            addCriterion("\"action\" not between", value1, value2, "action");
            return (Criteria) this;
        }

        public Criteria andRequestdataIsNull() {
            addCriterion("requestdata is null");
            return (Criteria) this;
        }

        public Criteria andRequestdataIsNotNull() {
            addCriterion("requestdata is not null");
            return (Criteria) this;
        }

        public Criteria andRequestdataEqualTo(String value) {
            addCriterion("requestdata =", value, "requestdata");
            return (Criteria) this;
        }

        public Criteria andRequestdataNotEqualTo(String value) {
            addCriterion("requestdata <>", value, "requestdata");
            return (Criteria) this;
        }

        public Criteria andRequestdataGreaterThan(String value) {
            addCriterion("requestdata >", value, "requestdata");
            return (Criteria) this;
        }

        public Criteria andRequestdataGreaterThanOrEqualTo(String value) {
            addCriterion("requestdata >=", value, "requestdata");
            return (Criteria) this;
        }

        public Criteria andRequestdataLessThan(String value) {
            addCriterion("requestdata <", value, "requestdata");
            return (Criteria) this;
        }

        public Criteria andRequestdataLessThanOrEqualTo(String value) {
            addCriterion("requestdata <=", value, "requestdata");
            return (Criteria) this;
        }

        public Criteria andRequestdataLike(String value) {
            addCriterion("requestdata like", value, "requestdata");
            return (Criteria) this;
        }

        public Criteria andRequestdataNotLike(String value) {
            addCriterion("requestdata not like", value, "requestdata");
            return (Criteria) this;
        }

        public Criteria andRequestdataIn(List<String> values) {
            addCriterion("requestdata in", values, "requestdata");
            return (Criteria) this;
        }

        public Criteria andRequestdataNotIn(List<String> values) {
            addCriterion("requestdata not in", values, "requestdata");
            return (Criteria) this;
        }

        public Criteria andRequestdataBetween(String value1, String value2) {
            addCriterion("requestdata between", value1, value2, "requestdata");
            return (Criteria) this;
        }

        public Criteria andRequestdataNotBetween(String value1, String value2) {
            addCriterion("requestdata not between", value1, value2, "requestdata");
            return (Criteria) this;
        }

        public Criteria andResponsedataIsNull() {
            addCriterion("responsedata is null");
            return (Criteria) this;
        }

        public Criteria andResponsedataIsNotNull() {
            addCriterion("responsedata is not null");
            return (Criteria) this;
        }

        public Criteria andResponsedataEqualTo(String value) {
            addCriterion("responsedata =", value, "responsedata");
            return (Criteria) this;
        }

        public Criteria andResponsedataNotEqualTo(String value) {
            addCriterion("responsedata <>", value, "responsedata");
            return (Criteria) this;
        }

        public Criteria andResponsedataGreaterThan(String value) {
            addCriterion("responsedata >", value, "responsedata");
            return (Criteria) this;
        }

        public Criteria andResponsedataGreaterThanOrEqualTo(String value) {
            addCriterion("responsedata >=", value, "responsedata");
            return (Criteria) this;
        }

        public Criteria andResponsedataLessThan(String value) {
            addCriterion("responsedata <", value, "responsedata");
            return (Criteria) this;
        }

        public Criteria andResponsedataLessThanOrEqualTo(String value) {
            addCriterion("responsedata <=", value, "responsedata");
            return (Criteria) this;
        }

        public Criteria andResponsedataLike(String value) {
            addCriterion("responsedata like", value, "responsedata");
            return (Criteria) this;
        }

        public Criteria andResponsedataNotLike(String value) {
            addCriterion("responsedata not like", value, "responsedata");
            return (Criteria) this;
        }

        public Criteria andResponsedataIn(List<String> values) {
            addCriterion("responsedata in", values, "responsedata");
            return (Criteria) this;
        }

        public Criteria andResponsedataNotIn(List<String> values) {
            addCriterion("responsedata not in", values, "responsedata");
            return (Criteria) this;
        }

        public Criteria andResponsedataBetween(String value1, String value2) {
            addCriterion("responsedata between", value1, value2, "responsedata");
            return (Criteria) this;
        }

        public Criteria andResponsedataNotBetween(String value1, String value2) {
            addCriterion("responsedata not between", value1, value2, "responsedata");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUidLikeInsensitive(String value) {
            addCriterion("upper(\"uid\") like", value.toUpperCase(), "uid");
            return (Criteria) this;
        }

        public Criteria andInfoidLikeInsensitive(String value) {
            addCriterion("upper(infoid) like", value.toUpperCase(), "infoid");
            return (Criteria) this;
        }

        public Criteria andActionLikeInsensitive(String value) {
            addCriterion("upper(\"action\") like", value.toUpperCase(), "action");
            return (Criteria) this;
        }

        public Criteria andRequestdataLikeInsensitive(String value) {
            addCriterion("upper(requestdata) like", value.toUpperCase(), "requestdata");
            return (Criteria) this;
        }

        public Criteria andResponsedataLikeInsensitive(String value) {
            addCriterion("upper(responsedata) like", value.toUpperCase(), "responsedata");
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