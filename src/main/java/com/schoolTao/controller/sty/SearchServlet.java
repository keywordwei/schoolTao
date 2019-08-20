package com.schoolTao.controller.sty;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.schoolTao.service.SGoodsService;
import com.schoolTao.service.StySaleGoodService;
import com.schoolTao.service.impl.SGoodsServiceImpl;
import com.schoolTao.service.impl.StySaleGoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;
import java.util.Map;

@WebServlet(name = "SearchServlet",urlPatterns = {"/search.action"})
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=UTF-8");

        System.out.println("进入search");
        /***
         * 获取数据
         * */
        String category = request.getParameter("category");
        request.setAttribute("category",category);
        String searchContent = request.getParameter("searchContent");
        System.out.println("category:"+category);
        System.out.println("searchContent:"+searchContent);
        /***
         * 按照逗号以及空格来分割
         */
        String[] strs=searchContent.split("[\\s+]|,");
        /****
         * 分类查询
         */
        /***
         * 往前台打印
         * */
        PrintWriter printWriter = response.getWriter();

        if(category.equals("2")){
            /***
             * 根据当前页面是在商品还是求购中，如果是发现就在发现的商品中去找
             * */

            for(String s : strs){
                /***
                 * 对每一个字段都去搜索
                 */
                String likeStr = s;
                String imgs="";
                SGoodsService sGoodsService = new SGoodsServiceImpl();

                /***
                 * 获取当前页数*/
                String pageNum = request.getParameter("pageNum");
                System.out.println("pageNumGoods:"+pageNum);
                PageHelper.startPage(pageNum!=null ? Integer.valueOf(pageNum):1,15);
                List<Map<String, Object>> allBuyGoods = sGoodsService.findAllBuyGoods(likeStr);
                PageInfo<Map<String,Object>> pageInfo = new PageInfo<>(allBuyGoods);
                System.out.println(pageInfo);
                for(int i=0; i<allBuyGoods.size();i++){
                    //imgs = mapList.get(i).get("goods_img").toString().split("#");
                    imgs = (String) allBuyGoods.get(i).get("goods_img");
                    allBuyGoods.get(i).put("goods_img",imgs.split("#"));
                }
                pageInfo = new PageInfo<>(allBuyGoods);
                /***
                 * 同步返回商品*/
                request.setAttribute("allBuyGoods",allBuyGoods);


                /*
                * 返回用户id
                * */
                HttpSession httpSession = request.getSession();
                String userid = (String) httpSession.getAttribute("userid");
                request.setAttribute("userid",userid);
                /***
                 * 返回分页信息
                 */
                request.setAttribute("pageInfoStySearch",pageInfo);

                /***
                 * 存关键字*/
                request.setAttribute("likeStr",likeStr);
                request.getRequestDispatcher("pages/buying.jsp").forward(request,response);
                return;

                /*//异步返回
                JSONArray jsonArrayBuyGoods = JSONArray.fromObject(allBuyGoods);
                printWriter.print(jsonArrayBuyGoods);
                System.out.println("allBuyGoods:"+allBuyGoods);*/
            }
        }else{
            /***
             * 如果是求购就在发现的商品中去找
             * */
            for(String s : strs){
                /***
                 * 对每一个字段都去搜索
                 */
                String likeStr = s;
                String imgs="";
                System.out.println(likeStr);
                StySaleGoodService stySaleGoodService = new StySaleGoodServiceImpl();

                /***
                 * 获取当前页数*/
                String pageNum = request.getParameter("pageNum");
                System.out.println("pageNumSales:"+pageNum);
                PageHelper.startPage(pageNum!=null ? Integer.valueOf(pageNum):1,15);

                List<Map<String, Object>> allSaleGoods = stySaleGoodService.findAllSaleGoods(likeStr);
                PageInfo<Map<String,Object>> pageSaleGoodsInfo = new PageInfo<>(allSaleGoods);
                System.out.println(pageSaleGoodsInfo);
                for(int i=0; i<allSaleGoods.size();i++){
                    //imgs = mapList.get(i).get("goods_img").toString().split("#");
                    imgs = (String) allSaleGoods.get(i).get("goodsImg");
                    allSaleGoods.get(i).put("goodsImg",imgs.split("#"));
                }
                pageSaleGoodsInfo = new PageInfo<>(allSaleGoods);
                /***
                 * 同步返回所有的购买商品*/
                request.setAttribute("allSaleGoods",allSaleGoods);


                /*
                 * 返回用户id
                 * */
                HttpSession httpSession = request.getSession();
                Integer userid = (Integer) httpSession.getAttribute("userid");
                request.setAttribute("userid",userid);
                /***
                 * 返回分页信息
                 */
                request.setAttribute("pageSaleGoodsInfo",pageSaleGoodsInfo);

                /***
                 * 存关键字*/
                request.setAttribute("likeStr",likeStr);

                /***
                 * 这里跳转到不同的页面，buying.jsp显示SaleGoods的物品*/
                request.getRequestDispatcher("pages/find.jsp").forward(request,response);

                /*//异步返回
                JSONArray jsonArraySaleGoods = JSONArray.fromObject(allSaleGoods);
                printWriter.print(jsonArraySaleGoods);
                System.out.println("allSaleGoods:"+jsonArraySaleGoods);*/
            }
        }
        printWriter.flush();
        printWriter.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
