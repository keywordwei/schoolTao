$(function(){
    $("#rememberpwd").click(function() {
        $("input[name=rememberpwd]").parent().removeClass().addClass('auto-login-c');
        $("input[name=rememberpwd]:checked").parent().removeClass().addClass('auto-login-cd');
    });

    $("#registerBtn").bind("click",function () {
        window.location.href = 'register.jsp';
        return;
    })
});

