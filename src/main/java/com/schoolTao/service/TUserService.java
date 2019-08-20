package com.schoolTao.service;

import com.schoolTao.model.TUser;

import java.util.List;

public interface TUserService {


    /**
     * 查询用户是否存在以及用户名密码是否正确
     * @return
     */
    public List<TUser> checkValidUser(String username, String password);


    /***
     * 根据sesison的用户名把用户信息全部找出来，检查当前用户名是否存在或者说已经登录
     * @param username
     * @return
     */
    public List<TUser> findLoginUser(String username);


    /****
     * 用户注册
     * @param user
     * @return
     */
    public int registerUser(TUser user);
    void update(TUser user);

    /****
     * 更新用户状态
     * @param user
     * @return
     */
    public int updateUserStstus(TUser user);
}
