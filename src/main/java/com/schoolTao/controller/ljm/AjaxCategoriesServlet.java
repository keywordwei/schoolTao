package com.schoolTao.controller.ljm;


import com.schoolTao.model.TCategory;
import com.schoolTao.service.ICategeoryService;
import com.schoolTao.service.impl.CategeoryServiceImpl;
import net.sf.json.JSONArray;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;




@WebServlet(name = "AjaxCategoriesServlet",urlPatterns = "/ajaxcategories.action")
public class AjaxCategoriesServlet extends HttpServlet {
    private JSONArray jsonArray;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("测试进入");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=UTF-8");

        ICategeoryService ics = new CategeoryServiceImpl();
        List<TCategory> categeories = ics.findAllCategory();
        JSONArray jsonArray = JSONArray.fromObject(categeories);
        System.out.println("servlet里categeories大小"+categeories.size());
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();
        
    }
}
