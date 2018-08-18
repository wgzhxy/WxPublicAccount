package com.yisutech.corp.domain.repository.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WxResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WxResourceExample() {
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

        public Criteria andRsCodeIsNull() {
            addCriterion("rs_code is null");
            return (Criteria) this;
        }

        public Criteria andRsCodeIsNotNull() {
            addCriterion("rs_code is not null");
            return (Criteria) this;
        }

        public Criteria andRsCodeEqualTo(String value) {
            addCriterion("rs_code =", value, "rsCode");
            return (Criteria) this;
        }

        public Criteria andRsCodeNotEqualTo(String value) {
            addCriterion("rs_code <>", value, "rsCode");
            return (Criteria) this;
        }

        public Criteria andRsCodeGreaterThan(String value) {
            addCriterion("rs_code >", value, "rsCode");
            return (Criteria) this;
        }

        public Criteria andRsCodeGreaterThanOrEqualTo(String value) {
            addCriterion("rs_code >=", value, "rsCode");
            return (Criteria) this;
        }

        public Criteria andRsCodeLessThan(String value) {
            addCriterion("rs_code <", value, "rsCode");
            return (Criteria) this;
        }

        public Criteria andRsCodeLessThanOrEqualTo(String value) {
            addCriterion("rs_code <=", value, "rsCode");
            return (Criteria) this;
        }

        public Criteria andRsCodeLike(String value) {
            addCriterion("rs_code like", value, "rsCode");
            return (Criteria) this;
        }

        public Criteria andRsCodeNotLike(String value) {
            addCriterion("rs_code not like", value, "rsCode");
            return (Criteria) this;
        }

        public Criteria andRsCodeIn(List<String> values) {
            addCriterion("rs_code in", values, "rsCode");
            return (Criteria) this;
        }

        public Criteria andRsCodeNotIn(List<String> values) {
            addCriterion("rs_code not in", values, "rsCode");
            return (Criteria) this;
        }

        public Criteria andRsCodeBetween(String value1, String value2) {
            addCriterion("rs_code between", value1, value2, "rsCode");
            return (Criteria) this;
        }

        public Criteria andRsCodeNotBetween(String value1, String value2) {
            addCriterion("rs_code not between", value1, value2, "rsCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeIsNull() {
            addCriterion("app_code is null");
            return (Criteria) this;
        }

        public Criteria andAppCodeIsNotNull() {
            addCriterion("app_code is not null");
            return (Criteria) this;
        }

        public Criteria andAppCodeEqualTo(String value) {
            addCriterion("app_code =", value, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeNotEqualTo(String value) {
            addCriterion("app_code <>", value, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeGreaterThan(String value) {
            addCriterion("app_code >", value, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeGreaterThanOrEqualTo(String value) {
            addCriterion("app_code >=", value, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeLessThan(String value) {
            addCriterion("app_code <", value, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeLessThanOrEqualTo(String value) {
            addCriterion("app_code <=", value, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeLike(String value) {
            addCriterion("app_code like", value, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeNotLike(String value) {
            addCriterion("app_code not like", value, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeIn(List<String> values) {
            addCriterion("app_code in", values, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeNotIn(List<String> values) {
            addCriterion("app_code not in", values, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeBetween(String value1, String value2) {
            addCriterion("app_code between", value1, value2, "appCode");
            return (Criteria) this;
        }

        public Criteria andAppCodeNotBetween(String value1, String value2) {
            addCriterion("app_code not between", value1, value2, "appCode");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andModifierIsNull() {
            addCriterion("modifier is null");
            return (Criteria) this;
        }

        public Criteria andModifierIsNotNull() {
            addCriterion("modifier is not null");
            return (Criteria) this;
        }

        public Criteria andModifierEqualTo(String value) {
            addCriterion("modifier =", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotEqualTo(String value) {
            addCriterion("modifier <>", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThan(String value) {
            addCriterion("modifier >", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThanOrEqualTo(String value) {
            addCriterion("modifier >=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThan(String value) {
            addCriterion("modifier <", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThanOrEqualTo(String value) {
            addCriterion("modifier <=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLike(String value) {
            addCriterion("modifier like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotLike(String value) {
            addCriterion("modifier not like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierIn(List<String> values) {
            addCriterion("modifier in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotIn(List<String> values) {
            addCriterion("modifier not in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierBetween(String value1, String value2) {
            addCriterion("modifier between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotBetween(String value1, String value2) {
            addCriterion("modifier not between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andGmtModifyTimeIsNull() {
            addCriterion("gmt_modify_time is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifyTimeIsNotNull() {
            addCriterion("gmt_modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifyTimeEqualTo(Date value) {
            addCriterion("gmt_modify_time =", value, "gmtModifyTime");
            return (Criteria) this;
        }

        public Criteria andGmtModifyTimeNotEqualTo(Date value) {
            addCriterion("gmt_modify_time <>", value, "gmtModifyTime");
            return (Criteria) this;
        }

        public Criteria andGmtModifyTimeGreaterThan(Date value) {
            addCriterion("gmt_modify_time >", value, "gmtModifyTime");
            return (Criteria) this;
        }

        public Criteria andGmtModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modify_time >=", value, "gmtModifyTime");
            return (Criteria) this;
        }

        public Criteria andGmtModifyTimeLessThan(Date value) {
            addCriterion("gmt_modify_time <", value, "gmtModifyTime");
            return (Criteria) this;
        }

        public Criteria andGmtModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modify_time <=", value, "gmtModifyTime");
            return (Criteria) this;
        }

        public Criteria andGmtModifyTimeIn(List<Date> values) {
            addCriterion("gmt_modify_time in", values, "gmtModifyTime");
            return (Criteria) this;
        }

        public Criteria andGmtModifyTimeNotIn(List<Date> values) {
            addCriterion("gmt_modify_time not in", values, "gmtModifyTime");
            return (Criteria) this;
        }

        public Criteria andGmtModifyTimeBetween(Date value1, Date value2) {
            addCriterion("gmt_modify_time between", value1, value2, "gmtModifyTime");
            return (Criteria) this;
        }

        public Criteria andGmtModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modify_time not between", value1, value2, "gmtModifyTime");
            return (Criteria) this;
        }

        public Criteria andGmtCreateTimeIsNull() {
            addCriterion("gmt_create_time is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateTimeIsNotNull() {
            addCriterion("gmt_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateTimeEqualTo(Date value) {
            addCriterion("gmt_create_time =", value, "gmtCreateTime");
            return (Criteria) this;
        }

        public Criteria andGmtCreateTimeNotEqualTo(Date value) {
            addCriterion("gmt_create_time <>", value, "gmtCreateTime");
            return (Criteria) this;
        }

        public Criteria andGmtCreateTimeGreaterThan(Date value) {
            addCriterion("gmt_create_time >", value, "gmtCreateTime");
            return (Criteria) this;
        }

        public Criteria andGmtCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create_time >=", value, "gmtCreateTime");
            return (Criteria) this;
        }

        public Criteria andGmtCreateTimeLessThan(Date value) {
            addCriterion("gmt_create_time <", value, "gmtCreateTime");
            return (Criteria) this;
        }

        public Criteria andGmtCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create_time <=", value, "gmtCreateTime");
            return (Criteria) this;
        }

        public Criteria andGmtCreateTimeIn(List<Date> values) {
            addCriterion("gmt_create_time in", values, "gmtCreateTime");
            return (Criteria) this;
        }

        public Criteria andGmtCreateTimeNotIn(List<Date> values) {
            addCriterion("gmt_create_time not in", values, "gmtCreateTime");
            return (Criteria) this;
        }

        public Criteria andGmtCreateTimeBetween(Date value1, Date value2) {
            addCriterion("gmt_create_time between", value1, value2, "gmtCreateTime");
            return (Criteria) this;
        }

        public Criteria andGmtCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create_time not between", value1, value2, "gmtCreateTime");
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