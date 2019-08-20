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

@WebServlet(name = "LoginServlet",urlPatterns = {"/login.action"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=UTF-8");

        /*获取登录用户名密码*/
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        /*检查是否存在当前用户*/
        TUserService TUserService = new TUserServiceImpl();
        List<TUser> users = TUserService.checkValidUser(username, password);
        System.out.println("users" + users);

        /*构造json对象*/
        JSONArray jsonArray = JSONArray.fromObject(users);
        PrintWriter printWriter = response.getWriter();

        if (users == null) {
            printWriter.print("");
        } else {
            /*在session保存入用户*/
            request.getSession().setAttribute("userid", users.get(0).getUserId());
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("userimage",users.get(0).getUserImg());
            printWriter.print(jsonArray);
            /*
             * 记住密码*/
            /*String rememberpwd = request.getParameter("rememberpwd");
            if (rememberpwd != null) {
                Cookie c1 = new Cookie("userName", username);
                Cookie c2 = new Cookie("password", password);
                c1.setMaxAge(60 * 60 * 24 * 30);
                c2.setMaxAge(60 * 60 * 24 * 30);
                //这里设置保存这条Cookie的时间
                response.addCookie(c1);//添加Cookie
                response.addCookie(c2);
                printWriter.print(jsonArray);
            } else {
                //取消保存用户名
                Cookie cookies[] = request.getCookies();
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("userName")) {
                        System.out.println("清除");
                        cookie.setMaxAge(0);
                    }
                    if (cookie.getName().equals("password")) {
                        cookie.setMaxAge(0);
                    }
                }
            }*/
        }
        printWriter.flush();
        printWriter.close();
}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /*request.getSqlSession().setAttribute("username",null);
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies) {
                if(!"username".equals(cookie.getName())){
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    System.out.println("cookie:1");
                }
            }
        }
        System.out.println("cookie:2");
        response.sendRedirect("/login.jsp");*/
       doPost(request,response);
    }
}
