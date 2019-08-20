package com.schoolTao.controller.ljm;

import com.schoolTao.model.TSaleGoods;
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

@WebServlet(name = "SaleGoodsStatusServlet",urlPatterns = "/saleGoodsStatus.action")
public class SaleGoodsStatusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json; charset=utf-8");//text/html和json都可以返回
        response.setCharacterEncoding("utf-8");
        String goods_id = request.getParameter("goods_id");
        String statusStr = request.getParameter("goods_status");
        System.out.println(statusStr+":"+goods_id);

        IGoodsService igs = new GoodsServiceImpl();
        // TSaleGoods tSaleGoods = igs.findSaleGoodsById(Integer.parseInt(goods_id));
        TSaleGoods tSaleGoods = new TSaleGoods();
        tSaleGoods.setGoodsId(Integer.parseInt(goods_id));
        if(tSaleGoods!=null){
            tSaleGoods.setGoodsStatus(Integer.parseInt(statusStr));
            igs.updateSaleGoods(tSaleGoods);
        }
        JSONObject jsonObject = JSONObject.fromObject(tSaleGoods);
        System.out.println(jsonObject);
        PrintWriter out = response.getWriter();
        out.print(jsonObject);
        out.flush();
        out.close();
    }
}
