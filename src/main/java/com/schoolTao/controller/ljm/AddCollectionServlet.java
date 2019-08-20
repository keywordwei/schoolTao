package com.schoolTao.controller.ljm;

import com.schoolTao.model.TCollection;
import com.schoolTao.service.ICollectionService;
import com.schoolTao.service.impl.CollectionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddCollectionServlet",urlPatterns = "/addCollection.action")
public class AddCollectionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("AddCollectionServlet测试进入");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String user_id = request.getParameter("user_id");
        String goods_id = request.getParameter("goods_id");
        System.out.println(user_id+":"+goods_id);

        ICollectionService ics = new CollectionServiceImpl();
        TCollection tCollection = new TCollection();
        tCollection.setCollectionUserId(Integer.parseInt(user_id));
        tCollection.setCollectionGoodsId(Integer.parseInt(goods_id));
        int res = ics.addSaleGoodsToCollection(tCollection);
        PrintWriter out = response.getWriter();
        if(res!=0){
            out.print("收藏成功！");
        }else{
            out.print("该商品已被收藏！");
        }
        out.flush();
        out.close();
    }
}
