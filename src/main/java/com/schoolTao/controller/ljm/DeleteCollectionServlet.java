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

@WebServlet(name = "DeleteCollectionServlet",urlPatterns = "/deleteCollection.action")
public class DeleteCollectionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("DeleteCollectionServlet测试进入");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String collection_id = request.getParameter("collection_id");

        ICollectionService ics = new CollectionServiceImpl();
        int res = ics.deleteCollection(Integer.parseInt(collection_id));
        PrintWriter out = response.getWriter();
        if(res!=0){
            out.print("删除成功！");
        }else{
            out.print("删除失败！");
        }
        out.flush();
        out.close();
    }
}
