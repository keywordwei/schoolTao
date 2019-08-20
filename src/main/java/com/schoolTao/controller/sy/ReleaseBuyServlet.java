package com.schoolTao.controller.sy;

import com.schoolTao.model.TBuyGoods;
import com.schoolTao.model.TCategory;
import com.schoolTao.model.TUser;
import com.schoolTao.service.ICategeoryService;
import com.schoolTao.service.IGoodsService;
import com.schoolTao.service.TUserService;
import com.schoolTao.service.impl.CategeoryServiceImpl;
import com.schoolTao.service.impl.GoodsServiceImpl;
import com.schoolTao.service.impl.TUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ReleaseBuyServlet" ,urlPatterns = {"/releasebuy.action"})
public class ReleaseBuyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String product_title =  request.getParameter("product_title");
       String product_details = request.getParameter("product_details");
       String product_price = request.getParameter("product_price");
       String product_category_name = request.getParameter("product_category_name");
       String product_contact_phone =  request.getParameter("product_contact_phone");
       String product_contact_qq = request.getParameter("product_contact_qq");
       TBuyGoods tBuyGoods = new TBuyGoods();
       //设置标题
       tBuyGoods.setProductTitle(product_title);
       //设置详情
       tBuyGoods.setProductDetails(product_details);
       //设置价格
       tBuyGoods.setProductPrice(Double.parseDouble(product_price));
       //设置类别
       tBuyGoods.setProductCategoryName(product_category_name);
       //通过名字查找id并设置
       ICategeoryService iCategeoryService = new CategeoryServiceImpl();
       TCategory tCategory = iCategeoryService.findCategoryByname(product_category_name);
       tBuyGoods.setProductCategoryId(tCategory.getCategoryId());
       //设置联系电话
       tBuyGoods.setProductContactPhone(product_contact_phone);
       //设置联系qq
       tBuyGoods.setProductContactQq(product_contact_qq);
       //通过名字查找用户id
       tBuyGoods.setProductByUserId(1);
       String username =  request.getSession().getAttribute("username").toString();
       TUserService tUserService = new TUserServiceImpl();
       List<TUser> userList = tUserService.findLoginUser(username);
       if(userList.size()>0) {
          TUser user = userList.get(0);
          //设置发布订单的用户id
          tBuyGoods.setProductByUserId(user.getUserId());
       }
       //设置发布时间
       tBuyGoods.setProductPublishTime(11);
       //默认有效期
       tBuyGoods.setProductStatus(1);
       //默认热度为0
       tBuyGoods.setProductHot(0);
       //保存到数据库
       IGoodsService releaseBuyService = new GoodsServiceImpl();
       releaseBuyService.save(tBuyGoods);
       //跳转界面
       request.getRequestDispatcher("/buyGoods.action").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request,response);
    }
}
