package com.schoolTao.controller.ljm;

import com.github.pagehelper.PageInfo;
import com.schoolTao.service.IGoodsService;
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

@WebServlet(name = "MyBuyGoodsServlet",urlPatterns = "/myBuyGoods.action")
public class MyBuyGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json; charset=utf-8");//text/html和json都可以返回
        response.setCharacterEncoding("utf-8");
        String user_id = request.getParameter("user_id");
        IGoodsService igs = new GoodsServiceImpl();
        List<Map<String,Object>> myBuyList = igs.findBuyGoodsByUserId(Integer.parseInt(user_id));
        //System.out.println("buygoods分页信息"+pageInfo.getSize());
        System.out.println("myBuyGoods:"+myBuyList);
//        System.out.println("页码数组："+pageInfo.getNavigatepageNums());
        JSONArray jsonArray = JSONArray.fromObject(myBuyList);
        System.out.println("myBuyGoodsjsonArray:"+jsonArray);
//        System.out.println("页码数组："+jsonObject.getString("navigatepageNums"));
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();
    }
}
