package com.schoolTao.controller.ljm;

import com.github.pagehelper.PageInfo;
import com.schoolTao.service.ICollectionService;
import com.schoolTao.service.IGoodsService;
import com.schoolTao.service.impl.CollectionServiceImpl;
import com.schoolTao.service.impl.GoodsServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "MyCollectionServlet",urlPatterns = "/myCollection.action")
public class MyCollectionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json; charset=utf-8");//text/html和json都可以返回
        response.setCharacterEncoding("utf-8");
        String user_id = request.getParameter("user_id");
        ICollectionService ics = new CollectionServiceImpl();
        List<Map<String,Object>> collectionList = ics.findSaleGoodsCollection(Integer.parseInt(user_id));
        System.out.println("myCollection:"+collectionList);
        JSONArray jsonArray = JSONArray.fromObject(collectionList);
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();
    }
}
