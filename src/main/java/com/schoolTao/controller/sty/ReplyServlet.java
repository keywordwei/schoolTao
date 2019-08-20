package com.schoolTao.controller.sty;

import com.schoolTao.mapper.MyMapperSty;
import com.schoolTao.mapper.TCommentMapper;
import com.schoolTao.model.TComment;
import com.schoolTao.model.TReply;
import com.schoolTao.service.ReplyService;
import com.schoolTao.service.impl.ReplyServiceImpl;
import com.schoolTao.utils.MybatisUtil;
import com.schoolTao.utils.TimeUtil;
import net.sf.json.JSONObject;
import org.apache.ibatis.session.SqlSession;

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

@WebServlet(name = "ReplyServlet",urlPatterns = {"/reply.action"})
public class ReplyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("1");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=UTF-8");

        System.out.println("into reply");
        //获取评论id
        String replyId = request.getParameter("commentId");
        //获取当前用户
        String username = request.getParameter("username");
        //获取回复内容
        String replyContent = request.getParameter("replyContent");

        System.out.println("replyId:"+replyId+"username:"+username+"replyContent:"+replyContent);
        /***
         * 获取登录用户id
         */
        HttpSession httpSession = request.getSession();
        Integer userId = (Integer) httpSession.getAttribute("userid");
        System.out.println("userId:"+userId);

        /***
         * 通过评论id去找这条评论
         */
        SqlSession session = MybatisUtil.getSqlSession();
        TCommentMapper tCommentMapper= session.getMapper(TCommentMapper.class);
        TComment comment = tCommentMapper.selectByPrimaryKey(Integer.valueOf(replyId));
        System.out.println("Comment:"+comment);
        //获取回复的时间
        long time = TimeUtil.getTimeStamp();
        String format = "yyyy-MM-dd HH:mm:ss";
        String timeStamp =  String.valueOf(time);
        String date = TimeUtil.timeStampToDate(timeStamp,format);
        String times = TimeUtil.dateTotimeStamp(date,format);

        //封装回复信息对象
        TReply tReply = new TReply();
        tReply.setReplyContent(replyContent);
        tReply.setReplyId(Integer.valueOf(replyId));
        tReply.setReplyTime(Integer.valueOf(times));
        tReply.setUserId(Integer.valueOf(userId));
        tReply.setUserName(username);
        tReply.setReplyuserName(comment.getCommentName());
        tReply.setReplyuserId(comment.getUserId());
        //  往数据库插入回复信息
        ReplyService replyService = new ReplyServiceImpl();
        int rows = replyService.insertReply(tReply);
        //打印以下返回值看是否插入成功
        System.out.println("Reply:"+rows);

        /***
         * 返回回复信息以及此条回复的用户信息
         */
        SqlSession session2 = MybatisUtil.getSqlSession();
        System.out.println("2");
        MyMapperSty mapper = session2.getMapper(MyMapperSty.class);
        List<Map<String,Object>> map = mapper.findThatReplyWithInsertTime(Integer.valueOf(times));
        System.out.println("map"+map.get(0));
        JSONObject jsonObject = JSONObject.fromObject(map.get(0));
        System.out.println("3");
        //返回JSON数据tReply
        PrintWriter printWriter = response.getWriter();
        printWriter.print(jsonObject);
        printWriter.flush();
        printWriter.close();
        session.close();
        session2.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
