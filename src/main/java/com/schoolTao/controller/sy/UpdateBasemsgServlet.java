package com.schoolTao.controller.sy;

import com.schoolTao.model.TUser;
import com.schoolTao.service.TUserService;
import com.schoolTao.service.impl.TUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateBasemsgServlet" ,urlPatterns = {"/updatebasemsg.action"})
public class UpdateBasemsgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String user_name =  request.getParameter("user_name");
        System.out.println(user_name);
        String user_phonenumber = request.getParameter("user_phonenumber");
        String user_email = request.getParameter("user_email");
        System.out.println(user_email);
        String user_signatrue = request.getParameter("user_signatrue");
        System.out.println(user_signatrue);
        String user_adress =  request.getParameter("user_adress");
        TUser user = (TUser) request.getSession().getAttribute("user");
        //设置名字
        user.setUserName(user_name);
        //设置邮箱
        user.setUserEmail(user_email);
        //设置电话
        user.setUserPhonenumber(user_phonenumber);
        //设置地址
        user.setUserAdress(user_adress);
        //设置个性签名
        user.setUserSignature(user_signatrue);
        TUserService tUserService = new TUserServiceImpl();
        tUserService.update(user);
        //刷新
        request.getSession().setAttribute("user",user);
        request.getSession().setAttribute("username",user.getUserName());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
