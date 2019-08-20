$(document).ready(function () {

    /*转化后台的时间戳为日期*/
    function format(shijianchuo)
    {
        //shijianchuo是整数，否则要parseInt转换
        var time = new Date(shijianchuo*1000);
        var y = time.getFullYear();
        var m = time.getMonth()+1;
        var d = time.getDate();
        var h = time.getHours();
        var mm = time.getMinutes();
        var s = time.getSeconds();
        return y+'-'+add0(m)+'-'+add0(d)+' '+add0(h)+':'+add0(mm)+':'+add0(s);
    }
    function add0(m){return m<10?'0'+m:m }


    /**
     * 弹出式提示框，默认1.2秒自动消失
     * @param message 提示信息
     * @param style 提示样式，有alert-success、alert-danger、alert-warning、alert-info
     * @param time 消失时间
     */
    var prompt = function (message, style, time)
    {
        style = (style === undefined) ? 'alert-success' : style;
        time = (time === undefined) ? 1200 : time;
        $('<div>')
            .appendTo('body')
            .addClass('alert ' + style)
            .html(message)
            .show()
            .delay(time)
            .fadeOut();
    };

// 成功提示
    var success_prompt = function(message, time)
    {
        prompt(message, 'alert-success', time);
    };

// 失败提示
    var fail_prompt = function(message, time)
    {
        prompt(message, 'alert-danger', time);
    };

// 提醒
    var warning_prompt = function(message, time)
    {
        prompt(message, 'alert-warning', time);
    };

// 信息提示
    var info_prompt = function(message, time)
    {
        prompt(message, 'alert-info', time);
    };


    /***
     * 焦点事件，判断哪个被选中了
     */
    var category = 1;
    $("#find").on("click",function () {
        category = 1;
    });


    $("#qiugou").on("click",function () {
        category = 2;
    })



    /***
     * 验证邮箱
     */
    function isEmail(str){
        var re=/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
        if (re.test(str) != true) {
            return false;
        }else{
            return true;
        }
    }




    /***
     * 登陆注册判断
     * */

    /***
     * 登陆
     * */
    $("#unloginbtn").bind("click",function () {
        var username = $("#username").val();
        var password = $("#password").val();

        if(username.length > 20 || username.length < 3){
            document.getElementById("error_box").innerHTML = "用户名请输入3-20位字符";
            return;
        }
        if(username.charCodeAt(0)>48 && username.charCodeAt(0) <=57){
            document.getElementById("error_box").innerHTML = "首字符必须为字母";
            return;
        }/*else for(var i=0;i<username.charCodeAt(i);i++) {
            if ((username.charCodeAt(i) < 48) || (username.charCodeAt(i) > 57) && (username.charCodeAt(i) < 97) || (username.charCodeAt(i) > 122)) {
                document.getElementById("error_box").innerHTML = "密码不正确";
                return;
            }
        }*/
        if (!(password.length > 20 || password.length < 6)) {
            $.getJSON("/login.action",{username: username,password: password},function (json) {
                if (json == null || json == "") {
                    document.getElementById("error_box").innerHTML = "用户名或者密码不匹配"
                } else {
                    $('<div>').appendTo('body').addClass('alert alert-success').html('登录成功').show().delay(5000).fadeOut();
                    location.href="/saleGoods.action";
                }
            });

        } else {
            document.getElementById("error_box").innerHTML = "密码请输入6-20位字符"
            return;
        }
    });
    /***
     * 注册
     * */

    $("#unregisterbtn").bind("click",function () {
        var username = $("#username").val();
        var email = $("#email").val();
        //var password = $("#password").val();
        var password = document.getElementById("password").value;
        //var confirmPwd = $("#password").val();
        var confirmPwd = document.getElementById("confirm-password").value;

        if(username.length > 20 || username.length < 3){
            document.getElementById("error_box").innerHTML = "用户名请输入3-20位字符";
            return;
        }
        if(username.charCodeAt(0)>48 && username.charCodeAt(0) <=57){
            document.getElementById("error_box").innerHTML = "首字符必须为字母";
            return;
        }/*else for(var i=0;i<username.charCodeAt(i);i++) {
            if ((username.charCodeAt(i) < 48) || (username.charCodeAt(i) > 57) && (username.charCodeAt(i) < 97) || (username.charCodeAt(i) > 122)) {
                document.getElementById("error_box").innerHTML = "密码必须为字母跟数字组成";
                return;
            }
        }*/
        if(!isEmail(email)){
            document.getElementById("error_box").innerHTML = "请输入正确的邮箱";
            return;
        }

        /**
         * 密码*/
        if (password.length > 20 || password.length < 6) {
            document.getElementById("error_box").innerHTML = "密码请输入6-20位字符";
        }else if(password!=confirmPwd) {
            document.getElementById("error_box").innerHTML = "两次密码不一致";
        }else {
            $.ajax({
                type: "POST",
                url: "/register.action",
                data: {username: username,password: password,email:email},
                dataType: "json",
                success: function(json){
                    if (!json) {
                        document.getElementById("error_box").innerHTML = "当前用户名已被注册"
                    } else {
                        $('<div>').appendTo('body').addClass('alert alert-success').html('注册成功，请登陆').show().delay(5000).fadeOut();
                        window.location.href = 'login.jsp';
                    }
                },
                error:function(e){
                    console.log(e);
                }
            });
        }
    });


    /***
     * 搜索按钮
     */
    $(".home-searchbtn").bind("click",function () {

        var searchContent = $(".home-searchinput").val();
        location.href="/search.action?method=post&searchContent="+searchContent+"&category="+category;
        /*$.ajax({
            type: "POST",
            url: "/search.action",
            async : false,
            data: {searchContent: searchContent,category:category},

        });*/
    });


    $(".home-login").bind("click",function () {
        window.location.href = './pages/login.jsp';
    }) ;


    $(".home-register").bind("click",function () {
        window.location.href = './pages/register.jsp';
    }) ;
})


