package com.schoolTao.model;

public class TStu {
    private Integer stuId;

    private String stuIdentity;

    private String stuName;

    private String stuSchool;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuIdentity() {
        return stuIdentity;
    }

    public void setStuIdentity(String stuIdentity) {
        this.stuIdentity = stuIdentity == null ? null : stuIdentity.trim();
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public String getStuSchool() {
        return stuSchool;
    }

    public void setStuSchool(String stuSchool) {
        this.stuSchool = stuSchool == null ? null : stuSchool.trim();
    }

    @Override
    public String toString() {
        return "TStu{" +
                "stuId=" + stuId +
                ", stuIdentity='" + stuIdentity + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuSchool='" + stuSchool + '\'' +
                '}';
    }
}