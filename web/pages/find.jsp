<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>发现</title>
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
        <div class="home-logo "><img src="${pageContext.request.contextPath}/static/images/login/logo.png" alt=""></div>
        <div class="home-navigation">
            <ul class="clearfix firstmenuhover">
                <li><a href="${pageContext.request.contextPath}/index.jsp">首页</a></li>
                <li class="home-dialogmenu">
                    <a href="${pageContext.request.contextPath}/saleGoods.action" class="click-navbgc" id="find">发现
                    </a>
                    <ul class="home-secondmenu clearfix">
                        <c:forEach items="${categeories}" var="category">
                            <li><a href="${pageContext.request.contextPath}/saleGoods.action?category_id=${category.categoryId}&order=hot&pageNum=1">${category.categoryName}</a>&nbsp;|&nbsp;</li>
                        </c:forEach>
                    </ul>
                </li>
                <li  class="home-dialogmenu">
                    <a href="${pageContext.request.contextPath}/buyGoods.action" id="qiugou">求购</a>

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
                        <img src="${pageContext.request.contextPath}/uploadfile/<%=userimage%>">
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
<section class="home-content">
    <div class="home-carsousel">
        <div class="home-carsousel-main">
            <div>
                <ul class="home-move clearfix">
                    <li><a href="#"><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/banner.png" alt=""></a></li>
                    <li><a href="#"><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/banner2.png" alt=""></a></li>
                    <li><a href="#"><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/banner3.png" alt=""></a></li>
                    <li><a href="#"><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/banner4.png" alt=""></a></li>
                    <li><a href="#"><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/banner5.png" alt=""></a></li>
                </ul>
            </div>
            <div class="home-previous"><a href="#"><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/prev.png" alt=""></a></div>
            <div class="home-next"><a href="#"><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/next.png" alt=""></a></div>
        </div>
        <p class="home-recommend-title">发现好物</p>
    </div>
    <div class="home-goods">
        <ul class="home-product clearfix">
            <c:forEach items="${pageInfo.list}" var="salegoods">
                <li>
                    <a href="${pageContext.request.contextPath}/saleGoodsDetaile.action?goods_id=${salegoods.goods_id}">
                    <div class="home-goods-img">
                        <img src="${pageContext.request.contextPath}/uploadfile/${salegoods.goods_img[0]}" alt="商品图片">
                        <span class="home-goodsprice"></span>
                        <span class="home-price">¥${salegoods.goods_price}</span>
                    </div>
                    <div class="home-goodsmsg">
                        <p class="home-goodsdetail">${salegoods.goods_title}</p>
                        <p class="home-goodsclick">点击数${salegoods.goods_hot}</p>
                    </div>
                    </a>
                    <hr width="200px" color="#f8f8f8" size="2">
                    <div class="home-goodsowner clearfix">
                        <div class="home-owner v-center">
                            <img src="${pageContext.request.contextPath}/uploadfile/${salegoods.user_img}" alt="用户头像" class="person-avatar"><span class="home-ownername">${salegoods.user_name}</span>
                            <div class="home-userdialog">
                                <span class="dialog"></span>
                                <div class="big-img"><img src="${pageContext.request.contextPath}/uploadfile/${salegoods.user_img}" alt="用户头像"></div>
                                <div class="attention"><a href="#">关注</a><a onclick="SaleCollection('${salegoods.goods_id}','${userid}')">收藏</a></div>
                            </div>
                        </div>

                        <div class="home-ownerauthentication v-center">${salegoods.user_status==1?"已认证":"未认证"}</div>
                    </div>
                </li>
            </c:forEach>

            <%--sty 搜索goods--%>
            <%--后台数据库--%>
            <c:forEach  items="${allBuyGoods}" var="BuyGoods">
                <li>
                    <div class="home-goods-img">
                        <img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/${BuyGoods.productImg[0]}" alt="">
                        <span class="home-goodsprice"></span>
                        <span class="home-price">${BuyGoods.productPrice}</span>
                    </div>
                    <div class="home-goodsmsg">
                        <p class="home-goodsdetail">${BuyGoods.productTitle}</p>
                        <p class="home-goodsclick">点击数${BuyGoods.productHot}</p>
                    </div>
                    <hr width="200px" color="#f8f8f8" size="2">
                    <div class="home-goodsowner clearfix">
                        <div class="home-owner v-center">
                            <img src="${pageContext.request.contextPath}/uploadfile/${BuyGoods.user_img}" alt="" class="person-avatar"><span class="home-ownername">${BuyGoods.userName}</span>
                            <div class="home-userdialog">
                                <span class="dialog"></span>
                                <div class="big-img"><img src="${pageContext.request.contextPath}/uploadfile/${BuyGoods.user_img}" alt=""></div>
                                <div class="attention"><a href="#">关注</a><a onclick="SaleCollection('${SaleGoods.goodsId}','${userid}')">收藏</a></div>
                            </div>
                        </div>
                        <div class="home-ownerauthentication v-center">${BuyGoods.user_status==1? "已认证":"未认证"}</div>
                    </div>
                </li>
            </c:forEach>
            <%--sty 上面是搜索goods--%>



            <%--sty 搜索SaleGoods 区分于category--%>
            <%--后台数据库--%>
            <c:forEach items="${pageSaleGoodsInfo.list}" var="pageSaleGoodsInfo">
                <li>
                    <a href="${pageContext.request.contextPath}/saleGoodsDetaile.action?goods_id=${pageSaleGoodsInfo.goodsId}">
                        <div class="home-goods-img">
                            <img src="${pageContext.request.contextPath}/uploadfile/${pageSaleGoodsInfo.goodsImg[0]}" alt="商品图片">
                            <span class="home-goodsprice"></span>
                            <span class="home-price">¥${pageSaleGoodsInfo.goodsPrice}</span>
                        </div>
                        <div class="home-goodsmsg">
                            <p class="home-goodsdetail">${pageSaleGoodsInfo.goodsTitle}</p>
                            <p class="home-goodsclick">点击数${pageSaleGoodsInfo.goodsHot}</p>
                        </div>
                    </a>
                    <hr width="200px" color="#f8f8f8" size="2">
                    <div class="home-goodsowner clearfix">
                        <div class="home-owner v-center">
                            <img src="${pageContext.request.contextPath}/uploadfile/${pageSaleGoodsInfo.userImg}" alt="用户头像" class="person-avatar"><span class="home-ownername">${pageSaleGoodsInfo.userName}</span>
                            <div class="home-userdialog">
                                <span class="dialog"></span>
                                <div class="big-img"><img src="${pageContext.request.contextPath}/uploadfile/${pageSaleGoodsInfo.userImg}" alt="用户头像"></div>
                                <div class="attention"><a href="#">关注</a><a onclick="SaleCollection('${pageSaleGoodsInfo.goods_id}','${userid}')">收藏</a></div>
                            </div>
                        </div>

                        <div class="home-ownerauthentication v-center">${salegoods.userStatus==1?"已认证":"未认证"}</div>
                    </div>
                </li>
            </c:forEach>
            <%--sty 上面是搜索goods--%>


        </ul>
        <ul class="home-paging clearfix">
            <c:if test="${pageInfo.pages>0}">
                <c:if test="${pageInfo.hasPreviousPage==true}">
                    <li><a href="${pageContext.request.contextPath}/saleGoods.action?category_id=${category_id}&order=hot&pageNum=${pageInfo.prePage}">&lt;</a></li>
                </c:if>
                <c:if test="${pageInfo.hasPreviousPage!=true}">
                    <li><a href="${pageContext.request.contextPath}/saleGoods.action?category_id=${category_id}&order=hot&pageNum=1">&lt;</a></li>
                </c:if>
                <c:forEach items="${pageInfo.navigatepageNums}" var="nowPage">
                    <c:if test="${nowPage>=pageInfo.pageNum-1&&nowPage<=pageInfo.pageNum+1}">
                        <li><a class="${ pageInfo.pageNum==nowPage?"active" : ""}" href="${pageContext.request.contextPath}/saleGoods.action?category_id=${category_id}&order=hot&pageNum=${nowPage}">${nowPage}</a></li>
                    </c:if>
                </c:forEach>
                <c:if test="${pageInfo.hasNextPage==true}">
                    <li><a href="#">…</a></li>
                    <li><a href="${pageContext.request.contextPath}/saleGoods.action?category_id=${category_id}&order=hot&pageNum=${pageInfo.nextPage}">&gt;</a></li>
                </c:if>
                <c:if test="${pageInfo.hasNextPage!=true}">
                    <li><a href="${pageContext.request.contextPath}/saleGoods.action?category_id=${category_id}&order=hot&pageNum=${pageInfo.pages}">&gt;</a></li>
                </c:if>
            </c:if>

            <%--sty search分页2019/6/24--%>
            <%--<c:if test="${pageInfoStySearch==null}">--%>
            <%--<li><a href="${pageContext.request.contextPath}/search.action?category=1&searchContent=${likeStr}&pageNum=${pageInfoStySearch.navigateFirstPage}">首页</a></li>--%>
            <c:if test="${pageSaleGoodsInfo.hasPreviousPage}"><li><a href="${pageContext.request.contextPath}/search.action?category=${category}&searchContent=${likeStr}&pageNum=${pageSaleGoodsInfo.prePage}">&lt;</a></li></c:if>
            <c:forEach items="${pageSaleGoodsInfo.navigatepageNums}" var="pagesSty">
                <li><a class="${ pageSaleGoodsInfo.pageNum==pagesSty?"active" : ""}" href="${pageContext.request.contextPath}/search.action?category=${category}&searchContent=${likeStr}&pageNum=${pagesSty}">${pagesSty}</a></li>
            </c:forEach>
            <c:if test="${pageSaleGoodsInfo.hasNextPage}"><li><a href="${pageContext.request.contextPath}/search.action?category=${category}&searchContent=${likeStr}&pageNum=${pageSaleGoodsInfo.nextPage}">&gt;</a></li></c:if>
            <%--<li><a href="${pageContext.request.contextPath}/search.action?category=1&searchContent=${likeStr}&pageNum=${pageInfoStySearch.navigateLastPage}">尾页</a></li>--%>
            <%--</c:if>--%>
            <%--sty search分页2019/6/24--%>
        </ul>

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