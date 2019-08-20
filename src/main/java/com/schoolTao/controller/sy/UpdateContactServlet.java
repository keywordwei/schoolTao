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

@WebServlet(name = "UpdateContactServlet",urlPatterns = {"/updatecontact.action"})
public class UpdateContactServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String user_qq =  request.getParameter("user_qq");
        String user_weixin =  request.getParameter("user_weixin");
        System.out.println(user_qq);
        TUser user = (TUser) request.getSession().getAttribute("user");
        user.setUserQq(user_qq);
        user.setUserWeixin(user_weixin);
        TUserService tUserService = new TUserServiceImpl();
        tUserService.update(user);
        //刷新
        request.getSession().setAttribute("user",user);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
