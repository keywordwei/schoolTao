<%--
  Created by IntelliJ IDEA.
  User: wei
  Date: 2019/6/25
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>求购信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/jquery-ui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/xiaoyuantao.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.0.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery-ui.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/xiaoyuantao.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/my.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/goods.js"></script>
</head>
<body>
<header class="home-header">
    <div class="home-nav">
        <div class="home-logo "><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/logo.png" alt=""></div>
        <div class="home-navigation">
            <ul class="clearfix firstmenuhover">
                <li><a href="${pageContext.request.contextPath}/index.jsp">首页</a></li>
                <li class="home-dialogmenu">
                    <a href="${pageContext.request.contextPath}/saleGoods.action" id="find">发现
                    </a>
                </li>
                <li  class="home-dialogmenu">
                    <a href="${pageContext.request.contextPath}/buyGoods.action"  class="click-navbgc" id="qiugou">求购</a>
                    <ul class="home-secondmenu clearfix">
                        <c:forEach items="${categeories}" var="category">
                            <li><a href="${pageContext.request.contextPath}/buyGoods.action?category_id=${category.categoryId}&order=hot&pageNum=1">${category.categoryName}</a>&nbsp;|&nbsp;</li>
                        </c:forEach>
                    </ul>
                </li>
                <li class="home-dialogmenu">
                    <a href="${pageContext.request.contextPath}/pages/release.jsp">发布</a>
                    <ul class="home-release">
                        <li><a href="${pageContext.request.contextPath}/pages/release.jsp">发布二手</a></li>
                        <li><a href="${pageContext.request.contextPath}/pages/releasebuy.jsp">发布求购</a></li>
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

                        <li><a href="#" id="changename"><%=username%></a></li>
                        <hr color="#e8e8e8" size="1" width="100%">
                        <li><a href="#">商品</a></li>
                        <li><a href="#">账号设置</a></li>
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
<section class="buying-content">
    <div class="home-carsousel">
        <div class="home-carsousel-main buying-carsousel-main">
            <div>
                <ul class="home-move clearfix buying-carsousel">
                    <li><a href="#"><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/banner-faxian.png" alt=""></a></li>
                    <li><a href="#"><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/banner-qugou.png" alt=""></a></li>
                </ul>
            </div>
        </div>
    </div>
    <p class="home-recommend-title">求购好物</p>
    <div class="buying-goods">
        <div class="showbuyingmsg">
            <div class="buying-list">
                <ul class="clearmargin">
                    <c:forEach items="${pageInfo.list}" var="buygoods">
                        <li>
                            <div>
                                <div><img src="${pageContext.request.contextPath}/uploadfile/${buygoods.user_img}" alt="用户头像"></div>
                                <div>${buygoods.user_name}</div>
                            </div>
                            <div class="buying-detail">
                                <p class="buying-title">${buygoods.product_title}</p>
                                <p class="buying-detailmsg">${buygoods.product_details}</p>
                                <p class="buying-price">期望价格：<span class="buying-pricenum">￥${buygoods.product_price}</span>&nbsp;&nbsp;&nbsp;&nbsp; 发布时间：${buygoods.product_publish_time}</p>
                                <p>手机：<span>${buygoods.product_contact_phone}</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>QQ:${buygoods.product_contact_qq}</span></p>
                                <p>用户认证状态：<span class="buying-authentication">${buygoods.user_status==1?"已认证":"未认证"}</span>&nbsp;&nbsp;&nbsp;&nbsp;信息状态：<span class="product_status">${buygoods.product_status==1?"有效":"已过期"}</span></p>
                                <c:if test="${buygoods.user_id==userid}">
                                    <p>修改状态：
                                        <select class="select-product-status">
                                            <option value="-1">修改商品状态</option>
                                            <option value="1" product_id="${buygoods.product_id}">有效</option>
                                            <option value="0" product_id="${buygoods.product_id}">过期</option>
                                        </select>
                                    </p>
                                </c:if>
                            </div>
                        </li>
                    </c:forEach>



                    <%--sty--%>
                    <%--allBuyGoods userid pageInfoStySearch likeStr--%>
                    <c:forEach items="${pageInfoStySearch.list}" var="BuyStygoods">
                        <li>
                            <div>
                                <div><img src="${pageContext.request.contextPath}/uploadfile/${BuyStygoods.user_img}" alt="用户头像"></div>
                                <div>${BuyStygoods.user_name}</div>
                            </div>
                            <div class="buying-detail">
                                <p class="buying-title">${BuyStygoods.product_title}</p>
                                <p class="buying-detailmsg">${BuyStygoods.product_details}</p>
                                <p class="buying-price">期望价格：<span class="buying-pricenum">￥${BuyStygoods.product_price}</span>&nbsp;&nbsp;&nbsp;&nbsp; 发布时间：${BuyStygoods.product_publish_time}</p>
                                <p>手机：<span>${BuyStygoods.product_contact_phone}</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>QQ:${BuyStygoods.product_contact_qq}</span></p>
                                <p>用户认证状态：<span class="buying-authentication">${BuyStygoods.user_status==1?"已认证":"未认证"}</span>&nbsp;&nbsp;&nbsp;&nbsp;信息状态：<span class="product_status">${BuyStygoods.product_status==1?"有效":"已过期"}</span></p>
                                <c:if test="${BuyStygoods.user_id==userid}">
                                    <p>修改状态：
                                        <select class="select-product-status">
                                            <option value="-1">修改商品状态</option>
                                            <option value="1" product_id="${BuyStygoods.product_id}">有效</option>
                                            <option value="0" product_id="${BuyStygoods.product_id}">过期</option>
                                        </select>
                                    </p>
                                </c:if>
                            </div>
                        </li>
                    </c:forEach>

                    <%--sty--%>





                </ul>
            </div>
            <div>
                <ul class="home-paging clearfix">
                    <c:if test="${pageInfo.pages>0}">
                        <c:if test="${pageInfo.hasPreviousPage==true}">
                            <li><a href="${pageContext.request.contextPath}/buyGoods.action?category_id=${category_id}&order=hot&pageNum=${pageInfo.prePage}">&lt;</a></li>
                        </c:if>
                        <c:if test="${pageInfo.hasPreviousPage!=true}">
                            <li><a href="${pageContext.request.contextPath}/buyGoods.action?category_id=${category_id}&order=hot&pageNum=1">&lt;</a></li>
                        </c:if>
                        <c:forEach items="${pageInfo.navigatepageNums}" var="nowPage">
                            <c:if test="${nowPage>=pageInfo.pageNum-1&&nowPage<=pageInfo.pageNum+1}">
                                <li><a class="${ pageInfo.pageNum==nowPage?"active" : ""}" href="${pageContext.request.contextPath}/buyGoods.action?category_id=${category_id}&order=hot&pageNum=${nowPage}">${nowPage}</a></li>
                            </c:if>
                        </c:forEach>
                        <c:if test="${pageInfo.hasNextPage==true}">
                            <li><a href="#">…</a></li>
                            <li><a href="${pageContext.request.contextPath}/buyGoods.action?category_id=${category_id}&order=hot&pageNum=${pageInfo.nextPage}">&gt;</a></li>
                        </c:if>
                        <c:if test="${pageInfo.hasNextPage!=true}">
                            <li><a href="${pageContext.request.contextPath}/buyGoods.action?category_id=${category_id}&order=hot&pageNum=${pageInfo.pages}">&gt;</a></li>
                        </c:if>
                    </c:if>



                    <%--sty sty 分页--%>

                    <c:if test="${pageInfoStySearch.pages>0}">
                        <c:if test="${pageInfoStySearch.hasPreviousPage==true}">
                            <li><a href="${pageContext.request.contextPath}/search.action?category=${category}&searchContent=${likeStr}&pageNum=${pageInfoStySearch.prePage}">&lt;</a></li>
                        </c:if>
                        <c:if test="${pageInfoStySearch.hasPreviousPage!=true}">
                            <li><a href="${pageContext.request.contextPath}/search.action?category=${category}&searchContent=${likeStr}&pageNum=1">&lt;</a></li>
                        </c:if>
                        <c:forEach items="${pageInfoStySearch.navigatepageNums}" var="nowPage">
                            <c:if test="${nowPage>=pageInfoStySearch.pageNum-1&&nowPage<=pageInfoStySearch.pageNum+1}">
                                <li><a class="${ pageInfoStySearch.pageNum==nowPage?"active" : ""}" href="${pageContext.request.contextPath}/search.action?category=${category}&searchContent=${likeStr}&pageNum=${nowPage}">${nowPage}</a></li>
                            </c:if>
                        </c:forEach>
                        <c:if test="${pageInfoStySearch.hasNextPage==true}">
                            <li><a href="#">…</a></li>
                            <li><a href="${pageContext.request.contextPath}/search.action?category=${category}&searchContent=${likeStr}&pageNum=${pageInfoStySearch.nextPage}">&gt;</a></li>
                        </c:if>
                        <c:if test="${pageInfoStySearch.hasNextPage!=true}">
                            <li><a href="${pageContext.request.contextPath}/search.action?category=${category}&searchContent=${likeStr}&pageNum=${pageInfoStySearch.pages}">&gt;</a></li>
                        </c:if>
                    </c:if>

                    <%--sty sty--%>
                </ul>
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
