package com.schoolTao.controller.ljm;

import com.github.pagehelper.PageInfo;

import com.schoolTao.model.TCategory;
import com.schoolTao.service.ICategeoryService;
import com.schoolTao.service.IGoodsService;
import com.schoolTao.service.impl.CategeoryServiceImpl;
import com.schoolTao.service.impl.GoodsServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;
import java.util.Map;

@WebServlet(name = "SaleGoodsServlet",urlPatterns = "/saleGoods.action")
public class SaleGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("测试saleGoods进入");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //进入二手，默认查询第一个分类的按时间排序，的第一页
        String categoryStr = request.getParameter("category_id");
        String pageStr = request.getParameter("pageNum");
        String orderStr = request.getParameter("order");

        //设置默认值
        Integer category_id = categoryStr==null?1:Integer.parseInt(categoryStr);
        Integer pageNum = pageStr==null?1:Integer.parseInt(pageStr);
        String order = orderStr==null?"hot":orderStr;
        request.setAttribute("category_id",category_id);

        //查询分类列表
        ICategeoryService ics = new CategeoryServiceImpl();
        List<TCategory> categeories = ics.findAllCategory();
        request.setAttribute("categeories",categeories);
//        System.out.println(categeories);

        //查询数据
        IGoodsService igs = new GoodsServiceImpl();
        PageInfo<Map<String,Object>> pageInfo = igs.findSaleGoodsByCategoryId(category_id,order,pageNum);
//        for(int i=0; i<pageInfo.getList().size();i++){
//           System.out.println(pageInfo.getList().get(i));
//        }
        request.setAttribute("pageInfo",pageInfo);
        request.getRequestDispatcher("/pages/find.jsp").forward(request,response);
        System.out.println(pageInfo.getList());
    }
}
