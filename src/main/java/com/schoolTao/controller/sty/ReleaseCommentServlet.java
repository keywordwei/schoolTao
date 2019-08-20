package com.schoolTao.controller.sty;

import com.schoolTao.mapper.MyMapperSty;
import com.schoolTao.model.TComment;
import com.schoolTao.model.TUser;
import com.schoolTao.service.CommentService;
import com.schoolTao.service.TUserService;
import com.schoolTao.service.impl.CommentServiceImpl;
import com.schoolTao.service.impl.TUserServiceImpl;
import com.schoolTao.utils.MybatisUtil;
import com.schoolTao.utils.TimeUtil;
import net.sf.json.JSONObject;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ReleaseCommentServlet",urlPatterns = {"/release_Comment.action"})
public class ReleaseCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=UTF-8");

        /*username: username,product_id:product_id,comment_content:comment_content*/


        String comment_content = request.getParameter("comment_content") ;
        String product_id = request.getParameter("product_id");
        String username = request.getParameter("username");
        String product_category = request.getParameter("product_category");
        product_category = "1";
        System.out.println("comment_content:"+comment_content+"product_id:"+product_id+"username:"+username+"product_category:"+product_category);

        if(product_category.equals("1")){
            /*查询当前用户id根据session中的username*/
            TUserService TUserService = new TUserServiceImpl();
            List<TUser> users = TUserService.findLoginUser(username);
            System.out.println("users:"+users);
            //封装评论Comment对象
            TComment comment = new TComment();
            long time = TimeUtil.getTimeStamp();
            String format = "yyyy-MM-dd HH:mm:ss";
            String timeStamp =  time+"";
            String date = TimeUtil.timeStampToDate(timeStamp,format);
            String times = TimeUtil.dateTotimeStamp(date,format);
            comment.setCommentName(username);
            comment.setCommentContent(comment_content);
            comment.setCommentTime(Integer.valueOf(times));
            comment.setProductId(Integer.valueOf(product_id));
            comment.setUserId(users.get(0).getUserId());
//        往数据库插入评论
            CommentService commentService = new CommentServiceImpl();
            int rows = commentService.insertComment(comment);
            //打印以下返回值看是否插入成功
            System.out.println("release:"+rows);
            int commentId = comment.getCommentId();
            System.out.println("评论id:"+commentId);

            /*返回JSON对象,包括评论以及用户头像*/
            /*通过当前的id去查*/
            SqlSession session = MybatisUtil.getSqlSession();
            MyMapperSty myMapperSty = session.getMapper(MyMapperSty.class);
            List<Map<String,Object>> maps = myMapperSty.findThatComment(commentId);
            System.out.println(maps.size());
            System.out.println("maps:"+maps);

            /****
             * 转化json对象
             */
            JSONObject commentObject = JSONObject.fromObject(maps.get(0));
            PrintWriter printWriter = response.getWriter();
            printWriter.print(commentObject);

            printWriter.flush();
            printWriter.close();
        }else{

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
