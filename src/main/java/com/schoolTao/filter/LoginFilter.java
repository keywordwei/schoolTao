package com.schoolTao.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"*.jsp","*.action"})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        final HttpSession session = request.getSession();
        Integer userid = (Integer) request.getSession().getAttribute("userid");
        String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort();
        //不放行的URL
        String urls = "/addCollection.action,/release.jsp,/release.action,/releasebuy.jsp,/releasebuy.action";
        //放行的
        // String urls = "/,/login.jsp,/login.action,/index.action,/index.jsp,/register.jsp,/register.action,/buyGoods.action,/buying.jsp,/saleGoods.action,/find.jsp,/goodsdetail.jsp,/saleGoodsStatus.action,/buyGoodsStatus.action";

        //当前请求的URL
        String requesUrl = request.getRequestURI();
        //获取最后一个斜杠后的字符串
        String url = requesUrl.substring(requesUrl.lastIndexOf("/"));
        //拿到response重定向
        HttpServletResponse response = (HttpServletResponse) resp;

        if(url.equals("/")){
            url = "chain";
        }
        System.out.println(requesUrl);
        //*****判断异步请求和普遍请求*****
        String if_flag = request.getHeader("X-Requested-With");

        //不是异步请求，并且包含在不放行中，则拦截
        if(urls.contains(url)){
            if(userid == null){
                if(if_flag==null){
                    response.sendRedirect("/pages/login.jsp");
                    return;
                }else{
                    System.out.println("异步请求");
                    response.setHeader("REDIRECT", "REDIRECT");//告诉ajax这是重定向
                    response.setHeader("CONTEXTPATH", basePath+"/pages/login.jsp");//重定向地址
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    return;
                }
            }
        }


        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
