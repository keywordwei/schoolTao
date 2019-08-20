<%--
  Created by IntelliJ IDEA.
  User: wei
  Date: 2019/6/27
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>个人中心</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/jquery-ui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/xiaoyuantao.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.0.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery-ui.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/xiaoyuantao.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/goods.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/personAttestation.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/my.js"></script>
</head>
<body>
<header class="home-header">
    <div class="home-nav">
        <div class="home-logo "><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/logo.png" alt=""></div>
        <div class="home-navigation">
            <ul class="clearfix firstmenuhover">
                <li><a href="${pageContext.request.contextPath}/index.jsp">首页</a></li>
                <li class="home-dialogmenu">
                    <a href="${pageContext.request.contextPath}/saleGoods.action">发现
                    </a>
                    <ul class="home-secondmenu clearfix">
                        <c:forEach items="${categeories}" var="category">
                            <li><a href="/saleGoods.action?category_id=${category.categoryId}&order=publish_time&pageNum=1">${category.categoryName}</a>&nbsp;|&nbsp;</li>
                        </c:forEach>
                    </ul>
                </li>
                <li  class="home-dialogmenu">
                    <a href="${pageContext.request.contextPath}/buyGoods.action">求购</a>

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

                    <a href="#" class="success">
                        <img id="changeImg" src="${pageContext.request.contextPath}/uploadfile/<%=userimage%>" alt="">
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
<section class="personal-center">
    <div class="personal-center-content">
        <div class="personal-center-bg">
            <img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/personal-backgroung.png" alt="">
        </div>
        <div class="personal-center-usermsg">
            <div class="personal-avatar">
                <div class="pc-avatar">
                    <img src="${pageContext.request.contextPath}/uploadfile/${user.userImg}" alt="">
                    <form class="change-avatar" enctype="multipart/form-data">
                        <input type="file" id="file" name="userimage" accept="image/png,image/jpg,image/jpeg" class="change-personalavatar">
                        <lable class="change-hint">修改头像</lable>
                    </form>
                </div>
            </div>
            <div class="personal-username" id="user_imagename">${user.userName}</div>
        </div>
        <div class="personal-center-nav">
            <div class="personal-navigation">
                <ul class="clearfix">
                    <li>
                        <a id="myInfosbtn"  userid="${userid}">个人资料</a>
                    </li>
                    <li><a id="mySaleGoodsbtn">发布的商品</a></li>
                    <li><a id="myBuyGoodsbtn">发布的求购</a></li>
                    <li><a id="myCollectionbtn">我的收藏</a></li>
                    <li><a href="#">认证信息</a></li>
                </ul>
            </div>
            <div class="nav-msgview clearmargin">
                <div class="personal-data  commonwidth">
                    <div class="basemsg">
                        <div class="basemsg-title">
                            <div class="pt">基本信息</div>
                            <div><button class="changepersonalmsgbtn" id="changebasemsg">修改</button></div>
                        </div>
                        <div id="error_box"></div>
                        <div>
                            <div>用户名</div>
                            <div id="user_name">${user.userName}</div>
                            <div><input type="text" placeholder="用户名" id="user_anme_input"></div>
                        </div>
                        <div>
                            <div>手机</div>
                            <div id="user_phonenumber">${user.userPhonenumber}</div>
                            <div><input type="text" placeholder="手机号" id="user_phonenumber_input" ></div>
                        </div>
                        <div>
                            <div>邮箱</div>
                            <div id="user_email">${user.userEmail}</div>
                            <div><input type="text" placeholder="个人邮箱" id="user_email_input" ></div>
                        </div>
                        <div>
                            <div>个人签名</div>
                            <div id="user_signature">${user.userSignature}</div>
                            <div><input type="text" placeholder="个人签名" id="user_signatrue_input"></div>
                        </div>
                        <div>
                            <div>地址</div>
                            <div><span id="user_adress">${user.userAdress}</span></div>
                            <div><input type="text" placeholder="地址信息" id="user_adress_input"></div>
                        </div>
                    </div>
                    <hr width="100%" size="1" color="#b5b5b5">
                    <div class="contactways">
                        <div class="basemsg">
                            <div  class="basemsg-title">
                                <div  class="pt">联系方式</div>
                                <button class="changepersonalmsgbtn"  id="changecontactways">修改</button>
                            </div>
                            <div id="error_contact"></div>
                            <div>
                                <div>QQ</div>
                                <div id="user_qq">${user.userQq}</div>
                                <div><input type="text" placeholder="个人QQ" id="user_qq_input"></div>
                            </div>
                            <div>
                                <div>微信</div>
                                <div id="user_weixin">${user.userWeixin}</div>
                                <div><input type="text" placeholder="个人微信" id="user_weixin_input"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="released-goods" id="mySaleGoods">
                    <%--<div class="recommend">--%>
                    <%--<ul class="recommend-list">--%>
                    <%--<li>--%>
                    <%--<div><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/testgoods.png" alt=""></div>--%>
                    <%--<p>大容量便携户外运动塑料水杯茶被子770ml</p>--%>
                    <%--<p>￥66</p>--%>
                    <%--</li>--%>
                    <%--</ul>--%>
                    <%--</div>--%>
                    <!-- <div class="nothing">
                        <div><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/personal-nothing.png" alt=""></div>
                        <div>你还没有发布过商品</div>
                        <div><button class="fourwordbtn" id="go-release">发布商品</button></div>
                    </div> -->
                </div>
                <div class="showbuyingmsg pcbuying" id="myBuyGoods">
                    <%--<div class="buying-list">--%>
                    <%--<ul class="clearmargin">--%>
                    <%--<li>--%>
                    <%--<div>--%>
                    <%--<div><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/owneravatar.png" alt=""></div>--%>
                    <%--<div>勤劳的90后</div>--%>
                    <%--</div>--%>
                    <%--<div class="buying-detail">--%>
                    <%--<p class="buying-title">高价回收二手电脑</p>--%>
                    <%--<p class="buying-detailmsg">上海品好电脑电脑回收公司 全上海高价回收台式笔记本以及电脑配件行主要回收各品牌台式笔记本以及各种电脑配件，佳能</p>--%>
                    <%--<p class="buying-price">期望价格：<span class="buying-pricenum">￥25</span>&nbsp;&nbsp;&nbsp;&nbsp; 发布时间：18:32:55</p>--%>
                    <%--<p>手机：<span>1777777777</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>QQ:177777777</span></p>--%>
                    <%--<p>用户认证状态：<span class="buying-authentication">未认证</span></p>--%>
                    <%--</div>--%>
                    <%--</li>--%>
                    <%--</ul>--%>
                    <%--</div>--%>
                    <!-- <div class="nothing">
                        <div><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/personal-nothing.png" alt=""></div>
                        <div>你还没有发布过求购</div>
                        <div><button class="fourwordbtn" id="go-releasebuy">发布求购</button></div>
                    </div> -->
                </div>
                <div class="collectgoods clearmargin" id="myCollection">
                    <%--<div class="collectgoodsli clearfix">--%>
                    <%--<div><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/goods-store.png" alt=""></div>--%>
                    <%--<div>--%>
                    <%--<div>2019夏新款女式休闲时尚纯色花朵喇叭袖防嗮服外套</div>--%>
                    <%--<div>九把刀</div>--%>
                    <%--<div>联系电话：&nbsp;13555556666</div>--%>
                    <%--<div><button class="fourwordbtn editcollect" id="">取消收藏</button></div>--%>
                    <%--</div>--%>
                    <%--</div>--%>

                    <%--<div class="nothing">--%>
                    <%--<div><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/personal-nothing.png" alt=""></div>--%>
                    <%--<div>你还没有收藏过二手商品</div>--%>
                    <%--<div><button class="fourwordbtn" id="go-find">浏览商城</button></div>--%>
                    <%--</div>--%>
                </div>
                <%--sty 认证信息--%>
                <%--判断用户状态，如果还没有认证，则显示认证列表--%>

                    <div class="ac commonwidth">
                        <div class="basemsg" id="identityInfoMessage">
                            <div><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/authentication.png" alt=""></div>
                            <div class="basemsg-title">
                                <div class="pt">认证信息</div>
                            </div>
                            <c:if test="${userStatus==0}">
                            <div>
                                <div>姓名</div>
                                <div><input type="text" placeholder="请输入真实姓名" id="identityUsername"></div>
                            </div>
                            <div>
                                <div>证件号</div>
                                <div><input type="text" placeholder="例2016110666" id="identityNumber"></div>
                            </div>
                            <div>
                                <div>学校</div>
                                <div><input type="text" placeholder="例四川师范大学" id="identitySchool"></div>
                            </div>
                            </c:if>
                            <%--判断用户状态，如果已经认证不再显示认证列表--%>
                            <c:if test="${userStatus!=0}">
                                <span>认证成功！欢迎加入校园淘，更多精彩福利等你来哟！</span>
                            </c:if>
                            <div><button class="changepersonalmsgbtn" id="changePersonalInfoBtn">认证</button></div>
                        </div>
                    </div>
                <%--sty 认证信息--%>
            </div>
        </div>
    </div>
</section>
</body>
</html>
