package com.schoolTao.model;

public class TSaleGoods {
    private Integer goodsId;

    private String goodsImg;

    private String goodsTitle;

    private String goodsDetails;

    private Double goodsPrice;

    private String goodsContactPhone;

    private Integer goodsCategoryId;

    private String goodsContactQq;

    private Integer goodsPublishTime;

    private Integer goodsByUserId;

    private Integer goodsHot;

    private String goodsCategoryName;

    private Integer goodsStatus;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg == null ? null : goodsImg.trim();
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle == null ? null : goodsTitle.trim();
    }

    public String getGoodsDetails() {
        return goodsDetails;
    }

    public void setGoodsDetails(String goodsDetails) {
        this.goodsDetails = goodsDetails == null ? null : goodsDetails.trim();
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsContactPhone() {
        return goodsContactPhone;
    }

    public void setGoodsContactPhone(String goodsContactPhone) {
        this.goodsContactPhone = goodsContactPhone == null ? null : goodsContactPhone.trim();
    }

    public Integer getGoodsCategoryId() {
        return goodsCategoryId;
    }

    public void setGoodsCategoryId(Integer goodsCategoryId) {
        this.goodsCategoryId = goodsCategoryId;
    }

    public String getGoodsContactQq() {
        return goodsContactQq;
    }

    public void setGoodsContactQq(String goodsContactQq) {
        this.goodsContactQq = goodsContactQq == null ? null : goodsContactQq.trim();
    }

    public Integer getGoodsPublishTime() {
        return goodsPublishTime;
    }

    public void setGoodsPublishTime(Integer goodsPublishTime) {
        this.goodsPublishTime = goodsPublishTime;
    }

    public Integer getGoodsByUserId() {
        return goodsByUserId;
    }

    public void setGoodsByUserId(Integer goodsByUserId) {
        this.goodsByUserId = goodsByUserId;
    }

    public Integer getGoodsHot() {
        return goodsHot;
    }

    public void setGoodsHot(Integer goodsHot) {
        this.goodsHot = goodsHot;
    }

    public String getGoodsCategoryName() {
        return goodsCategoryName;
    }

    public void setGoodsCategoryName(String goodsCategoryName) {
        this.goodsCategoryName = goodsCategoryName == null ? null : goodsCategoryName.trim();
    }

    public Integer getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Integer goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    @Override
    public String toString() {
        return "TSaleGoods{" +
                "goodsId=" + goodsId +
                ", goodsImg='" + goodsImg + '\'' +
                ", goodsTitle='" + goodsTitle + '\'' +
                ", goodsDetails='" + goodsDetails + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsContactPhone='" + goodsContactPhone + '\'' +
                ", goodsCategoryId=" + goodsCategoryId +
                ", goodsContactQq='" + goodsContactQq + '\'' +
                ", goodsPublishTime=" + goodsPublishTime +
                ", goodsByUserId=" + goodsByUserId +
                ", goodsHot=" + goodsHot +
                ", goodsCategoryName='" + goodsCategoryName + '\'' +
                ", goodsStatus=" + goodsStatus +
                '}';
    }
}