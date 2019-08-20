package com.schoolTao.controller.ljm;

import com.schoolTao.model.TBuyGoods;
import com.schoolTao.service.IGoodsService;
import com.schoolTao.service.impl.GoodsServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BuyGoodsStatusServlet",urlPatterns = "/buyGoodsStatus.action")
public class BuyGoodsStatusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json; charset=utf-8");//text/html和json都可以返回
        response.setCharacterEncoding("utf-8");
        String product_id = request.getParameter("product_id");
        String statusStr = request.getParameter("product_status");
        System.out.println(statusStr);

        IGoodsService igs = new GoodsServiceImpl();
        // TBuyGoods tBuyGoods = igs.findBuyGoodsAndUserById(Integer.parseInt(product_id));
        TBuyGoods tBuyGoods = new TBuyGoods();
        tBuyGoods.setProductId(Integer.parseInt(product_id));
        if(tBuyGoods!=null){
            tBuyGoods.setProductStatus(Integer.parseInt(statusStr));
            igs.updateBuyGoods(tBuyGoods);
        }
        JSONObject jsonObject = JSONObject.fromObject(tBuyGoods);
        System.out.println(jsonObject);
        PrintWriter out = response.getWriter();
        out.print(jsonObject);
        out.flush();
        out.close();
    }
}
