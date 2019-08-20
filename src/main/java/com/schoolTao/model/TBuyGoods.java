package com.schoolTao.model;

public class TBuyGoods {
    private Integer productId;

    private String productImg;

    private String productTitle;

    private String productDetails;

    private Double productPrice;

    private String productContactPhone;

    private Integer productCategoryId;

    private String productContactQq;

    private Integer productPublishTime;

    private Integer productStatus;

    private Integer productByUserId;

    private Integer productHot;

    private String productCategoryName;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg == null ? null : productImg.trim();
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle == null ? null : productTitle.trim();
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails == null ? null : productDetails.trim();
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductContactPhone() {
        return productContactPhone;
    }

    public void setProductContactPhone(String productContactPhone) {
        this.productContactPhone = productContactPhone == null ? null : productContactPhone.trim();
    }

    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getProductContactQq() {
        return productContactQq;
    }

    public void setProductContactQq(String productContactQq) {
        this.productContactQq = productContactQq == null ? null : productContactQq.trim();
    }

    public Integer getProductPublishTime() {
        return productPublishTime;
    }

    public void setProductPublishTime(Integer productPublishTime) {
        this.productPublishTime = productPublishTime;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public Integer getProductByUserId() {
        return productByUserId;
    }

    public void setProductByUserId(Integer productByUserId) {
        this.productByUserId = productByUserId;
    }

    public Integer getProductHot() {
        return productHot;
    }

    public void setProductHot(Integer productHot) {
        this.productHot = productHot;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName == null ? null : productCategoryName.trim();
    }

    @Override
    public String toString() {
        return "TBuyGoods{" +
                "productId=" + productId +
                ", productImg='" + productImg + '\'' +
                ", productTitle='" + productTitle + '\'' +
                ", productDetails='" + productDetails + '\'' +
                ", productPrice=" + productPrice +
                ", productContactPhone='" + productContactPhone + '\'' +
                ", productCategoryId=" + productCategoryId +
                ", productContactQq='" + productContactQq + '\'' +
                ", productPublishTime=" + productPublishTime +
                ", productStatus=" + productStatus +
                ", productByUserId=" + productByUserId +
                ", productHot=" + productHot +
                ", productCategoryName='" + productCategoryName + '\'' +
                '}';
    }
}