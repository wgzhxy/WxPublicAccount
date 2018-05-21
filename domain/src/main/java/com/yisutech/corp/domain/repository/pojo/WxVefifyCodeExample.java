package com.yisutech.corp.domain.repository.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WxVefifyCodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WxVefifyCodeExample() {
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

        public Criteria andMobleIsNull() {
            addCriterion("moble is null");
            return (Criteria) this;
        }

        public Criteria andMobleIsNotNull() {
            addCriterion("moble is not null");
            return (Criteria) this;
        }

        public Criteria andMobleEqualTo(String value) {
            addCriterion("moble =", value, "moble");
            return (Criteria) this;
        }

        public Criteria andMobleNotEqualTo(String value) {
            addCriterion("moble <>", value, "moble");
            return (Criteria) this;
        }

        public Criteria andMobleGreaterThan(String value) {
            addCriterion("moble >", value, "moble");
            return (Criteria) this;
        }

        public Criteria andMobleGreaterThanOrEqualTo(String value) {
            addCriterion("moble >=", value, "moble");
            return (Criteria) this;
        }

        public Criteria andMobleLessThan(String value) {
            addCriterion("moble <", value, "moble");
            return (Criteria) this;
        }

        public Criteria andMobleLessThanOrEqualTo(String value) {
            addCriterion("moble <=", value, "moble");
            return (Criteria) this;
        }

        public Criteria andMobleLike(String value) {
            addCriterion("moble like", value, "moble");
            return (Criteria) this;
        }

        public Criteria andMobleNotLike(String value) {
            addCriterion("moble not like", value, "moble");
            return (Criteria) this;
        }

        public Criteria andMobleIn(List<String> values) {
            addCriterion("moble in", values, "moble");
            return (Criteria) this;
        }

        public Criteria andMobleNotIn(List<String> values) {
            addCriterion("moble not in", values, "moble");
            return (Criteria) this;
        }

        public Criteria andMobleBetween(String value1, String value2) {
            addCriterion("moble between", value1, value2, "moble");
            return (Criteria) this;
        }

        public Criteria andMobleNotBetween(String value1, String value2) {
            addCriterion("moble not between", value1, value2, "moble");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("open_id <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLike(String value) {
            addCriterion("open_id like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("open_id not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("open_id not between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andVefifyCodeIsNull() {
            addCriterion("vefify_code is null");
            return (Criteria) this;
        }

        public Criteria andVefifyCodeIsNotNull() {
            addCriterion("vefify_code is not null");
            return (Criteria) this;
        }

        public Criteria andVefifyCodeEqualTo(String value) {
            addCriterion("vefify_code =", value, "vefifyCode");
            return (Criteria) this;
        }

        public Criteria andVefifyCodeNotEqualTo(String value) {
            addCriterion("vefify_code <>", value, "vefifyCode");
            return (Criteria) this;
        }

        public Criteria andVefifyCodeGreaterThan(String value) {
            addCriterion("vefify_code >", value, "vefifyCode");
            return (Criteria) this;
        }

        public Criteria andVefifyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("vefify_code >=", value, "vefifyCode");
            return (Criteria) this;
        }

        public Criteria andVefifyCodeLessThan(String value) {
            addCriterion("vefify_code <", value, "vefifyCode");
            return (Criteria) this;
        }

        public Criteria andVefifyCodeLessThanOrEqualTo(String value) {
            addCriterion("vefify_code <=", value, "vefifyCode");
            return (Criteria) this;
        }

        public Criteria andVefifyCodeLike(String value) {
            addCriterion("vefify_code like", value, "vefifyCode");
            return (Criteria) this;
        }

        public Criteria andVefifyCodeNotLike(String value) {
            addCriterion("vefify_code not like", value, "vefifyCode");
            return (Criteria) this;
        }

        public Criteria andVefifyCodeIn(List<String> values) {
            addCriterion("vefify_code in", values, "vefifyCode");
            return (Criteria) this;
        }

        public Criteria andVefifyCodeNotIn(List<String> values) {
            addCriterion("vefify_code not in", values, "vefifyCode");
            return (Criteria) this;
        }

        public Criteria andVefifyCodeBetween(String value1, String value2) {
            addCriterion("vefify_code between", value1, value2, "vefifyCode");
            return (Criteria) this;
        }

        public Criteria andVefifyCodeNotBetween(String value1, String value2) {
            addCriterion("vefify_code not between", value1, value2, "vefifyCode");
            return (Criteria) this;
        }

        public Criteria andUnionIdIsNull() {
            addCriterion("union_id is null");
            return (Criteria) this;
        }

        public Criteria andUnionIdIsNotNull() {
            addCriterion("union_id is not null");
            return (Criteria) this;
        }

        public Criteria andUnionIdEqualTo(String value) {
            addCriterion("union_id =", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdNotEqualTo(String value) {
            addCriterion("union_id <>", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdGreaterThan(String value) {
            addCriterion("union_id >", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdGreaterThanOrEqualTo(String value) {
            addCriterion("union_id >=", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdLessThan(String value) {
            addCriterion("union_id <", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdLessThanOrEqualTo(String value) {
            addCriterion("union_id <=", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdLike(String value) {
            addCriterion("union_id like", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdNotLike(String value) {
            addCriterion("union_id not like", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdIn(List<String> values) {
            addCriterion("union_id in", values, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdNotIn(List<String> values) {
            addCriterion("union_id not in", values, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdBetween(String value1, String value2) {
            addCriterion("union_id between", value1, value2, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdNotBetween(String value1, String value2) {
            addCriterion("union_id not between", value1, value2, "unionId");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIsNull() {
            addCriterion("gmt_modify is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIsNotNull() {
            addCriterion("gmt_modify is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifyEqualTo(Date value) {
            addCriterion("gmt_modify =", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotEqualTo(Date value) {
            addCriterion("gmt_modify <>", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyGreaterThan(Date value) {
            addCriterion("gmt_modify >", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modify >=", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyLessThan(Date value) {
            addCriterion("gmt_modify <", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modify <=", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIn(List<Date> values) {
            addCriterion("gmt_modify in", values, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotIn(List<Date> values) {
            addCriterion("gmt_modify not in", values, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyBetween(Date value1, Date value2) {
            addCriterion("gmt_modify between", value1, value2, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modify not between", value1, value2, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andValidTimeStampIsNull() {
            addCriterion("valid_time_stamp is null");
            return (Criteria) this;
        }

        public Criteria andValidTimeStampIsNotNull() {
            addCriterion("valid_time_stamp is not null");
            return (Criteria) this;
        }

        public Criteria andValidTimeStampEqualTo(Date value) {
            addCriterion("valid_time_stamp =", value, "validTimeStamp");
            return (Criteria) this;
        }

        public Criteria andValidTimeStampNotEqualTo(Date value) {
            addCriterion("valid_time_stamp <>", value, "validTimeStamp");
            return (Criteria) this;
        }

        public Criteria andValidTimeStampGreaterThan(Date value) {
            addCriterion("valid_time_stamp >", value, "validTimeStamp");
            return (Criteria) this;
        }

        public Criteria andValidTimeStampGreaterThanOrEqualTo(Date value) {
            addCriterion("valid_time_stamp >=", value, "validTimeStamp");
            return (Criteria) this;
        }

        public Criteria andValidTimeStampLessThan(Date value) {
            addCriterion("valid_time_stamp <", value, "validTimeStamp");
            return (Criteria) this;
        }

        public Criteria andValidTimeStampLessThanOrEqualTo(Date value) {
            addCriterion("valid_time_stamp <=", value, "validTimeStamp");
            return (Criteria) this;
        }

        public Criteria andValidTimeStampIn(List<Date> values) {
            addCriterion("valid_time_stamp in", values, "validTimeStamp");
            return (Criteria) this;
        }

        public Criteria andValidTimeStampNotIn(List<Date> values) {
            addCriterion("valid_time_stamp not in", values, "validTimeStamp");
            return (Criteria) this;
        }

        public Criteria andValidTimeStampBetween(Date value1, Date value2) {
            addCriterion("valid_time_stamp between", value1, value2, "validTimeStamp");
            return (Criteria) this;
        }

        public Criteria andValidTimeStampNotBetween(Date value1, Date value2) {
            addCriterion("valid_time_stamp not between", value1, value2, "validTimeStamp");
            return (Criteria) this;
        }

        public Criteria andExpireTimeStampIsNull() {
            addCriterion("expire_time_stamp is null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeStampIsNotNull() {
            addCriterion("expire_time_stamp is not null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeStampEqualTo(Date value) {
            addCriterion("expire_time_stamp =", value, "expireTimeStamp");
            return (Criteria) this;
        }

        public Criteria andExpireTimeStampNotEqualTo(Date value) {
            addCriterion("expire_time_stamp <>", value, "expireTimeStamp");
            return (Criteria) this;
        }

        public Criteria andExpireTimeStampGreaterThan(Date value) {
            addCriterion("expire_time_stamp >", value, "expireTimeStamp");
            return (Criteria) this;
        }

        public Criteria andExpireTimeStampGreaterThanOrEqualTo(Date value) {
            addCriterion("expire_time_stamp >=", value, "expireTimeStamp");
            return (Criteria) this;
        }

        public Criteria andExpireTimeStampLessThan(Date value) {
            addCriterion("expire_time_stamp <", value, "expireTimeStamp");
            return (Criteria) this;
        }

        public Criteria andExpireTimeStampLessThanOrEqualTo(Date value) {
            addCriterion("expire_time_stamp <=", value, "expireTimeStamp");
            return (Criteria) this;
        }

        public Criteria andExpireTimeStampIn(List<Date> values) {
            addCriterion("expire_time_stamp in", values, "expireTimeStamp");
            return (Criteria) this;
        }

        public Criteria andExpireTimeStampNotIn(List<Date> values) {
            addCriterion("expire_time_stamp not in", values, "expireTimeStamp");
            return (Criteria) this;
        }

        public Criteria andExpireTimeStampBetween(Date value1, Date value2) {
            addCriterion("expire_time_stamp between", value1, value2, "expireTimeStamp");
            return (Criteria) this;
        }

        public Criteria andExpireTimeStampNotBetween(Date value1, Date value2) {
            addCriterion("expire_time_stamp not between", value1, value2, "expireTimeStamp");
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