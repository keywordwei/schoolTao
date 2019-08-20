
$(function(){
    //release发布二手下拉框
    $(".select-goods-status").selectmenu({
        change:function(event,ui){
            var status = ui.item.value;
            // console.log(classId);
            if(status != "-1"){
                console.log(ui.item);
                var goods_id = $(".select-goods-status").find("option:selected").attr("goods_id");
                $.ajax({
                    type: "POST",
                    url: "/saleGoodsStatus.action",
                    data: {goods_id: goods_id,goods_status:status},
                    dataType: "json",
                    success: function (json) {
                        // alert(json.goodsValidTime);
                        if(json.goodsStatus==1){
                            $(".goods_status").text("有效");
                        }else if(json.goodsStatus==0){
                            $(".goods_status").text("已过期");
                        }
                    },
                    error: function (e) {
                        console.log(e);
                    }
                });
            }
        }
    });

    $(".select-product-status").selectmenu({
        change:function(event,ui){
            var status = ui.item.value;
            // console.log(classId);
            if(status != "-1"){
                console.log(ui.item);
                var product_id = $(this).find("option:selected").attr("product_id");
                var span = $(this).closest("p").prev().children(".product_status");
                $.ajax({
                    type: "POST",
                    url: "/buyGoodsStatus.action",
                    data: {product_id: product_id,product_status:status},
                    dataType: "json",
                    success: function (json) {
                        // alert(json.productStatus);
                        if(json.productStatus==1){
                           // alert("goodsid:"+product_id+" status:"+status+$(this).parent().prev().last().text())
                            span.text("有效");
                        }else if(json.productStatus==0){
                            span.text("已过期");
                        }
                    },
                    error: function (e) {
                        console.log(e);
                    }
                });
            }
        }
    });

    $("#collection").click(function(){
        // var coll = $("#collection").attr("userid");
        // alert(coll);
        SaleCollection($("#collection").attr("goodsId"),$("#collection").attr("userid"));
    });

    $("#mySaleGoodsbtn").click(function(){
        MySaleGoods($("#myInfosbtn").attr("userid"));
    });
    $("#myBuyGoodsbtn").click(function(){
        MyBuyGoods($("#myInfosbtn").attr("userid"));
    });
    $("#myCollectionbtn").click(function(){
        MySaleCollection($("#myInfosbtn").attr("userid"));
    });

});


function SaleCollection(goods_id,user_id) {
    $.ajax({
        type: "POST",
        url: "/addCollection.action",
        data:{user_id:user_id,goods_id:goods_id},
        dataType: "html",
        success: function(data){
            alert(data);
        },
        // error:function(e){
        //     console.log(e);
        // },
        error : function(XMLHttpRequest, textStatus) {
            // 通过XMLHttpRequest取得响应头，REDIRECT
            var redirect = XMLHttpRequest.getResponseHeader("REDIRECT");//若HEADER中含有REDIRECT说明后端想重定向
            if (redirect == "REDIRECT") {
                var win = window;
                while (win != win.top){
                    win = win.top;
                }
                //将后端重定向的地址取出来,使用win.location.href去实现重定向的要求
                win.location.href= XMLHttpRequest.getResponseHeader("CONTEXTPATH");
            }
        }
    });
}




function delectCollection(collectionId) {
    $.ajax({
        type: "POST",
        url: "/deleteCollection.action",
        data:{collection_id:collectionId},
        dataType: "html",
        success: function(data){
            alert(data);
            if("删除成功！"==data){
                MySaleCollection($("#myInfosbtn").attr("userid"));
            }
        },
        error:function(e){
            console.log(e);
        }

    });
}

