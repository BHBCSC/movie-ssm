/**
 * Created by Administrator on 2017/7/23 0023.
 */
$(function () {
    $("#username").blur(function () {
        var username = $("#username").val();
        if (username == null || $.trim(username) == "") {
            $("#username-span").html("用户名不能为空").css({color: 'red'});
        }
    });

    $("#password").blur(function () {
        var password = $("#password").val();
        if (password == null || $.trim(password) == "")
            $("#password-span").html("密码不能为空").css({color: 'red'});
    });
});