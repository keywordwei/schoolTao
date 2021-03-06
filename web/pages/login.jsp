<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/jquery-ui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login-style.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.0.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery-ui.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/login-js.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/my.js"></script>

</head>
<body>
    <div class="head">
        <img src="${pageContext.request.contextPath}/static/images/login/logo.png">
    </div>
    <div class="login">
        <div class="l-static">
            <div class="static-module-covers">
                <div class="pass-login-covers">
                    <div id="addBox" style="display:none;">登陆成功</div>
                    <div id="error_box"></div>
                    <div class="user">
                        <input class="text-style ipt-default-current" type="text" placeholder="请输入用户名" name="username" id="username">
                    </div>
                    <div class="pwd">
                        <input class="text-style ipt-default-current" type="password" placeholder="请输入密码" name="password" id="password">
                    </div>
                    <div class="login-btn">
                        <input type="button" id="unloginbtn" class="btn-current-big btn-disabled" value="登录">
                        <!-- 输入用户名和密码后显示该按钮 -->
                        <input type="button" id="loginbtn" class="btn-current-big btn-default-main loadding-btn hide" value="登录中...">
                    </div>
                    <div class="auto-login">
                        <label class="auto-login-c">
                            <input type="checkbox" checked="" name="rememberpwd" id="rememberpwd" class="auto-login-cd">记住密码
                        </label>
                        <div class="login-links">
                            <a href="#" target="_blank" class="a-auto">忘记密码</a>
                            &nbsp; | &nbsp;
                            <a target="_blank" class="a-auto" id="registerBtn">注册</a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="third-login-box">
                <p class="third-account">第三方账号登录</p>
                <div class="account-login">
                    <a href="#" class="wechat-login"></a>
                    <a href="#" class="weibo-login"></a>
                    <a href="#" class="qq-login"></a>
                </div>
            </div>
        </div>
    </div>
    <div class="footer">
        <div class="footer-wrapper">
            <div class="footer-content">
                <div id="line1">
                    <ul>
                        <li class="line-head"><a href="#">联系我们</a></li>
                        <li class="line"><a href="#">QQ群:290338403</a></li>
                        <li class="line"><a href="#">电话:17740812047</a></li>
                        <li class="line"><a href="#">地址：四川师范大学成龙校区</a></li>
                    </ul>
                </div>
                <div id="line2">
                    <ul>
                        <li class="line-head"><a href="#">关于我们</a></li>
                        <li class="line"><a href="#">我们的项目</a></li>
                        <li class="line"><a href="#">我们的团队</a></li>
                        <li class="line"><a href="#">企业协议</a></li>
                    </ul>
                </div>
                <div id="line3">
                    <ul>
                        <li class="line-head"><a href="#">问题</a></li>
                        <li class="line"><a href="#">热线电话:020 - 29075715</a></li>
                        <li class="line"><a href="#">反馈</a></li>
                        <li class="line"><a href="#">用户协议</a></li>
                    </ul>
                </div>
                <div id="line4">
                    <ul>
                        <li><a href="#" id="weichat"></a></li>
                        <li><a href="#" id="weibo"></a></li>
                    </ul>
                </div>
                <div class="separator"></div>
                <div class="copyright">
                    <p>Copyright © 2019-2020 校园淘</p>
                </div>
            </div>
        </div>
    </div>
    
</body>
</html>