/**
 * Created by Administrator on 2017/7/25 0025.
 */
$(function () {
    $("#username").blur(function () {
        var username = $("#username").val();
        if (username != null && $.trim(username) != "") {
            $("#username-span").text("检测用户名是否可用...");
            var url = "/account/checkUserName";
            var arg = {"username": username};
            $.ajax({
                type: "POST",
                url: url,
                data: arg,
                dataType: "json",
                success: function (data) {
                    if ($.isEmptyObject(data))
                        $("#username-span").text("用户名可用").css({color: 'green'});
                    else
                        $("#username-span").text("用户名已被注册").css({color: 'red'});
                },
                error: function () {
                    alert("error!!!")
                }
            });
        }
    });
});


