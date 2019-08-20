package com.schoolTao.controller.sty;


import com.schoolTao.model.TUser;
import com.schoolTao.service.TUserService;
import com.schoolTao.service.impl.TUserServiceImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "RegisterServlet",urlPatterns = {"/register.action"})
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=UTF-8");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        /*
        * 查询改用户名是否已经被注册了
        * */
        TUserService userService = new TUserServiceImpl();
        List<TUser> users = userService.findLoginUser(username);
        JSONArray jsonObject = JSONArray.fromObject(users);
        PrintWriter printWriter = response.getWriter();
        System.out.println(users);
        /*为空*/
        if(users.size() > 0){
            printWriter.print(jsonObject);
        }else{
            /*注册用户*/
            TUser user = new TUser();
            user.setUserPwd(password);
            user.setUserName(username);
            user.setUserStatus(0);
            user.setUserEmail(email);
            System.out.println(user);
            /*注册*/
            int rows = userService.registerUser(user);
            System.out.println("rows"+rows);
            printWriter.print(jsonObject);
        }
        /*如果user不为空则存在，*/
        printWriter.flush();
        printWriter.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
