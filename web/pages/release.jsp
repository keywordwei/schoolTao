<%--
  Created by IntelliJ IDEA.
  User: wei
  Date: 2019/6/21
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>发布二手</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/jquery-ui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/xiaoyuantao.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.0.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery-ui.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/xiaoyuantao.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery.validate.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/preview.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/releasecheck.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/my.js"></script>
</head>
<body>
<header class="home-header">
    <div class="home-nav">
        <div class="home-logo "><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/logo.png" alt=""></div>
        <div class="home-navigation">
            <ul class="clearfix firstmenuhover">
                <li><a href="./index.jsp">首页</a></li>
                <li class="home-dialogmenu">
                    <a href="./find.jsp" >发现
                    </a>
                    <ul class="home-secondmenu clearfix">
                        <li><a href="#">代步工具</a>&nbsp;|&nbsp;</li>
                        <li><a href="#">手机</a>&nbsp;|&nbsp;</li>
                        <li><a href="#">电脑</a>&nbsp;|&nbsp;</li>
                        <li><a href="#">数码</a>&nbsp;|&nbsp;</li>
                        <li><a href="#">电器</a>&nbsp;|&nbsp;</li>
                        <li><a href="#">衣鞋伞帽</a>&nbsp;|&nbsp;</li>
                        <li><a href="#">书籍教材</a>&nbsp;|&nbsp;</li>
                        <li><a href="#">体育健身</a>&nbsp;|&nbsp;</li>
                        <li><a href="#">乐器</a>&nbsp;|&nbsp;</li>
                        <li><a href="#">自行设计</a>&nbsp;|&nbsp;</li>
                        <li><a href="#">其他</a></li>
                    </ul>
                </li>
                <li  class="home-dialogmenu">
                    <a href="#">求购
                    </a>
                    <ul class="home-secondmenu clearfix">
                        <li><a href="#">代步工具</a>&nbsp;|&nbsp;</li>
                        <li><a href="#">手机</a>&nbsp;|&nbsp;</li>
                        <li><a href="#">电脑</a>&nbsp;|&nbsp;</li>
                        <li><a href="#">数码</a>&nbsp;|&nbsp;</li>
                        <li><a href="#">电器</a>&nbsp;|&nbsp;</li>
                        <li><a href="#">衣鞋雨帽</a>&nbsp;|&nbsp;</li>
                        <li><a href="#">书籍教材</a>&nbsp;|&nbsp;</li>
                        <li><a href="#">体育健身</a>&nbsp;|&nbsp;</li>
                        <li><a href="#">乐器</a>&nbsp;|&nbsp;</li>
                        <li><a href="#">自行设计</a>&nbsp;|&nbsp;</li>
                        <li><a href="#">其他</a></li>
                    </ul>
                </li>
                <li class="home-dialogmenu">
                    <a href="./release.jsp" class="click-navbgc">发布</a>
                    <ul class="home-release">
                        <li><a href="./release.jsp">发布二手</a></li>
                        <li><a href="./releasebuy.jsp">发布求购</a></li>
                    </ul>
                </li>
                <li><a href="#">活动</a></li>
            </ul>
        </div>
        <div class="home-searchbar">
            <input type="text" class="home-searchinput">
            <button class="home-searchbtn"></button>
            <%--sty 登录后显示用户信息--%>
            <%
                String username = (String)session.getAttribute("username");
                if(username==null||username==""){
            %>
            <span class="login">
                    <a href="#" class="home-login">登录</a>
                    <span class="space">&nbsp;|&nbsp;</span>
                    <a href="#" class="home-register">注册</a>
                </span>
            <%
            }else{
                String userimage = (String)session.getAttribute("userimage");
            %>
            <span class="login-success">

                    <a href="${pageContext.request.contextPath}/finduser.action" class="success">
                        <img src="${pageContext.request.contextPath}/uploadfile/<%=userimage%>" alt="">
                    </a>
                    <ul class="personalcenter">

                        <li><a href="${pageContext.request.contextPath}/finduser.action"><%=username%></a></li>
                        <hr color="#e8e8e8" size="1" width="100%">
                        <li><a href="${pageContext.request.contextPath}/finduser.action">我的淘车</a></li>
                        <li><a href="${pageContext.request.contextPath}/finduser.action">账号设置</a></li>
                        <li><a href="${pageContext.request.contextPath}/loginOut.action">退出账号</a></li>
                    </ul>
                </span>
            <%
                }
            %>

            <%--sty 登录后显示用户信息--%>
        </div>
    </div>
