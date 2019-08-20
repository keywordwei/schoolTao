// document树加载完成后执行
$(function () {

    //点击进入按钮进入首页
    $(".come-btn").click(
        function () {
            window.location.href = "${pageContext.request.contextPath}/saleGoods.action";
        }
    );


    //点击二手进入发现页面
    $(".content").eq(0).click(
        function () {
            window.location.href = "/saleGoods.action";
        }
    );
    //点击转卖进入发布二手页面
    $(".content").eq(1).click(
        function () {
            window.location.href = "/buyGoods.action";
        }
    );



    //home-page-carsousel  轮播图
    var carsousel = $(".home-move").find("li");
    var timer = null;
    var currentIndex = 0; //轮播图片索引数，根据该数，确定轮播的图片，计算图片移动的位置
    var width = carsousel.find("img").eq(0).width();
    //自动轮播
    timer = setInterval(function () {
        nextPlay();
    },1000);
    //鼠标进入轮播图，停止自动轮播
    $(".home-carsousel-main").mouseover(function(){
        timer = clearInterval(timer);
    });
    //鼠标离开轮播图，开始自动轮播
    $(".home-carsousel-main").mouseout(function(){
        timer = setInterval(function () {
            nextPlay();
        },1000)
    });
    //点击home-next图片，显示轮播的下一张图片
    $(".home-next").click(function(){
        nextPlay();
    });
    //点击home-previous图片，显示轮播的上一张图片
    $(".home-previous").click(function(){
        previousPlay();
    });
    //顺序轮播
    function nextPlay(){
        currentIndex++;
        if(currentIndex > carsousel.length - 1){
            $(".home-move").css("left",0);//轮播到最后一张图片，立即定位到第一张图片
            currentIndex = 0;
        }
        $(".home-move").animate({
            "left": -width * currentIndex,
        });
    }
    //倒叙轮播
    function previousPlay(){
        currentIndex--;
        if(currentIndex < 0){
            $(".home-move").css("left",-width * (carsousel.length - 1));//轮播到第一张图片，立即定位到最后一张图片
            currentIndex = carsousel.length - 1;
        }
        $(".home-move").animate({
            "left": -width * currentIndex,
        });
    }
    //home-footer 微信微博改变背景图片
    $(".home-weixin").hover(
        function(){

            $(this).attr("src","${pageContext.request.contextPath}/static/images/xiaoyuantao/weixin.png");
        },
        function(){
            $(this).attr("src","${pageContext.request.contextPath}/static/images/xiaoyuantao/weixin-dark.png");

        }
    );
    $(".home-weibo").hover(
        function(){
            $(this).attr("src","${pageContext.request.contextPath}/static/images/xiaoyuantao/weibo.png");
        },
        function(){
            $(this).attr("src","${pageContext.request.contextPath}/static/images/xiaoyuantao/weibo-dark.png");

        }
    );
    //release发布二手下拉框
    var classMenu = $(".select-postgoods").selectmenu({
        change:function(event,ui){
            var classId = ui.item.value;
            if(classId != "-1"){
                console.log(classId);
            }
        }
    });
    //商品详情点击图片切换图片
    $(".goodsdetailimg li").eq(0).addClass("goodsdetailimg-click").siblings().removeClass("goodsdetailimg-click");
    $(".goodsdetailimg li").click(function(){
        $(".goods-bigimg img").attr("src",$(this).children("img").attr("src"));
        $(this).addClass("goodsdetailimg-click").siblings().removeClass("goodsdetailimg-click");
    });
    //商品放大镜特效
    $(".goods-bigimg").hover(
        function(){
            $(".amplifier").css("display","block");
            $(".amplifier-big-img").css("display","block");
        },
        function(){
            $(".amplifier").css("display","none");
            $(".amplifier-big-img").css("display","none");
        }
    );
    $(".goods-bigimg").mousemove(function(event){
        var paddingLeft = parseInt($(this).css("padding-left"));
        var paddingTop = parseInt($(this).css("padding-top"));
        var paddingRight = parseInt($(this).css("padding-right"));
        var paddingBottom = parseInt($(this).css("padding-bottom"));
        // console.log(typeof(paddingLeft));
        //获取鼠标相对于图片移动的x y距离
        var translateX = event.pageX - $(this).offset().left -  $(".amplifier").width() / 2 - paddingLeft;
        var translateY = event.pageY - $(this).offset().top - paddingTop - $(".amplifier").height() / 2;

        if(translateX < 0){
            translateX = paddingLeft;
        }
        if(translateY < 0){
            translateY = paddingTop;
        }
        if(translateX > $(this).innerWidth() - paddingRight - $(".amplifier").width()){
            translateX = $(this).innerWidth() -paddingRight -  $(".amplifier").width();
        }
        if(translateY > $(this).innerHeight() - paddingBottom  - $(".amplifier").height()){
            translateY = $(this).innerHeight() - paddingBottom - $(".amplifier").height();
        }
        // console.log(translateX);
        $(".amplifier").css({
            "left":translateX + "px",
            "top":translateY + "px"
        });
        $(".amplifier-big-img img").css({
            "left": -translateX * ($(".goods-bigimg").width() / $(".amplifier").width()),
            "top": -translateY * ($(".goods-bigimg").height() / $(".amplifier").height())
        });
    });

    //个人中心导航栏切换显示相应信息
    $(".personal-navigation li:eq(0) a").addClass("personal-navclick");
    $(".personal-navigation li a").click(function(){
        $(this).addClass("personal-navclick").parent("li").siblings().children("a").removeClass("personal-navclick");
        // console.log($(this).parent("li").index());
        $(".nav-msgview>div").eq($(this).parent("li").index()).css("display","block").siblings().css("display","none");
        return false;
    });
    function isEmail(str) {
        var re = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
        if (re.test(str) != true) {
            return false;
        } else {
            return true;
        }
    }
    //修改个人资料和联系方式界面切换样式
    $("#changebasemsg").click(
        function () {
            if($(this).text() === "修改"){
                $(this).text("保存");
                $.post("/edit.action",function (date) {
                    $("#user_anme_input").val(date.userName);
                    $("#user_phonenumber_input").val(date.userPhonenumber);
                    $("#user_email_input").val(date.userEmail);
                    $("#user_signatrue_input").val(date.userSignature);
                    $("#user_adress_input").val(date.userAdress);
                },"json");
            }else{
                var user_name = $("#user_anme_input").val();
                var user_phonenumber = $("#user_phonenumber_input").val();
                var user_email = $("#user_email_input").val();
                var user_signatrue = $("#user_signatrue_input").val();
                var user_adress = $("#user_adress_input").val();
                if (user_phonenumber.length != 11) {
                    document.getElementById("error_box").innerHTML = "请填十一位电话号码";
                    return;
                } else for (var i = 0; i < user_phonenumber.charCodeAt(i); i++) {
                    if ((user_phonenumber.charCodeAt(i) < 48) || (user_phonenumber.charCodeAt(i) > 57)) {
                        document.getElementById("error_box").innerHTML = "必须为数字";
                        return;
                    }
                }
                if (!isEmail(user_email)) {
                    document.getElementById("error_box").innerHTML = "请输入正确的邮箱";
                    return;
                }
                if (user_name.length > 20 || user_name.length < 6) {
                    document.getElementById("error_box").innerHTML = "用户名请输入6-20位字符";
                    return;
                } else if (user_name.charCodeAt(0) > 48 && user_name.charCodeAt(0) <= 57) {
                    document.getElementById("error_box").innerHTML = "首字符必须为字母";
                    return;
                } else for (var i = 0; i < user_name.charCodeAt(i); i++) {
                    if ((user_name.charCodeAt(i) < 48) || (user_name.charCodeAt(i) > 57) && (user_name.charCodeAt(i) < 97) || (user_name.charCodeAt(i) > 122)) {
                        document.getElementById("error_box").innerHTML = "必须为字母跟数字组成";
                        return;
                    }
                }
                $("#user_anme").text(user_name);
                $.post("/updatebasemsg.action",{"user_name":user_name,
                    "user_phonenumber":user_phonenumber,
                    "user_email":user_email,
                    "user_signatrue":user_signatrue,
                    "user_adress":user_adress
                },function () {
                    $("#user_name").text(user_name);
                    $("#user_email").text(user_email);
                    $("#user_phonenumber").text(user_phonenumber);
                    $("#user_signature").text(user_signatrue);
                    $("#user_adress").text(user_adress);
                    $("#user_imagename").text(user_name);
                    $("#error_box").text("");
                });
                $(this).text("修改");
            }
            $(this).parents(".basemsg").children("div:not(.basemsg-title)").children("div:nth-of-type(2)").toggle();
            $(this).parents(".basemsg").children("div:not(.basemsg-title)").children("div:nth-of-type(3)").toggle();
        }
    );

    $("#changecontactways").click(
        function () {
            if($(this).text() === "修改"){
                $.post("/edit.action",function (date) {
                    $("#user_qq_input").val(date.userQq);
                    $("#user_weixin_input").val(date.userWeixin);
                },"json");
                $(this).text("保存");
            }else{
                var user_weixin = $("#user_weixin_input").val();
                var user_qq = $("#user_qq_input").val();
                for (var i = 0; i < user_qq.charCodeAt(i); i++) {
                    if ((user_qq.charCodeAt(i) < 48) || (user_qq.charCodeAt(i) > 57)) {
                        document.getElementById("error_contact").innerHTML = "qq必须为数字";
                        return;
                    }
                }
                $.post("/updatecontact.action",{"user_qq":user_qq,
                    "user_weixin":user_weixin
                },function () {
                    $("#user_qq").text(user_qq)
                    $("#user_weixin").text(user_weixin);
                });
                $(this).text("修改");
            }
            $(this).parents(".basemsg").children("div:not(.basemsg-title)").children("div:nth-of-type(2)").toggle();
            $(this).parents(".basemsg").children("div:not(.basemsg-title)").children("div:nth-of-type(3)").toggle();
        }
    );
    $(".change-personalavatar").change(
        function() {
            $(".pc-avatar img").attr("src", URL.createObjectURL($(this)[0].files[0]));

            /**/
            $("#changeImg").attr("src",URL.createObjectURL($(this)[0].files[0]));
            var user_name = $("#user_anme_input").val();
            $("#changename").innerHTML = (user_name);
            /**/

            var file = document.getElementById("file").files[0];
            /*alert(file.name);
            alert(file.size);*/
            var reader = new FileReader();
            var step = 1024 * 1024;
            var total = file.size;
            var cuLoaded = 0;
            // 读取一段成功
            reader.onload = function(e) {
                // 处理读取的结果
                var loaded = e.loaded;
                // 将分段数据上传到服务器
                uploadFile(reader.result, cuLoaded, function() {
                    console.info('loaded:' + cuLoaded + 'current:' + loaded);
                    // 如果没有读完，继续
                    cuLoaded += loaded;
                    if (cuLoaded < total) {
                        readBlob(cuLoaded);
                    } else {
                        cuLoaded = total;
                    }
                });
            }
            // 指定开始位置，分块读取文件
            function readBlob(start) {
                // 指定开始位置和结束位置读取文件
                // console.info('start:' + start);
                var blob = file.slice(start, start + step);
                reader.readAsArrayBuffer(blob);
            }
            // 开始读取
            readBlob(0);
            // 关键代码上传到服务器
            function uploadFile(result, startIndex, onSuccess) {
                var blob = new Blob([ result ]);
                // 提交到服务器
                var fd = new FormData();
                fd.append('file', blob);
                fd.append('filename', file.name);
                fd.append('loaded', startIndex);
                var xhr = new XMLHttpRequest();
                xhr.open('post', '/saveimage.action',
                    true);
                xhr.onreadystatechange = function() {
                    if (xhr.readyState == 4 && xhr.status == 200) {

                        console.info(xhr.responseText);
                        if (onSuccess)
                            onSuccess();
                    }
                }
                // 开始发送
                xhr.send(fd);
            }
        }
    );
    //发布/求购/收藏为空时进入相应页面
    $(document).on('click','#go-find',function () {
        window.location.href = "/saleGoods.action";
    });
    $(document).on('click','#go-releasebuy',function () {
        window.location.href = "/pages/releasebuy.jsp";
    });
    $(document).on('click','#go-release',function () {
        window.location.href = "/pages/release.jsp";
    });
});
//回复框的显示和隐藏
function showreplymsgbox(id) {
    $("." + id + "-reviewbox").toggle(
        function () {
            // $(".reply-reviewuser img").attr("src","images/pinlun.png");
            $("this").show();
        },
        function () {
            // $(".reply-reviewuser img").attr("src","images/pinlunqian.png");
            $("this").hide();
        }
    );
}