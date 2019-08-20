<%--
  Created by IntelliJ IDEA.
  User: 大哥
  Date: 2019/6/14
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>评论</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.0.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery-ui.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/demo.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/my.js"></script>
</head>

<body>
<%--登录 ｜ 注册--%>
<div class="col-lg-3 col-md-4 col-sm-12 text-right" style="padding-top: 30px;">
    <c:if test="${member==null}">
        <a href="${pageContext.request.contextPath}/pages/login.jsp">登录</a>&nbsp;&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/pages/register.jsp">注册</a>
    </c:if>
    <c:if test="${member!=null}">
        欢迎您：<a href="#">${member.member_nikname}</a>&nbsp;&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/login.action">注销</a>&nbsp;&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/cart.action">我的主页</a>&nbsp;&nbsp;&nbsp;
    </c:if>
</div>

<%--评论--%>
<div id="commentBox">

    <%--存商品ID--%>
    <input id="product-id" type="hidden" value="1">
    <input id="comment_replyId"type="hidden" value="">
    <textarea id="comment_content"></textarea>
    <button class="btn-comment">发表评论</button>
        <span id="test"></span>
    <div class="comment-list-container">
        <div id="comment-list-box">
            <div id="8">
                <ul class="comment-list" id="replytest">
                    <li class="comment-line-box" commentid="1" commentname="sty" comment_userid="1">
                        <a href="#">
                            <span class="user-name">sty</span>
                        </a>
                        <span class="comment_content">这东西是真的吗</span>
                        <span class="opt-box">
                            <a class="btn-reply" href="#">回复</a>
                        </span>
                    </li>
                </ul>
            </div>
            <%--回复--%>
            <span class="reply-line-box" replyId="1" replytname="lilu" reply_userid="1">我是回复的信息</span>

            <div id="9">
                <ul class="comment-list">
                    <li class="comment-line-box" commentid="2" commentname="sty" comment_userid="1">
                        <a href="#">
                            <span class="user-name">stystysty</span>
                        </a>
                        <span class="comment_content">这东西是真的吗</span>
                        <span class="opt-box">
                            <a class="btn-reply" href="#">回复</a>
                        </span>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>

<%--输入--%>
<input name="keyword" type="text" id="serachWord" class="form-control search-field" placeholder="搜索一下...">
</body>
</html>
