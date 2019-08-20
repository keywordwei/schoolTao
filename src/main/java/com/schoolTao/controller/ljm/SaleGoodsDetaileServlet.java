package com.schoolTao.controller.ljm;

import com.schoolTao.mapper.MyMapperSty;
import com.schoolTao.model.TComment;
import com.schoolTao.model.TSaleGoods;
import com.schoolTao.service.CommentService;
import com.schoolTao.service.IGoodsService;
import com.schoolTao.service.impl.CommentServiceImpl;
import com.schoolTao.service.impl.GoodsServiceImpl;
import com.schoolTao.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "SaleGoodsDetaileServlet",urlPatterns = "/saleGoodsDetaile.action")
public class SaleGoodsDetaileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");//text/html和json都可以返回
        response.setCharacterEncoding("utf-8");
        String goods_id = request.getParameter("goods_id");

        IGoodsService igs = new GoodsServiceImpl();
        Map<String,Object> salegoodsMap = igs.findSaleAndUserGoodsById(Integer.parseInt(goods_id));
        if(salegoodsMap!=null){
            TSaleGoods tSaleGoods = new TSaleGoods();
            tSaleGoods.setGoodsId(Integer.parseInt(goods_id));
//            if(statusStr!=null&&"".equals(statusStr))
//            tSaleGoods.setGoodsValidTime(Integer.parseInt(statusStr));//修改状态
            tSaleGoods.setGoodsHot((Integer)salegoodsMap.get("goods_hot")+1);//点击则热度加一
            igs.updateSaleGoods(tSaleGoods);
        }

        //查询推荐
        List<TSaleGoods> tSaleGoods = igs.findRecommend();//按热度推荐
        System.out.println("推荐信息："+tSaleGoods);
        request.setAttribute("recommends",tSaleGoods);

        System.out.println("详细信息："+salegoodsMap);
        request.setAttribute("salegoods",salegoodsMap);



        /***
         * sty6/26
         * 查询评论消息，以及评论下的回复
         * goods_id为商品id参数
         */
        System.out.println("goodsId:"+goods_id);
        CommentService commentService = new CommentServiceImpl();
        /***
         * mapList依赖存放评论以及评论下的回复
         * */
        List<Map<String,Object>> lists = null;
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        MyMapperSty myMapperSty = sqlSession.getMapper(MyMapperSty.class);
        List<TComment> allComment = commentService.findAllComment(goods_id);

        /***
         * id下所有评论*/
        List<Map<String,Object>> mapListComment = myMapperSty.findAllCommentAndUserInfo(Integer.valueOf(goods_id));


        /***
         * 查找所有的回复包含的用户信息，在前台一一遍历
         */
        lists = myMapperSty.findAllReplyWithUserInfo();



        /*for (TComment item:allComment) {
            *//***
             * 对每一个id找所有回复，将
             * *//*
            *//*ReplyService replyService = new ReplyServiceImpl();*//*
            lists = myMapperSty.findAllReplyAndUserInfo(item.getCommentId());
            System.out.println("lists:"+lists);
            *//*if(templists!=null&&templists.size()>0){
                boolean add = lists.addAll(templists);
            }*//*
        }*/

        /****
         * 存入所有评论
         */
        request.setAttribute("mapListComment",mapListComment);

        /***
         * 存入评论的id以及改id下的所有回复
         */
        request.setAttribute("allReplyAndUserInfo",lists);


        /****
         * stystysty
         */


        request.getRequestDispatcher("/pages/goodsdetail.jsp").forward(request,response);
    }
}
