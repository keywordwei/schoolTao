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
import java.util.List;

@WebServlet(name = "FindUserServlet",urlPatterns ={"/finduser.action"})
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getSession().getAttribute("username").toString();
        TUserService tUserService = new TUserServiceImpl();
        TUser user = new TUser();
        List<TUser> userList = tUserService.findLoginUser(username);
            if(userList.size()>0) {
                 user = userList.get(0);
            }
        request.getSession().setAttribute("user",user);
        request.setAttribute("userStatus",user.getUserStatus());
        request.getRequestDispatcher("/pages/personalcenter.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
