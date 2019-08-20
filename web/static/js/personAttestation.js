$(document).ready(function () {
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



    $("#changePersonalInfoBtn").bind("click",function () {
        /*identityUsername identityNumber identitySchool*/
        var stuIdentity = $("#identityNumber").val();
        if(stuIdentity == null||stuIdentity == ""){
            /*$('<div>').appendTo('body').addClass('alert alert-warning').html('请输入真实姓名').show().delay(5000).fadeOut();*/
            alert("请输入姓名");
            return;
        }
        var stuName = $("#identityUsername").val();
        if(stuName == null||stuName == ""){
            /*$('<div>').appendTo('body').addClass('alert alert-warning').html('请输入证件号').show().delay(5000).fadeOut();*/
            alert("请输入证件号");
            return;
        }
        var stuSchool = $("#identitySchool").val();
        if(stuSchool == null||stuSchool == ""){
            /*$('<div>').appendTo('body').addClass('alert alert-warning').html('请输入学校名称').show().delay(5000).fadeOut();*/
            alert("请输入学校");
            return;
        }

        $.ajax({
            type: "POST",
            url: "/personIdentity.action",
            data: {
                stuIdentity: stuIdentity,
                stuName: stuName,
                stuSchool: stuSchool,
            },
            dataType: "json",
            success: function (json) {
                if(json == null||json == "" ){
                    /***
                     * 说明没有改学生，
                     */
                    $('<div>').appendTo('body').addClass('alert alert-danger').html('认证失败，请检查用户信息').show().delay(5000).fadeOut();
                    return;
                }else{
                    /*****
                     * 认证成功
                     */
                    /*$('<div>').appendTo('body').addClass('alert alert-success').html('认证成功，恭喜您成为校园淘的一员').show().delay(5000).fadeOut();*/

                    /***
                     * 修改界面以后不再显示用户认证
                     */

                    $("#identityInfoMessage").html("<span>认证成功！欢迎加入校园淘，更多精彩福利等你来哟！</span>");
                }
            },
            error:function(e){
                console.log(e);
            }
        });

    });
})