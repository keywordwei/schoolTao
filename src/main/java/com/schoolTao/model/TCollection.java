package com.schoolTao.model;

public class TCollection {
    private Integer collectionId;

    private Integer collectionGoodsId;

    private Integer collectionUserId;

    private Integer collectionStatus;

    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public Integer getCollectionGoodsId() {
        return collectionGoodsId;
    }

    public void setCollectionGoodsId(Integer collectionGoodsId) {
        this.collectionGoodsId = collectionGoodsId;
    }

    public Integer getCollectionUserId() {
        return collectionUserId;
    }

    public void setCollectionUserId(Integer collectionUserId) {
        this.collectionUserId = collectionUserId;
    }

    public Integer getCollectionStatus() {
        return collectionStatus;
    }

    public void setCollectionStatus(Integer collectionStatus) {
        this.collectionStatus = collectionStatus;
    }

    @Override
    public String toString() {
        return "TCollection{" +
                "collectionId=" + collectionId +
                ", collectionGoodsId=" + collectionGoodsId +
                ", collectionUserId=" + collectionUserId +
                ", collectionStatus=" + collectionStatus +
                '}';
    }
}