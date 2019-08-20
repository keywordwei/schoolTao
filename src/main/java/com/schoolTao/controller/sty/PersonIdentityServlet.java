package com.schoolTao.controller.sty;

import com.schoolTao.model.TStu;
import com.schoolTao.model.TUser;
import com.schoolTao.service.TStuService;
import com.schoolTao.service.TUserService;
import com.schoolTao.service.impl.TStuServiceImpl;
import com.schoolTao.service.impl.TUserServiceImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "PersonIdentityServlet",urlPatterns = {"/personIdentity.action"})
public class PersonIdentityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=UTF-8");


        /***
         * 获取参数
         */
        String stuIdentity = request.getParameter("stuIdentity");
        String stuName = request.getParameter("stuName");
        String stuSchool = request.getParameter("stuSchool");
        System.out.println("stuIdentity:"+stuIdentity+"stuName:"+stuName+"stuSchool:"+stuSchool);
        /***
         * 到数据库查找是否有此条数据信息，若有则更改user表的用户状态
         */
        TStuService tStuService = new TStuServiceImpl();
        List<TStu> userExits = tStuService.findUserExits(stuIdentity, stuName, stuSchool);
        System.out.println("输入的学生信息是否存在"+userExits);

        /***
         * 转化json数据
         */
        PrintWriter printWriter = response.getWriter();
        JSONArray jsonArray = JSONArray.fromObject(userExits);
        printWriter.print(jsonArray);
        /***
         * 不管是否有这个人，先把封装的对象传过去，在前台判断
         */

        /***
         * 后台处理，是否用当前用户，如果有则将用户的状态变为1
         */
        if(userExits.size()>0){
            /***
             * 更改t_user数据库
             *
             */
            HttpSession httpSession = request.getSession();
            Integer userid = (Integer)httpSession.getAttribute("userid");
            TUser user = new TUser();
            user.setUserId(userid);
            user.setUserStatus(1);

            TUserService userService = new TUserServiceImpl();
            int rows = userService.updateUserStstus(user);
            System.out.println("rows"+rows);
        }
        printWriter.flush();
        printWriter.close();
   }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
