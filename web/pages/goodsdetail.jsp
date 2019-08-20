<%--
  Created by IntelliJ IDEA.
  User: wei
  Date: 2019/6/25
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>商品详情</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/jquery-ui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/xiaoyuantao.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.0.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery-ui.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/xiaoyuantao.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/my.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/goods.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/commentAndreply.js"></script>
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
                </li>
                <li  class="home-dialogmenu">
                    <a href="${pageContext.request.contextPath}/buyGoods.action">求购
                    </a>
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
                        <img src="${pageContext.request.contextPath}/uploadfile/<%=userimage%>" alt="">
                    </a>
                    <ul class="personalcenter">
                        <%--var username = $("#loginUser").attr("loginUser");--%>
                        <li><a href="${pageContext.request.contextPath}/finduser.action" id="loginUser" loginUser="<%=username%>"><%=username%></a></li>
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
<section class="goodsdetail">
    <div class="goodsshow-content clearmargin">
        <div class="goods-show clearfix" goodsId="${salegoods.goods_id}" goodsCategory="1">
            <div class="goods-showimg">
                <div class="goods-bigimg">
                    <img src="${pageContext.request.contextPath}/uploadfile/${salegoods.goods_img[0]}" alt="商品图片" class="small-img">
                    <span class="amplifier"></span>
                    <div class="amplifier-big-img">
                        <img src="${pageContext.request.contextPath}/uploadfile/${salegoods.goods_img[0]}" alt="商品图片">
                    </div>
                </div>
                <div class="goodsdetailimg">
                    <ul>
                        <c:forEach items="${salegoods.goods_img}" var="img">
                            <li><img src="${pageContext.request.contextPath}/uploadfile/${img}" alt=""></li>
                        </c:forEach>
                        <%--<li><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/1-22.png" alt=""></li>--%>
                        <%--<li><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/1-33.png" alt=""></li>--%>
                        <%--<li><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/1-44.png" alt=""></li>--%>
                        <%--<li><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/1-55.png" alt=""></li>--%>
                    </ul>
                </div>
            </div>
            <div class="goods-showmsg">
                <p class="goods-showtitle">${salegoods.goods_title}</p>
                <div class="goods-showprice">&nbsp;&nbsp;&nbsp;&nbsp;￥<span class="goods-showpircenum">${salegoods.goods_price}</span></div>
                <div class="goods-ownermsg">
                    <img src="${pageContext.request.contextPath}/uploadfile/${salegoods.user_img}" alt="${salegoods.user_name}">
                    <div>
                        <p>${salegoods.user_name}</p>
                        <p>${salegoods.user_status==1?"已认证":"未认证"}</p>
                    </div>
                </div>
                <p class="goods-detaildescription">商品详情：${salegoods.goods_details}</p>
                <p class="goods-contactphone">联系电话：&nbsp;<span>${salegoods.goods_contact_phone}</span></p>
                <p class="goods-contactqq">联系QQ：&nbsp;&nbsp;<span>${salegoods.goods_contact_qq}</span></p>
                <p class="goods-releasetimer">发布时间：&nbsp;&nbsp;<span>${salegoods.goods_publish_time}</span></p>
                <p class="goods-clicknumber">点击量：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>${salegoods.goods_hot}</span></p>
                <p class="goods-effective">信息状态：&nbsp;&nbsp;&nbsp;<span class="goods_status">${salegoods.goods_status==1?"有效":"已过期"}</span></p>
                <c:if test="${salegoods.user_id==userid}">
                    <p class="goods-effective">修改状态：&nbsp;&nbsp;&nbsp;<select class="select-goods-status">
                        <option value="-1">修改商品状态</option>
                        <option value="1" goods_id="${salegoods.goods_id}">有效</option>
                        <option value="0" goods_id="${salegoods.goods_id}">过期</option>
                    </select></p>
                </c:if>
                <div class="operation">
                    <button class="colllect" id="collection" goodsId="${salegoods.goods_id}" userid="${userid}">收藏</button>
                    <button class="report">举报</button>
                </div>
            </div>
        </div>
    </div>
    <div class="aboutgoods-content clearmargin">
        <div class="goodsabout">
            <div class="review">
                <div class="review-self">
                    <div class="texta">
                        <textarea type="text" z-st="comment_input" placeholder="说点什么..." id="textareaInput" class="textarea-style commentbig textarea"style="height: 42px; padding-right: 60px; overflow-y: scroll;"></textarea>
                        <span class="count">2000</span>
                    </div>
                    <div class="clearfix"><button class="reviewbtn">评论</button></div>
                </div>
                <div class="review-title">
                    <div>全部评论</div>
                </div>
                <div class="review-list" id="review-list">


                    <%--stysty--%>
                    <%--<div class="review-detail">
                        <div class="review-usermsg">
                            <div><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/owneravatar.png" alt=""></div>
                            <div class="review-username">
                                <p>素缘淡然</p>
                                <p>未认证</p>
                            </div>
                        </div>
                        <div class="review-text">
                            <p>衣服是棉的，颜色与图片一样，穿上宽松好看。喜欢又价廉物美。现全家需要的吃穿用东西都在唯品会上买的，省时间还可以退换，售后服务也便捷和诚信。</p>
                            <div class="review-texttime">
                                <div class="review-time">2019-06-24 18:32:55</div>
                                <div class="reply-reviewuser" onclick="showreplymsgbox(21)"><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/pinlunqian.png" alt=""></div>
                            </div>
                            <div class="21-reviewbox" hidden>
                                <div class="texta">
                                    <textarea type="text" z-st="comment_input" placeholder="回复素缘淡然..." class="textarea-style commentbig textarea"style="height: 42px; padding-right: 60px; overflow-y: scroll;"></textarea>
                                    <span class="count">2000</span>
                                </div>
                                <div class="clearfix"><button class="replybtn">回复</button></div>
                            </div>
                            <div class="reply-list">
                                <span class="reply-dialog"></span>
                                <div class="reply-li">
                                    <div class="reply-usermsg">
                                        <div><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/owneravatar.png" alt=""></div>
                                        <div class="reply-detail">
                                            <p class="reply-username">Wei</p>
                                            <p>回复<span class="reply-name">素缘淡然</span>：<span class="reply-text">我觉得不错啊！值得购买。</span></p>
                                            <div class="review-time">2019-06-24 18:32:55</div>
                                        </div>
                                    </div>
                                </div>
                                <hr size="1" width="100%" color="#e8e8ef">
                                <div class="reply-li">
                                    <div class="reply-usermsg">
                                        <div><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/owneravatar.png" alt=""></div>
                                        <div class="reply-detail">
                                            <p class="reply-username">Wei</p>
                                            <p>回复<span class="reply-name">素缘淡然</span>：<span class="reply-text">我觉得不错啊！值得购买。</span></p>
                                            <div class="review-time">2019-06-24 18:32:55</div>
                                        </div>
                                    </div>
                                </div>
                                <hr size="1" width="100%" color="#e8e8ef">
                            </div>
                        </div>
                    </div>
                    <hr size="2" width="100%" color="#f6f6f6">--%>




                    <%--sty foreach循环所有评论以及回复--%>

                        <%--如果为空显示暂无回复--%>
                        <c:if test="${empty mapListComment}">
                            <span>期待您的评论</span>
                        </c:if>

                    <c:forEach items="${mapListComment}" var="Comments">
                        <div class="review-detail">
                            <div class="review-usermsg">
                                <div><img src="${pageContext.request.contextPath}/uploadfile/${Comments.user_img}" alt=""></div>
                                <div class="review-username">
                                    <p>${Comments.user_name}</p>
                                    <p>${Comments.user_status==0 ? "未认证":"已认证"}</p>
                                </div>
                            </div>
                            <div class="review-text">
                                <p>${Comments.comment_content}</p>
                                <div class="review-texttime">
                                    <div class="review-time">
                                        <jsp:useBean id="dateValue" class="java.util.Date"/>
                                        <jsp:setProperty name="dateValue" property="time" value="${Comments.comment_time*1000}"/>
                                        <fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
                                    <div class="reply-reviewuser" onclick="showreplymsgbox(${Comments.comment_id})"><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/pinlunqian.png" alt=""></div>
                                </div>
                                <div class="${Comments.comment_id}-reviewbox" hidden>
                                    <div class="texta">
                                        <textarea type="text" z-st="comment_input" placeholder="回复${Comments.user_name}..." class="textarea-style commentbig textarea"style="height: 42px; padding-right: 60px; overflow-y: scroll;"></textarea>
                                        <span class="count">2000</span>
                                    </div>
                                    <div class="clearfix"><button class="replybtn">回复</button></div>
                                </div>
                                <div class="reply-list">
                                    <span class="reply-dialog"></span>
                                    <%--<div class="reply-li">
                                        <div class="reply-usermsg">
                                            <div><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/owneravatar.png" alt=""></div>
                                            <div class="reply-detail">
                                                <p class="reply-username">Wei</p>
                                                <p>回复<span class="reply-name">素缘淡然</span>：<span class="reply-text">我觉得不错啊！值得购买。</span></p>
                                                <div class="review-time">2019-06-24 18:32:55</div>
                                            </div>
                                        </div>
                                    </div>
                                    <hr size="1" width="100%" color="#e8e8ef">--%>
                                    <c:forEach items="${allReplyAndUserInfo}" var="eachReplyInfo">
                                        <%--对每一个id找评论下的回复--%>
                                        <c:if test="${Comments.comment_id==eachReplyInfo.reply_id}">
                                            <div class="reply-li">
                                                <div class="reply-usermsg">
                                                    <div><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/${eachReplyInfo.user_img}" alt=""></div>
                                                    <div class="reply-detail">
                                                        <p class="reply-username">${eachReplyInfo.user_name}</p>
                                                        <p>回复<span class="reply-name">${eachReplyInfo.replyuser_name}</span>：<span class="reply-text">${eachReplyInfo.reply_content}</span></p>
                                                        <div class="review-time">
                                                            <jsp:useBean id="dateValue2" class="java.util.Date"/>

                                                            <jsp:setProperty name="dateValue2" property="time" value="${eachReplyInfo.reply_time*1000}"/>
                                                            <fmt:formatDate value="${dateValue2}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                                                </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <hr size="1" width="100%" color="#e8e8ef">
                                        </c:if>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                        <hr size="2" width="100%" color="#f6f6f6">

                    </c:forEach>

                    <%--sty  --%>
                    <%--<div class="review-detail">
                        <div class="review-usermsg">
                            <div><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/owneravatar.png" alt=""></div>
                            <div class="review-username">
                                <p>素缘淡然</p>
                                <p>未认证</p>
                            </div>
                        </div>
                        <div class="review-text">
                            <p>衣服是棉的，颜色与图片一样，穿上宽松好看。喜欢又价廉物美。现全家需要的吃穿用东西都在唯品会上买的，省时间还可以退换，售后服务也便捷和诚信。</p>
                            <div class="review-texttime">
                                <div class="review-time">2019-06-24 18:32:55</div>
                                <div class="reply-reviewuser" onclick="showreplymsgbox(26)"><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/pinlunqian.png" alt=""></div>
                            </div>
                            <div class="26-reviewbox" hidden>
                                <div class="texta">
                                    <textarea type="text" z-st="comment_input" placeholder="回复素缘淡然..." class="textarea-style commentbig textarea"style="height: 42px; padding-right: 60px; overflow-y: scroll;"></textarea>
                                    <span class="count">2000</span>
                                </div>
                                <div class="clearfix"><button class="replybtn">回复</button></div>
                            </div>
                            <div class="reply-list">
                                <span class="reply-dialog"></span>
                                <div class="reply-li">
                                    <div class="reply-usermsg">
                                        <div><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/owneravatar.png" alt=""></div>
                                        <div class="reply-detail">
                                            <p class="reply-username">Wei</p>
                                            <p>回复<span class="reply-name">素缘淡然</span>：<span class="reply-text">我觉得不错啊！值得购买。</span></p>
                                            <div class="review-time">2019-06-24 18:32:55</div>
                                        </div>
                                    </div>
                                </div>
                                <hr size="1" width="100%" color="#e8e8ef">
                                <div class="reply-li">
                                    <div class="reply-usermsg">
                                        <div><img src="${pageContext.request.contextPath}/static/images/xiaoyuantao/owneravatar.png" alt=""></div>
                                        <div class="reply-detail">
                                            <p class="reply-username">Wei</p>
                                            <p>回复<span class="reply-name">素缘淡然</span>：<span class="reply-text">我觉得不错啊！值得购买。</span></p>
                                            <div class="review-time">2019-06-24 18:32:55</div>
                                        </div>
                                    </div>
                                </div>
                                <hr size="1" width="100%" color="#e8e8ef">
                            </div>
                        </div>
                    </div>
                    <hr size="2" width="100%" color="#f6f6f6">--%>
                    <%--sty  --%>




                </div>
            </div>
            <%--<div class="goodsdetailpaging">
                <ul class="home-paging clearfix">
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">...</a></li>
                    <li><a href="#">&gt;</a></li>
                </ul>
            </div>--%>
            <div class="goods-recommend">
                <div class="review-title">
                    <div>为您推荐</div>
                </div>
                <div class="recommend">
                    <ul class="recommend-list">
                        <c:forEach items="${recommends}" var="recommend">
                            <a href="${pageContext.request.contextPath}/saleGoodsDetaile.action?goods_id=${recommend.goodsId}">
                                <li>
                                    <div><img src="${pageContext.request.contextPath}/uploadfile/${recommend.goodsImg}" alt="商品图片"></div>
                                    <p>${recommend.goodsTitle}</p>
                                    <p>￥${recommend.goodsPrice}</p>
                                </li>
                            </a>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
