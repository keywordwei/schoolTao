package com.schoolTao.model;

import java.util.ArrayList;
import java.util.List;

public class TSaleGoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TSaleGoodsExample() {
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

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Integer value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Integer value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Integer value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Integer value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Integer> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Integer> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIsNull() {
            addCriterion("goods_img is null");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIsNotNull() {
            addCriterion("goods_img is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsImgEqualTo(String value) {
            addCriterion("goods_img =", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgNotEqualTo(String value) {
            addCriterion("goods_img <>", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgGreaterThan(String value) {
            addCriterion("goods_img >", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgGreaterThanOrEqualTo(String value) {
            addCriterion("goods_img >=", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgLessThan(String value) {
            addCriterion("goods_img <", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgLessThanOrEqualTo(String value) {
            addCriterion("goods_img <=", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgLike(String value) {
            addCriterion("goods_img like", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgNotLike(String value) {
            addCriterion("goods_img not like", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIn(List<String> values) {
            addCriterion("goods_img in", values, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgNotIn(List<String> values) {
            addCriterion("goods_img not in", values, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgBetween(String value1, String value2) {
            addCriterion("goods_img between", value1, value2, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgNotBetween(String value1, String value2) {
            addCriterion("goods_img not between", value1, value2, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleIsNull() {
            addCriterion("goods_title is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleIsNotNull() {
            addCriterion("goods_title is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleEqualTo(String value) {
            addCriterion("goods_title =", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleNotEqualTo(String value) {
            addCriterion("goods_title <>", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleGreaterThan(String value) {
            addCriterion("goods_title >", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleGreaterThanOrEqualTo(String value) {
            addCriterion("goods_title >=", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleLessThan(String value) {
            addCriterion("goods_title <", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleLessThanOrEqualTo(String value) {
            addCriterion("goods_title <=", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleLike(String value) {
            addCriterion("goods_title like", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleNotLike(String value) {
            addCriterion("goods_title not like", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleIn(List<String> values) {
            addCriterion("goods_title in", values, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleNotIn(List<String> values) {
            addCriterion("goods_title not in", values, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleBetween(String value1, String value2) {
            addCriterion("goods_title between", value1, value2, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleNotBetween(String value1, String value2) {
            addCriterion("goods_title not between", value1, value2, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailsIsNull() {
            addCriterion("goods_details is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailsIsNotNull() {
            addCriterion("goods_details is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailsEqualTo(String value) {
            addCriterion("goods_details =", value, "goodsDetails");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailsNotEqualTo(String value) {
            addCriterion("goods_details <>", value, "goodsDetails");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailsGreaterThan(String value) {
            addCriterion("goods_details >", value, "goodsDetails");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailsGreaterThanOrEqualTo(String value) {
            addCriterion("goods_details >=", value, "goodsDetails");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailsLessThan(String value) {
            addCriterion("goods_details <", value, "goodsDetails");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailsLessThanOrEqualTo(String value) {
            addCriterion("goods_details <=", value, "goodsDetails");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailsLike(String value) {
            addCriterion("goods_details like", value, "goodsDetails");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailsNotLike(String value) {
            addCriterion("goods_details not like", value, "goodsDetails");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailsIn(List<String> values) {
            addCriterion("goods_details in", values, "goodsDetails");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailsNotIn(List<String> values) {
            addCriterion("goods_details not in", values, "goodsDetails");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailsBetween(String value1, String value2) {
            addCriterion("goods_details between", value1, value2, "goodsDetails");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailsNotBetween(String value1, String value2) {
            addCriterion("goods_details not between", value1, value2, "goodsDetails");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNull() {
            addCriterion("goods_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNotNull() {
            addCriterion("goods_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceEqualTo(Double value) {
            addCriterion("goods_price =", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotEqualTo(Double value) {
            addCriterion("goods_price <>", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThan(Double value) {
            addCriterion("goods_price >", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("goods_price >=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThan(Double value) {
            addCriterion("goods_price <", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThanOrEqualTo(Double value) {
            addCriterion("goods_price <=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIn(List<Double> values) {
            addCriterion("goods_price in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotIn(List<Double> values) {
            addCriterion("goods_price not in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceBetween(Double value1, Double value2) {
            addCriterion("goods_price between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotBetween(Double value1, Double value2) {
            addCriterion("goods_price not between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsContactPhoneIsNull() {
            addCriterion("goods_contact_phone is null");
            return (Criteria) this;
        }

        public Criteria andGoodsContactPhoneIsNotNull() {
            addCriterion("goods_contact_phone is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsContactPhoneEqualTo(String value) {
            addCriterion("goods_contact_phone =", value, "goodsContactPhone");
            return (Criteria) this;
        }

        public Criteria andGoodsContactPhoneNotEqualTo(String value) {
            addCriterion("goods_contact_phone <>", value, "goodsContactPhone");
            return (Criteria) this;
        }

        public Criteria andGoodsContactPhoneGreaterThan(String value) {
            addCriterion("goods_contact_phone >", value, "goodsContactPhone");
            return (Criteria) this;
        }

        public Criteria andGoodsContactPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("goods_contact_phone >=", value, "goodsContactPhone");
            return (Criteria) this;
        }

        public Criteria andGoodsContactPhoneLessThan(String value) {
            addCriterion("goods_contact_phone <", value, "goodsContactPhone");
            return (Criteria) this;
        }

        public Criteria andGoodsContactPhoneLessThanOrEqualTo(String value) {
            addCriterion("goods_contact_phone <=", value, "goodsContactPhone");
            return (Criteria) this;
        }

        public Criteria andGoodsContactPhoneLike(String value) {
            addCriterion("goods_contact_phone like", value, "goodsContactPhone");
            return (Criteria) this;
        }

        public Criteria andGoodsContactPhoneNotLike(String value) {
            addCriterion("goods_contact_phone not like", value, "goodsContactPhone");
            return (Criteria) this;
        }

        public Criteria andGoodsContactPhoneIn(List<String> values) {
            addCriterion("goods_contact_phone in", values, "goodsContactPhone");
            return (Criteria) this;
        }

        public Criteria andGoodsContactPhoneNotIn(List<String> values) {
            addCriterion("goods_contact_phone not in", values, "goodsContactPhone");
            return (Criteria) this;
        }

        public Criteria andGoodsContactPhoneBetween(String value1, String value2) {
            addCriterion("goods_contact_phone between", value1, value2, "goodsContactPhone");
            return (Criteria) this;
        }

        public Criteria andGoodsContactPhoneNotBetween(String value1, String value2) {
            addCriterion("goods_contact_phone not between", value1, value2, "goodsContactPhone");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryIdIsNull() {
            addCriterion("goods_category_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryIdIsNotNull() {
            addCriterion("goods_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryIdEqualTo(Integer value) {
            addCriterion("goods_category_id =", value, "goodsCategoryId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryIdNotEqualTo(Integer value) {
            addCriterion("goods_category_id <>", value, "goodsCategoryId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryIdGreaterThan(Integer value) {
            addCriterion("goods_category_id >", value, "goodsCategoryId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_category_id >=", value, "goodsCategoryId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryIdLessThan(Integer value) {
            addCriterion("goods_category_id <", value, "goodsCategoryId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("goods_category_id <=", value, "goodsCategoryId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryIdIn(List<Integer> values) {
            addCriterion("goods_category_id in", values, "goodsCategoryId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryIdNotIn(List<Integer> values) {
            addCriterion("goods_category_id not in", values, "goodsCategoryId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("goods_category_id between", value1, value2, "goodsCategoryId");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_category_id not between", value1, value2, "goodsCategoryId");
            return (Criteria) this;
        }

        public Criteria andGoodsContactQqIsNull() {
            addCriterion("goods_contact_qq is null");
            return (Criteria) this;
        }

        public Criteria andGoodsContactQqIsNotNull() {
            addCriterion("goods_contact_qq is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsContactQqEqualTo(String value) {
            addCriterion("goods_contact_qq =", value, "goodsContactQq");
            return (Criteria) this;
        }

        public Criteria andGoodsContactQqNotEqualTo(String value) {
            addCriterion("goods_contact_qq <>", value, "goodsContactQq");
            return (Criteria) this;
        }

        public Criteria andGoodsContactQqGreaterThan(String value) {
            addCriterion("goods_contact_qq >", value, "goodsContactQq");
            return (Criteria) this;
        }

        public Criteria andGoodsContactQqGreaterThanOrEqualTo(String value) {
            addCriterion("goods_contact_qq >=", value, "goodsContactQq");
            return (Criteria) this;
        }

        public Criteria andGoodsContactQqLessThan(String value) {
            addCriterion("goods_contact_qq <", value, "goodsContactQq");
            return (Criteria) this;
        }

        public Criteria andGoodsContactQqLessThanOrEqualTo(String value) {
            addCriterion("goods_contact_qq <=", value, "goodsContactQq");
            return (Criteria) this;
        }

        public Criteria andGoodsContactQqLike(String value) {
            addCriterion("goods_contact_qq like", value, "goodsContactQq");
            return (Criteria) this;
        }

        public Criteria andGoodsContactQqNotLike(String value) {
            addCriterion("goods_contact_qq not like", value, "goodsContactQq");
            return (Criteria) this;
        }

        public Criteria andGoodsContactQqIn(List<String> values) {
            addCriterion("goods_contact_qq in", values, "goodsContactQq");
            return (Criteria) this;
        }

        public Criteria andGoodsContactQqNotIn(List<String> values) {
            addCriterion("goods_contact_qq not in", values, "goodsContactQq");
            return (Criteria) this;
        }

        public Criteria andGoodsContactQqBetween(String value1, String value2) {
            addCriterion("goods_contact_qq between", value1, value2, "goodsContactQq");
            return (Criteria) this;
        }

        public Criteria andGoodsContactQqNotBetween(String value1, String value2) {
            addCriterion("goods_contact_qq not between", value1, value2, "goodsContactQq");
            return (Criteria) this;
        }

        public Criteria andGoodsPublishTimeIsNull() {
            addCriterion("goods_publish_time is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPublishTimeIsNotNull() {
            addCriterion("goods_publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPublishTimeEqualTo(Integer value) {
            addCriterion("goods_publish_time =", value, "goodsPublishTime");
            return (Criteria) this;
        }

        public Criteria andGoodsPublishTimeNotEqualTo(Integer value) {
            addCriterion("goods_publish_time <>", value, "goodsPublishTime");
            return (Criteria) this;
        }

        public Criteria andGoodsPublishTimeGreaterThan(Integer value) {
            addCriterion("goods_publish_time >", value, "goodsPublishTime");
            return (Criteria) this;
        }

        public Criteria andGoodsPublishTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_publish_time >=", value, "goodsPublishTime");
            return (Criteria) this;
        }

        public Criteria andGoodsPublishTimeLessThan(Integer value) {
            addCriterion("goods_publish_time <", value, "goodsPublishTime");
            return (Criteria) this;
        }

        public Criteria andGoodsPublishTimeLessThanOrEqualTo(Integer value) {
            addCriterion("goods_publish_time <=", value, "goodsPublishTime");
            return (Criteria) this;
        }

        public Criteria andGoodsPublishTimeIn(List<Integer> values) {
            addCriterion("goods_publish_time in", values, "goodsPublishTime");
            return (Criteria) this;
        }

        public Criteria andGoodsPublishTimeNotIn(List<Integer> values) {
            addCriterion("goods_publish_time not in", values, "goodsPublishTime");
            return (Criteria) this;
        }

        public Criteria andGoodsPublishTimeBetween(Integer value1, Integer value2) {
            addCriterion("goods_publish_time between", value1, value2, "goodsPublishTime");
            return (Criteria) this;
        }

        public Criteria andGoodsPublishTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_publish_time not between", value1, value2, "goodsPublishTime");
            return (Criteria) this;
        }

        public Criteria andGoodsByUserIdIsNull() {
            addCriterion("goods_by_user_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsByUserIdIsNotNull() {
            addCriterion("goods_by_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsByUserIdEqualTo(Integer value) {
            addCriterion("goods_by_user_id =", value, "goodsByUserId");
            return (Criteria) this;
        }

        public Criteria andGoodsByUserIdNotEqualTo(Integer value) {
            addCriterion("goods_by_user_id <>", value, "goodsByUserId");
            return (Criteria) this;
        }

        public Criteria andGoodsByUserIdGreaterThan(Integer value) {
            addCriterion("goods_by_user_id >", value, "goodsByUserId");
            return (Criteria) this;
        }

        public Criteria andGoodsByUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_by_user_id >=", value, "goodsByUserId");
            return (Criteria) this;
        }

        public Criteria andGoodsByUserIdLessThan(Integer value) {
            addCriterion("goods_by_user_id <", value, "goodsByUserId");
            return (Criteria) this;
        }

        public Criteria andGoodsByUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("goods_by_user_id <=", value, "goodsByUserId");
            return (Criteria) this;
        }

        public Criteria andGoodsByUserIdIn(List<Integer> values) {
            addCriterion("goods_by_user_id in", values, "goodsByUserId");
            return (Criteria) this;
        }

        public Criteria andGoodsByUserIdNotIn(List<Integer> values) {
            addCriterion("goods_by_user_id not in", values, "goodsByUserId");
            return (Criteria) this;
        }

        public Criteria andGoodsByUserIdBetween(Integer value1, Integer value2) {
            addCriterion("goods_by_user_id between", value1, value2, "goodsByUserId");
            return (Criteria) this;
        }

        public Criteria andGoodsByUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_by_user_id not between", value1, value2, "goodsByUserId");
            return (Criteria) this;
        }

        public Criteria andGoodsHotIsNull() {
            addCriterion("goods_hot is null");
            return (Criteria) this;
        }

        public Criteria andGoodsHotIsNotNull() {
            addCriterion("goods_hot is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsHotEqualTo(Integer value) {
            addCriterion("goods_hot =", value, "goodsHot");
            return (Criteria) this;
        }

        public Criteria andGoodsHotNotEqualTo(Integer value) {
            addCriterion("goods_hot <>", value, "goodsHot");
            return (Criteria) this;
        }

        public Criteria andGoodsHotGreaterThan(Integer value) {
            addCriterion("goods_hot >", value, "goodsHot");
            return (Criteria) this;
        }

        public Criteria andGoodsHotGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_hot >=", value, "goodsHot");
            return (Criteria) this;
        }

        public Criteria andGoodsHotLessThan(Integer value) {
            addCriterion("goods_hot <", value, "goodsHot");
            return (Criteria) this;
        }

        public Criteria andGoodsHotLessThanOrEqualTo(Integer value) {
            addCriterion("goods_hot <=", value, "goodsHot");
            return (Criteria) this;
        }

        public Criteria andGoodsHotIn(List<Integer> values) {
            addCriterion("goods_hot in", values, "goodsHot");
            return (Criteria) this;
        }

        public Criteria andGoodsHotNotIn(List<Integer> values) {
            addCriterion("goods_hot not in", values, "goodsHot");
            return (Criteria) this;
        }

        public Criteria andGoodsHotBetween(Integer value1, Integer value2) {
            addCriterion("goods_hot between", value1, value2, "goodsHot");
            return (Criteria) this;
        }

        public Criteria andGoodsHotNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_hot not between", value1, value2, "goodsHot");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNameIsNull() {
            addCriterion("goods_category_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNameIsNotNull() {
            addCriterion("goods_category_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNameEqualTo(String value) {
            addCriterion("goods_category_name =", value, "goodsCategoryName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNameNotEqualTo(String value) {
            addCriterion("goods_category_name <>", value, "goodsCategoryName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNameGreaterThan(String value) {
            addCriterion("goods_category_name >", value, "goodsCategoryName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_category_name >=", value, "goodsCategoryName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNameLessThan(String value) {
            addCriterion("goods_category_name <", value, "goodsCategoryName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("goods_category_name <=", value, "goodsCategoryName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNameLike(String value) {
            addCriterion("goods_category_name like", value, "goodsCategoryName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNameNotLike(String value) {
            addCriterion("goods_category_name not like", value, "goodsCategoryName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNameIn(List<String> values) {
            addCriterion("goods_category_name in", values, "goodsCategoryName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNameNotIn(List<String> values) {
            addCriterion("goods_category_name not in", values, "goodsCategoryName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNameBetween(String value1, String value2) {
            addCriterion("goods_category_name between", value1, value2, "goodsCategoryName");
            return (Criteria) this;
        }

        public Criteria andGoodsCategoryNameNotBetween(String value1, String value2) {
            addCriterion("goods_category_name not between", value1, value2, "goodsCategoryName");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusIsNull() {
            addCriterion("goods_status is null");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusIsNotNull() {
            addCriterion("goods_status is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusEqualTo(Integer value) {
            addCriterion("goods_status =", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusNotEqualTo(Integer value) {
            addCriterion("goods_status <>", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusGreaterThan(Integer value) {
            addCriterion("goods_status >", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_status >=", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusLessThan(Integer value) {
            addCriterion("goods_status <", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusLessThanOrEqualTo(Integer value) {
            addCriterion("goods_status <=", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusIn(List<Integer> values) {
            addCriterion("goods_status in", values, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusNotIn(List<Integer> values) {
            addCriterion("goods_status not in", values, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusBetween(Integer value1, Integer value2) {
            addCriterion("goods_status between", value1, value2, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_status not between", value1, value2, "goodsStatus");
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