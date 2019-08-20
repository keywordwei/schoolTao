$(function(){
    $("#release_form").validate({
        submitHandler: function() {
            form.submit();
        },
        ignore:":hidden:not(select)",
        rules: {
            goods_title: {
                required: true,
                minlength:5
            },
            goods_detail: {
                required: true,
                minlength: 10
            },
            goods_price: {
                required:true,
                digits:true
            },
            goods_category_name: {
                required: true
            },
            goods_contact_phone: {
                required: true,
                digits:true,
                rangelength:[11,11]
            },
            goods_contact_qq: {
                required: true,
                digits:true
            },
            file:{
                required:true
            }

        },
        messages: {
            goods_title: {
                required: "标题不能为空",
                minlength: "标题长度至少是5个字符"
            },
            goods_detail: {
                required: "商品详情不能为空",
                minlength: "商品详情长度至少是10个字符"
            },
            goods_price: {
                required: "价格不能为空",
                digits:"价格必须为数字"
            },
            goods_category_name: {
                required: "必须为商品选择类别"
            },
            goods_contact_phone: {
                required: "电话不能为空",
                digits:"请填数字",
                rangelength:"请填十一位电话号码"
            },
            goods_contact_qq:{
                required:"qq不能为空",
                digits:"请输入数字"
            },
            file:{
                required:"请至少选择一张图片"
            }
        },
        errorPlacement: function(error, element) {
            $("#error").text($("#error").text() + "error value is " + error.text());
            error.insertAfter(element);
        }
        // errorClass:"error",
        // success: function(label) {
        //     //label指向上面那个错误提示信息标签em
        //     label.html("");
        //     label.addClass("success").html("Ok!");  //加上自定义的success类
        // }
    });
});
