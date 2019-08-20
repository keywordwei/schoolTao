package com.schoolTao.service.impl;

import com.schoolTao.mapper.TStuMapper;
import com.schoolTao.model.TStu;
import com.schoolTao.model.TStuExample;
import com.schoolTao.service.TStuService;
import com.schoolTao.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TStuServiceImpl implements TStuService {

    /****
     * 到数据库查找是否有此条数据信息，若有则更改user表的用户状态
     * @param stuIdentity
     * @param stuName
     * @param stuSchool
     * @return
     */
    @Override
    public List<TStu> findUserExits(String stuIdentity, String stuName, String stuSchool) {
        SqlSession session = MybatisUtil.getSqlSession();
        TStuMapper mapper = session.getMapper(TStuMapper.class);
        TStuExample stuExample = new TStuExample();
        TStuExample.Criteria criteria = stuExample.createCriteria();
        criteria.andStuIdentityEqualTo(stuIdentity);
        criteria.andStuNameEqualTo(stuName);
        criteria.andStuSchoolEqualTo(stuSchool);
        List<TStu> tStus = mapper.selectByExample(stuExample);
        return tStus;
    }
}
