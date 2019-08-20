$(function(){
    $("#releasebuy_form").validate({
        submitHandler: function() {
            form.submit();
        },
        ignore:":hidden:not(select)",
        rules: {
            product_title: {
                required: true,
                minlength:5
            },
            product_details: {
                required: true,
                minlength: 10
            },
            product_price: {
                required:true,
                digits:true
            },
            product_category_name: {
                required: true,
            },
            product_contact_phone: {
                required: true,
                digits:true,
                rangelength:[11,11]
            },
            product_contact_qq: {
                required: true,
                digits:true
            }
        },
        messages: {
            product_title: {
                required: "标题不能为空",
                minlength: "标题长度至少是5个字符"
            },
            product_details: {
                required: "商品详情不能为空",
                minlength: "商品详情长度至少是10个字符"
            },
            product_price: {
                required: "价格不能为空",
                digits:"价格必须为数字"
            },
            product_category_name: {
                required: "必须为商品选择类别"
            },
            product_contact_phone: {
                required: "电话不能为空",
                digits:"请填数字",
                rangelength:"请填十一位电话号码"
            },
            product_contact_qq:{
                required:"qq不能为空",
                digits:"请输入数字"
            }
        },
        errorClass:"error",
    });
});