</header>
<section class="post">
    <div class="post-content clearfix">
        <div class="post-left">
            <ul class="post-ul">
                <li><a href="./release.jsp" class="post-secondhand click-releasebgc">发布二手</a></li>
                <li><a href="./releasebuy.jsp" class="post-release">发布求购</a></li>
            </ul>
        </div>
        <div class="post-right">
            <div class="post-scondhand-detail">
                <div class="post-title">发布二手</div>
                <div class="post-detail">
                    <div class="post-msg">商品信息</div>
                    <hr color="#f6f6f6" size="2" width="100%">
                    <form action="/release.action"  id="release_form" method="post" class="post-form" enctype="multipart/form-data">
                        <table>
                            <tr><td><lable>.</lable><input type="text" name="goods_title" placeholder="请输入标题"></td></tr>
                            <tr><td><lable>.</lable><input type="text" name="goods_detail" placeholder="请输入商品详情"></td></tr>
                            <tr><td class="money"><lable>.</lable><input type="text" name="goods_price" placeholder="请输入商品价格" class="post-goods-pirce" onchange="showPic()"><span class="money-logo">￥</span></td></tr>
                            <tr><td><lable>.</lable><select class="select-postgoods" name="goods_category_name">
                                <option value="">选择商品类型</option>
                                <option>代步工具</option>
                                <option>手机</option>
                                <option>电脑</option>
                                <option>数码</option>
                                <option>电脑</option>
                                <option>衣鞋伞帽</option>
                                <option>书籍教材</option>
                                <option>体育健身</option>
                                <option>乐器</option>
                                <option>自行设计</option>
                                <option>其他</option>
                            </select></td></tr>
                            <tr><td><lable>.</lable><input type="text" placeholder="请输入手机号" name="goods_contact_phone"></td></tr>
                            <tr><td><lable>.</lable><input type="text" placeholder="请输入QQ" name="goods_contact_qq"></td></tr>
                            <tr><td><lable>.</lable>
                                <div class="uploader-img">
                                    <input type="file" name="file" id="file" class="webuploader-element-invisible" multiple="multiple" accept="image/png,image/jpg,image/jpeg" onchange="showPic()">
                                    <div class="adduploader-img"><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/add-images.png" alt=""></div>
                                    <div>点击进入添加图片</div>
                                </div>
                                </td></tr>
                            <tr><td>
                                <div id = "showimage"></div>
                            </td></tr>
                            <tr><td><input type="submit" value="发布" class="submit-secondhand"></td></tr>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<footer class="tao-footer home-footer">
    <div class="footer-wrapper clearmargin">
        <div class="footer-content">
            <div>
                <p class="topic"><a href="#" >联系我们</a></p>
                <ul>
                    <li><a href="#">QQ群:290338403</a></li>
                    <li><a href="#">电话:17740812047</a></li>
                    <li><a href="#">地址：四川师范大学成龙校区</a></li>
                </ul>
            </div>
            <div>
                <p  class="topic"><a href="#">关于我们</a></p>
                <ul>
                    <li><a href="#">我们的项目</a></li>
                    <li><a href="#">我们的团队</a></li>
                    <li><a href="#">企业协议</a></li>
                </ul>
            </div>
            <div>
                <p  class="topic"><a href="#">问题</a></p>
                <ul>
                    <li><a href="#">热线电话:020 - 29075715</a></li>
                    <li><a href="#">反馈</a></li>
                    <li><a href="#">用户协议</a></li>
                </ul>
            </div>
            <div>
                <ul>
                    <li><a href="#"><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/weixin-dark.png" alt="" class="weixin home-weixin"></a></li>
                    <li><a href="#"><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/weibo-dark.png" class="weibo home-weibo"/></a></li>
                </ul>
            </div>
        </div>
        <hr color=#383838 SIZE=1 width="100%">
        <div>
            <p  class="copyright">Copyright © 2019-2020 校园淘</p>
        </div>
    </div>
</footer>
</body>
</html>
