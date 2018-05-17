package com.yisutech.corp.domain.repository.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WxBuyRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WxBuyRecordExample() {
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

        public Criteria andProdIdIsNull() {
            addCriterion("prod_id is null");
            return (Criteria) this;
        }

        public Criteria andProdIdIsNotNull() {
            addCriterion("prod_id is not null");
            return (Criteria) this;
        }

        public Criteria andProdIdEqualTo(Integer value) {
            addCriterion("prod_id =", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotEqualTo(Integer value) {
            addCriterion("prod_id <>", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdGreaterThan(Integer value) {
            addCriterion("prod_id >", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("prod_id >=", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLessThan(Integer value) {
            addCriterion("prod_id <", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLessThanOrEqualTo(Integer value) {
            addCriterion("prod_id <=", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdIn(List<Integer> values) {
            addCriterion("prod_id in", values, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotIn(List<Integer> values) {
            addCriterion("prod_id not in", values, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdBetween(Integer value1, Integer value2) {
            addCriterion("prod_id between", value1, value2, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotBetween(Integer value1, Integer value2) {
            addCriterion("prod_id not between", value1, value2, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdSnIsNull() {
            addCriterion("prod_sn is null");
            return (Criteria) this;
        }

        public Criteria andProdSnIsNotNull() {
            addCriterion("prod_sn is not null");
            return (Criteria) this;
        }

        public Criteria andProdSnEqualTo(String value) {
            addCriterion("prod_sn =", value, "prodSn");
            return (Criteria) this;
        }

        public Criteria andProdSnNotEqualTo(String value) {
            addCriterion("prod_sn <>", value, "prodSn");
            return (Criteria) this;
        }

        public Criteria andProdSnGreaterThan(String value) {
            addCriterion("prod_sn >", value, "prodSn");
            return (Criteria) this;
        }

        public Criteria andProdSnGreaterThanOrEqualTo(String value) {
            addCriterion("prod_sn >=", value, "prodSn");
            return (Criteria) this;
        }

        public Criteria andProdSnLessThan(String value) {
            addCriterion("prod_sn <", value, "prodSn");
            return (Criteria) this;
        }

        public Criteria andProdSnLessThanOrEqualTo(String value) {
            addCriterion("prod_sn <=", value, "prodSn");
            return (Criteria) this;
        }

        public Criteria andProdSnLike(String value) {
            addCriterion("prod_sn like", value, "prodSn");
            return (Criteria) this;
        }

        public Criteria andProdSnNotLike(String value) {
            addCriterion("prod_sn not like", value, "prodSn");
            return (Criteria) this;
        }

        public Criteria andProdSnIn(List<String> values) {
            addCriterion("prod_sn in", values, "prodSn");
            return (Criteria) this;
        }

        public Criteria andProdSnNotIn(List<String> values) {
            addCriterion("prod_sn not in", values, "prodSn");
            return (Criteria) this;
        }

        public Criteria andProdSnBetween(String value1, String value2) {
            addCriterion("prod_sn between", value1, value2, "prodSn");
            return (Criteria) this;
        }

        public Criteria andProdSnNotBetween(String value1, String value2) {
            addCriterion("prod_sn not between", value1, value2, "prodSn");
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

        public Criteria andFaceAmoutIsNull() {
            addCriterion("face_amout is null");
            return (Criteria) this;
        }

        public Criteria andFaceAmoutIsNotNull() {
            addCriterion("face_amout is not null");
            return (Criteria) this;
        }

        public Criteria andFaceAmoutEqualTo(Integer value) {
            addCriterion("face_amout =", value, "faceAmout");
            return (Criteria) this;
        }

        public Criteria andFaceAmoutNotEqualTo(Integer value) {
            addCriterion("face_amout <>", value, "faceAmout");
            return (Criteria) this;
        }

        public Criteria andFaceAmoutGreaterThan(Integer value) {
            addCriterion("face_amout >", value, "faceAmout");
            return (Criteria) this;
        }

        public Criteria andFaceAmoutGreaterThanOrEqualTo(Integer value) {
            addCriterion("face_amout >=", value, "faceAmout");
            return (Criteria) this;
        }

        public Criteria andFaceAmoutLessThan(Integer value) {
            addCriterion("face_amout <", value, "faceAmout");
            return (Criteria) this;
        }

        public Criteria andFaceAmoutLessThanOrEqualTo(Integer value) {
            addCriterion("face_amout <=", value, "faceAmout");
            return (Criteria) this;
        }

        public Criteria andFaceAmoutIn(List<Integer> values) {
            addCriterion("face_amout in", values, "faceAmout");
            return (Criteria) this;
        }

        public Criteria andFaceAmoutNotIn(List<Integer> values) {
            addCriterion("face_amout not in", values, "faceAmout");
            return (Criteria) this;
        }

        public Criteria andFaceAmoutBetween(Integer value1, Integer value2) {
            addCriterion("face_amout between", value1, value2, "faceAmout");
            return (Criteria) this;
        }

        public Criteria andFaceAmoutNotBetween(Integer value1, Integer value2) {
            addCriterion("face_amout not between", value1, value2, "faceAmout");
            return (Criteria) this;
        }

        public Criteria andFaceUnitIsNull() {
            addCriterion("face_unit is null");
            return (Criteria) this;
        }

        public Criteria andFaceUnitIsNotNull() {
            addCriterion("face_unit is not null");
            return (Criteria) this;
        }

        public Criteria andFaceUnitEqualTo(String value) {
            addCriterion("face_unit =", value, "faceUnit");
            return (Criteria) this;
        }

        public Criteria andFaceUnitNotEqualTo(String value) {
            addCriterion("face_unit <>", value, "faceUnit");
            return (Criteria) this;
        }

        public Criteria andFaceUnitGreaterThan(String value) {
            addCriterion("face_unit >", value, "faceUnit");
            return (Criteria) this;
        }

        public Criteria andFaceUnitGreaterThanOrEqualTo(String value) {
            addCriterion("face_unit >=", value, "faceUnit");
            return (Criteria) this;
        }

        public Criteria andFaceUnitLessThan(String value) {
            addCriterion("face_unit <", value, "faceUnit");
            return (Criteria) this;
        }

        public Criteria andFaceUnitLessThanOrEqualTo(String value) {
            addCriterion("face_unit <=", value, "faceUnit");
            return (Criteria) this;
        }

        public Criteria andFaceUnitLike(String value) {
            addCriterion("face_unit like", value, "faceUnit");
            return (Criteria) this;
        }

        public Criteria andFaceUnitNotLike(String value) {
            addCriterion("face_unit not like", value, "faceUnit");
            return (Criteria) this;
        }

        public Criteria andFaceUnitIn(List<String> values) {
            addCriterion("face_unit in", values, "faceUnit");
            return (Criteria) this;
        }

        public Criteria andFaceUnitNotIn(List<String> values) {
            addCriterion("face_unit not in", values, "faceUnit");
            return (Criteria) this;
        }

        public Criteria andFaceUnitBetween(String value1, String value2) {
            addCriterion("face_unit between", value1, value2, "faceUnit");
            return (Criteria) this;
        }

        public Criteria andFaceUnitNotBetween(String value1, String value2) {
            addCriterion("face_unit not between", value1, value2, "faceUnit");
            return (Criteria) this;
        }

        public Criteria andBuyTypeIsNull() {
            addCriterion("buy_type is null");
            return (Criteria) this;
        }

        public Criteria andBuyTypeIsNotNull() {
            addCriterion("buy_type is not null");
            return (Criteria) this;
        }

        public Criteria andBuyTypeEqualTo(String value) {
            addCriterion("buy_type =", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeNotEqualTo(String value) {
            addCriterion("buy_type <>", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeGreaterThan(String value) {
            addCriterion("buy_type >", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("buy_type >=", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeLessThan(String value) {
            addCriterion("buy_type <", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeLessThanOrEqualTo(String value) {
            addCriterion("buy_type <=", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeLike(String value) {
            addCriterion("buy_type like", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeNotLike(String value) {
            addCriterion("buy_type not like", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeIn(List<String> values) {
            addCriterion("buy_type in", values, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeNotIn(List<String> values) {
            addCriterion("buy_type not in", values, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeBetween(String value1, String value2) {
            addCriterion("buy_type between", value1, value2, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeNotBetween(String value1, String value2) {
            addCriterion("buy_type not between", value1, value2, "buyType");
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