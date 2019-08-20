package com.schoolTao.model;

public class TReply {
    private Integer replyId;

    private Integer userId;

    private String userName;

    private Integer replyuserId;

    private String replyuserName;

    private String replyContent;

    private Integer replyTime;

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getReplyuserId() {
        return replyuserId;
    }

    public void setReplyuserId(Integer replyuserId) {
        this.replyuserId = replyuserId;
    }

    public String getReplyuserName() {
        return replyuserName;
    }

    public void setReplyuserName(String replyuserName) {
        this.replyuserName = replyuserName == null ? null : replyuserName.trim();
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }

    public Integer getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Integer replyTime) {
        this.replyTime = replyTime;
    }

    @Override
    public String toString() {
        return "TReply{" +
                "replyId=" + replyId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", replyuserId=" + replyuserId +
                ", replyuserName='" + replyuserName + '\'' +
                ", replyContent='" + replyContent + '\'' +
                ", replyTime=" + replyTime +
                '}';
    }
}