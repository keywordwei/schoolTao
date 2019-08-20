package com.schoolTao.controller.sy;

import com.schoolTao.model.TUser;
import com.schoolTao.service.TUserService;
import com.schoolTao.service.impl.TUserServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EditServlet",urlPatterns = {"/edit.action"})
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=UTF-8");
        String username = (String) request.getSession().getAttribute("username");
        TUser tUser = new TUser();
        TUserService tUserService = new TUserServiceImpl();
        List<TUser> list =  tUserService.findLoginUser(username);
        if(list.size()>0){
            tUser = list.get(0);
        }
        JSONObject jsonObject = JSONObject.fromObject(tUser);
        System.out.println(jsonObject.toString());
        response.getWriter().write(jsonObject.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
