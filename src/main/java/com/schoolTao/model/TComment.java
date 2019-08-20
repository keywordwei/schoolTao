package com.schoolTao.model;

public class TComment {
    private Integer commentId;

    private Integer productId;

    private Integer userId;

    private Integer commentTime;

    private String commentContent;

    private String commentName;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Integer commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public String getCommentName() {
        return commentName;
    }

    public void setCommentName(String commentName) {
        this.commentName = commentName == null ? null : commentName.trim();
    }

    @Override
    public String toString() {
        return "TComment{" +
                "commentId=" + commentId +
                ", productId=" + productId +
                ", userId=" + userId +
                ", commentTime=" + commentTime +
                ", commentContent='" + commentContent + '\'' +
                ", commentName='" + commentName + '\'' +
                '}';
    }
}