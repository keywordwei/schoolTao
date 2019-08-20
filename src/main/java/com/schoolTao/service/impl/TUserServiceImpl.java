package com.schoolTao.service.impl;


import com.schoolTao.mapper.TUserMapper;
import com.schoolTao.model.TUser;
import com.schoolTao.model.TUserExample;
import com.schoolTao.service.TUserService;
import com.schoolTao.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TUserServiceImpl implements TUserService {
    private SqlSession session = MybatisUtil.getSqlSession();

    /***
     * 检查当前登录用户的用户名密码是否正确
     * @param username
     * @param password
     * @return
     */
    @Override

    public List<TUser> checkValidUser(String username, String password) {


        TUserMapper userMapper = session.getMapper(TUserMapper.class);
        TUserExample userExample = new TUserExample();
        TUserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(username);
        criteria.andUserPwdEqualTo(password);
        List<TUser> users = userMapper.selectByExample(userExample);
        System.out.println(users);
        session.close();
        return users;
    }


    /****
     * 检查当前用户名是否存在或者说已经登录
     * @param username
     * @return
     */
    @Override
    public List<TUser> findLoginUser(String username) {
        /*查询当前用户id*/
        TUserMapper userMapper = session.getMapper(TUserMapper.class);

        TUserExample userExample = new TUserExample();
        TUserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(username);
        /*根据用户名查当前用户的id*/
        List<TUser> users = userMapper.selectByExample(userExample);
        session.close();
        return users;
    }


    /****
     * 用户注册
     * @param user
     * @return
     */
    @Override
    public int registerUser(TUser user) {
        SqlSession session = MybatisUtil.getSqlSession();
        TUserMapper userMapper = session.getMapper(TUserMapper.class);
        int rows=0;
        try {
            rows = userMapper.insert(user);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            session.commit();
            session.close();

        }
        return rows;
    }
    /**
     * 更新用户
     *
     * @param user
     */
    @Override
    public void update(TUser user) {
        SqlSession session = MybatisUtil.getSqlSession();
        TUserMapper userMapper = session.getMapper(TUserMapper.class);
        try {
            userMapper.updateByPrimaryKey(user);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.commit();
            session.close();
        }
    }
    @Override
    public int updateUserStstus(TUser user) {
        SqlSession session = MybatisUtil.getSqlSession();
        TUserMapper userMapper = session.getMapper(TUserMapper.class);
        int rows = userMapper.updateByPrimaryKeySelective(user);
        session.commit();
        return rows;
    }
}
