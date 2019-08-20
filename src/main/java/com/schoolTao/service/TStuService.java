package com.schoolTao.service;

import com.schoolTao.model.TStu;

import java.util.List;

public interface TStuService {

    /****
     * 到数据库查找是否有此条数据信息，若有则更改user表的用户状态
     * @param stuIdentity
     * @param stuName
     * @param stuSchool
     * @return
     */
    public List<TStu> findUserExits(String stuIdentity,String stuName,String stuSchool);
}
