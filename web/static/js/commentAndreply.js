$(document).ready(function () {


    /*var datetime = format(1561607282);
    alert(datetime);*/
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


    /*function date22(shijianchuo)
    {
        var date1 = new Date(shijianchuo);
        var date2=date1.toLocaleDateString().replace(/\//g, "-") + " " + date1.toTimeString().substr(0, 8);
        return date2;
    }*/



    /***
     * 评论回复判断
     * */
    $(".reviewbtn").on("click",function () {
        /*获取评论的内容*/
        var comment_content = $("#textareaInput").val();
        if(comment_content==null||comment_content==""){
            alert("请输入评论内容");
            return;
        }else{
            /*获取点商品id*/
            var product_id = $(".goods-show").attr("goodsId");
            /*获取商品种类*/
            var product_category = $(".goods-show").attr("goodsCategory");
            /*用户登陆名*/
            var username = $("#loginUser").attr("loginUser");
            /***
             *后续判断是否登陆
             *
             */
            if (username == null ||username == ""|| username == undefined) {
                alert("请登录后再评论");
                return;
            }


            /*str为评论后显示的内容*/
            var str = "";

            $.ajax({
                type: "POST",
                url: "/release_Comment.action",
                data: {username: username,product_id:product_id,comment_content:comment_content,product_category:product_category},
                dataType: "json",
                success: function (json) {
                    if (json == null || json == "") {
                        alert("发布评论失败");
                    } else {
                        //    将评论粘贴在后面
                        var datetime = format(json.comment_time);
                        str = "<div class=\"review-detail\">" +
                            "                        <div class=\"review-usermsg\">" +
                            "                            <div><img src=\"/uploadfile/" +json.user_img+"\"></div>" +
                            "                            <div class=\"review-username\">" +
                            "                                <p>" + json.user_name +"</p>" +
                            "                                <p>"+(json.user_status==1 ? "已认证":"未认证")+"</p>" +
                            "                            </div>" +
                            "                        </div>" +
                            "                        <div class=\"review-text\">" +
                            "                            <p>"+json.comment_content+"</p>" +
                            "                            <div class=\"review-texttime\">" +
                            "                                <div class=\"review-time\">"+datetime+"</div>" +
                            "                                   <div class=\"reply-reviewuser\" onclick=\"showreplymsgbox("+json.comment_id+")\"><img src=\"/static/images/xiaoyuantao/pinlunqian.png\" alt=\"\"></div>" +
                            "                            </div>" +
                            "                            <div class=\""+json.comment_id+"-reviewbox\" hidden>" +
                            "                                <div class=\"texta\">" +
                            "                                    <textarea type=\"text\" z-st=\"comment_input\" placeholder=\"回复素缘淡然...\" class=\"textarea-style commentbig textarea\"style=\"height: 42px; padding-right: 60px; overflow-y: scroll;\"></textarea>" +
                            "                                    <span class=\"count\">2000</span>" +
                            "                                </div>" +
                            "                                <div class=\"clearfix\"><button class=\"replybtn\">回复</button></div>" +
                            "                            </div>" +
                            "                           <div class=\"reply-list\">\n" +
                            "                                <span class=\"reply-dialog\"></span>" +
                            "                           </div>" +
                            "                        </div>" +
                            "                    </div>" +
                            "                    <hr size=\"2\" width=\"100%\" color=\"#f6f6f6\">";
                        document.getElementById("review-list").innerHTML += str;
                    }
                },
                error: function (e) {
                    console.log(e);
                }
            });
        }
    });


    /***
     * 回复事件，给每一个标签绑定点击事件
     */

    $(".replybtn").on("click",function () {
        /*获取评论的id,这就是回复的id,根据此id可以找到*/
        var whichcommentid = $(this).parent().parent().attr("class");
        var commentidClassAttr = whichcommentid.toString();
        /***
         * 截取出此条评论的Id*/
        var tempCommentid = commentidClassAttr.split("-");
        var commentId = tempCommentid[0];
       /* alert(commentId);*/

        /***
         * 获取回复内容*/
        /*模拟的用户登陆名*/
        /*var username = "stystysty";*/
        /*用户登陆名*/
        var username = $("#loginUser").attr("loginUser");
        /***
         *后续判断是否登陆
         *
         */
        if (username == null ||username == ""|| username == undefined) {
            alert("请登录后再评论");
            return;
        }


         /*str为评论后显示的内容*/
        var str = "";

        /***
         * 获取回复内容
         * @type {*|jQuery}
         */
        var replyContent = $(this).parent().prev().children("textarea").val();
        /*alert(replyContent);*/
        var appendObj = $(this).parent().parent().next();
        /*获取回复内容*/
        $.ajax({
            type: "POST",
            url: "/reply.action",
            data: {commentId: commentId,username:username,replyContent:replyContent},
            dataType: "json",
            success: function (json) {
                var shijianchuo = json.reply_time;
                var date =format(shijianchuo);
                /*alert(date);*/
                str = "<div class=\"reply-li\">" +
                    "<div class=\"reply-usermsg\">" +
                    "<div><img src=\"/static/images/xiaoyuantao/"+json.user_img+"\" alt=\"\"></div>" +
                    "<div class=\"reply-detail\">" +
                    "<p class=\"reply-username\">"+json.user_name+"</p>" +
                    "<p>回复<span class=\"reply-name\">"+json.replyuser_name+"</span>：<span class=\"reply-text\">"+json.reply_content+"</span></p>" +
                    "<div class=\"review-time\">"+date+"</div>" +
                    "</div>" +
                    "</div>" +
                    "</div>" +
                    "<hr size=\"1\" width=\"100%\" color=\"#e8e8ef\">";
                    appendObj.append(str);
            },
            error: function (e) {
                console.log(e);
            }
        });
    });


})