function MySaleCollection(userId) {
    $.ajax({
        type: "POST",
        url: "/myCollection.action",
        data:{user_id:userId},
        dataType: "json",
        success: function(json){
            var content = "";
            if (json == null || json == "") {
                $("#myCollection").html('<div class="nothing">' +
                    '<div><img src="./static/images/xiaoyuantao/personal-nothing.png" alt=""></div>' +
                    '<div>你还没有收藏过二手商品</div>\n' +
                    '<div><button class="fourwordbtn" id="go-find">浏览商城</button></div>' +
                    '</div>');
            } else {
                $.each(json,function(index,item){
                    content+='<div class="collectgoodsli clearfix">';
                    content+='<div>';
                    content+='<a href="./saleGoodsDetaile.action?goods_id='+item.goods_id+'">';
                    content+='<img src="./uploadfile/'+item.goods_img[0]+'" alt="">';
                    content+='</a>';
                    content+='</div>';
                    content+='<div>';
                    content+='<div>'+item.goods_title+'</div>';
                    content+='<div>'+item.user_name+'</div>';
                    content+='<div>联系电话：&nbsp;'+item.goods_contact_phone+'</div>';
                    content+='<div><button class="fourwordbtn editcollect" onclick="delectCollection('+item.collection_id+')">取消收藏</button></div>';
                    content+='</div>';
                    content+='</div>';

                });
                $("#myCollection").html(content);
            }
        },
        error:function(e){
            console.log(e);
        }
    });
}
function MyBuyGoods(userId){
    $.ajax({
        type: "POST",
        url: "/myBuyGoods.action",
        data:{user_id:userId},
        dataType: "json",
        success: function(json){
            var content = "";
            if (json == null || json == "") {
                $("#myBuyGoods").html('<div class="nothing">' +
                    '<div><img src="./static/images/xiaoyuantao/personal-nothing.png" alt=""></div>' +
                    '<div>你还没有发布过求购</div>' +
                    '<div><button class="fourwordbtn" id="go-releasebuy">发布求购</button></div>' +
                    '</div>');
            } else {
                content+='<div class="buying-list">';
                content+='<ul class="clearmargin">';
                $.each(json,function(index,item){

                    content+='<li>';
                    content+='<div>';
                    content+='<div><img src="./uploadfile/'+item.user_img+'" alt=""></div>';
                    content+='<div>'+item.user_name+'</div>';
                    content+='</div>';
                    content+='<div class="buying-detail">' ;
                    content+='<p class="buying-title">'+item.product_title+'</p>';
                    content+='<p class="buying-detailmsg">'+item.product_details+'</p>';
                    content+='<p class="buying-price">期望价格：<span class="buying-pricenum">￥'+item.product_price+'</span>&nbsp;&nbsp;&nbsp;&nbsp; 发布时间：'+item.product_publish_time+'</p>';
                    content+='<p>手机：<span>'+item.product_contact_phone+'</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>QQ:'+item.product_contact_qq+'</span></p>';
                    content+='<p>用户认证状态：<span class="buying-authentication">'+(item.user_status==0?"未认证":"已认证")+'</span></p>';
                    content+='</div>';
                    content+='</li>';
                });
                content+='  </ul></div>';
                $("#myBuyGoods").html(content);
            }
        },
        error:function(e){
            console.log(e);
        }
    });
}
function MySaleGoods(userId){
    $.ajax({
        type: "POST",
        url: "/mySaleGoods.action",
        data:{user_id:userId},
        dataType: "json",
        success: function(json){
            var content = "";
            if (json == null || json == "") {
                $("#mySaleGoods").html('<div class="nothing">' +
                    '<div><img src="./static/images/xiaoyuantao/personal-nothing.png" alt=""></div>' +
                    '<div>你还没有发布过商品</div>' +
                    '<div><button class="fourwordbtn" id="go-release">发布商品</button></div>' +
                    '</div>');
            } else {
                // alert(json.list);

                content+='<div class="recommend"><ul class="recommend-list">';
                $.each(json,function(index,item){
                    content+='<a href="./saleGoodsDetaile.action?goods_id='+item.goods_id+'">';
                    content+='<li>';
                    content+='<div><img src="./uploadfile/'+item.goods_img[0]+'" alt=""></div>';
                    content+='<p>'+item.goods_title+'</p>';
                    content+='<p>￥'+item.goods_price+'</p>';
                    content+='</li>';
                    content+='</a>';
                });
                content+='  </ul></div>';
                $("#mySaleGoods").html(content);
            }
        },
        error:function(e){
            console.log(e);
        }
    });
}