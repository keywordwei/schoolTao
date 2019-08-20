package com.schoolTao.model;

import java.util.ArrayList;
import java.util.List;

public class TCollectionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCollectionExample() {
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

        public Criteria andCollectionIdIsNull() {
            addCriterion("collection_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectionIdIsNotNull() {
            addCriterion("collection_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionIdEqualTo(Integer value) {
            addCriterion("collection_id =", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdNotEqualTo(Integer value) {
            addCriterion("collection_id <>", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdGreaterThan(Integer value) {
            addCriterion("collection_id >", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("collection_id >=", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdLessThan(Integer value) {
            addCriterion("collection_id <", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdLessThanOrEqualTo(Integer value) {
            addCriterion("collection_id <=", value, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdIn(List<Integer> values) {
            addCriterion("collection_id in", values, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdNotIn(List<Integer> values) {
            addCriterion("collection_id not in", values, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdBetween(Integer value1, Integer value2) {
            addCriterion("collection_id between", value1, value2, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("collection_id not between", value1, value2, "collectionId");
            return (Criteria) this;
        }

        public Criteria andCollectionGoodsIdIsNull() {
            addCriterion("collection_goods_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectionGoodsIdIsNotNull() {
            addCriterion("collection_goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionGoodsIdEqualTo(Integer value) {
            addCriterion("collection_goods_id =", value, "collectionGoodsId");
            return (Criteria) this;
        }

        public Criteria andCollectionGoodsIdNotEqualTo(Integer value) {
            addCriterion("collection_goods_id <>", value, "collectionGoodsId");
            return (Criteria) this;
        }

        public Criteria andCollectionGoodsIdGreaterThan(Integer value) {
            addCriterion("collection_goods_id >", value, "collectionGoodsId");
            return (Criteria) this;
        }

        public Criteria andCollectionGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("collection_goods_id >=", value, "collectionGoodsId");
            return (Criteria) this;
        }

        public Criteria andCollectionGoodsIdLessThan(Integer value) {
            addCriterion("collection_goods_id <", value, "collectionGoodsId");
            return (Criteria) this;
        }

        public Criteria andCollectionGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("collection_goods_id <=", value, "collectionGoodsId");
            return (Criteria) this;
        }

        public Criteria andCollectionGoodsIdIn(List<Integer> values) {
            addCriterion("collection_goods_id in", values, "collectionGoodsId");
            return (Criteria) this;
        }

        public Criteria andCollectionGoodsIdNotIn(List<Integer> values) {
            addCriterion("collection_goods_id not in", values, "collectionGoodsId");
            return (Criteria) this;
        }

        public Criteria andCollectionGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("collection_goods_id between", value1, value2, "collectionGoodsId");
            return (Criteria) this;
        }

        public Criteria andCollectionGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("collection_goods_id not between", value1, value2, "collectionGoodsId");
            return (Criteria) this;
        }

        public Criteria andCollectionUserIdIsNull() {
            addCriterion("collection_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectionUserIdIsNotNull() {
            addCriterion("collection_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionUserIdEqualTo(Integer value) {
            addCriterion("collection_user_id =", value, "collectionUserId");
            return (Criteria) this;
        }

        public Criteria andCollectionUserIdNotEqualTo(Integer value) {
            addCriterion("collection_user_id <>", value, "collectionUserId");
            return (Criteria) this;
        }

        public Criteria andCollectionUserIdGreaterThan(Integer value) {
            addCriterion("collection_user_id >", value, "collectionUserId");
            return (Criteria) this;
        }

        public Criteria andCollectionUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("collection_user_id >=", value, "collectionUserId");
            return (Criteria) this;
        }

        public Criteria andCollectionUserIdLessThan(Integer value) {
            addCriterion("collection_user_id <", value, "collectionUserId");
            return (Criteria) this;
        }

        public Criteria andCollectionUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("collection_user_id <=", value, "collectionUserId");
            return (Criteria) this;
        }

        public Criteria andCollectionUserIdIn(List<Integer> values) {
            addCriterion("collection_user_id in", values, "collectionUserId");
            return (Criteria) this;
        }

        public Criteria andCollectionUserIdNotIn(List<Integer> values) {
            addCriterion("collection_user_id not in", values, "collectionUserId");
            return (Criteria) this;
        }

        public Criteria andCollectionUserIdBetween(Integer value1, Integer value2) {
            addCriterion("collection_user_id between", value1, value2, "collectionUserId");
            return (Criteria) this;
        }

        public Criteria andCollectionUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("collection_user_id not between", value1, value2, "collectionUserId");
            return (Criteria) this;
        }

        public Criteria andCollectionStatusIsNull() {
            addCriterion("collection_status is null");
            return (Criteria) this;
        }

        public Criteria andCollectionStatusIsNotNull() {
            addCriterion("collection_status is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionStatusEqualTo(Integer value) {
            addCriterion("collection_status =", value, "collectionStatus");
            return (Criteria) this;
        }

        public Criteria andCollectionStatusNotEqualTo(Integer value) {
            addCriterion("collection_status <>", value, "collectionStatus");
            return (Criteria) this;
        }

        public Criteria andCollectionStatusGreaterThan(Integer value) {
            addCriterion("collection_status >", value, "collectionStatus");
            return (Criteria) this;
        }

        public Criteria andCollectionStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("collection_status >=", value, "collectionStatus");
            return (Criteria) this;
        }

        public Criteria andCollectionStatusLessThan(Integer value) {
            addCriterion("collection_status <", value, "collectionStatus");
            return (Criteria) this;
        }

        public Criteria andCollectionStatusLessThanOrEqualTo(Integer value) {
            addCriterion("collection_status <=", value, "collectionStatus");
            return (Criteria) this;
        }

        public Criteria andCollectionStatusIn(List<Integer> values) {
            addCriterion("collection_status in", values, "collectionStatus");
            return (Criteria) this;
        }

        public Criteria andCollectionStatusNotIn(List<Integer> values) {
            addCriterion("collection_status not in", values, "collectionStatus");
            return (Criteria) this;
        }

        public Criteria andCollectionStatusBetween(Integer value1, Integer value2) {
            addCriterion("collection_status between", value1, value2, "collectionStatus");
            return (Criteria) this;
        }

        public Criteria andCollectionStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("collection_status not between", value1, value2, "collectionStatus");
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