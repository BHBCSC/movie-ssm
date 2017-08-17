<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/13 0013
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" href="/resources/css/login.css">

    <script src="${contextPath}/resources/js/jquery-3.2.1.min.js"></script>
    <script src="${contextPath}/resources/js/submit-check.js"></script>
    <script src="${contextPath}/resources/js/blur-empty-check.js"></script>

</head>
<body>

<div class="main_box">
    <div class="login_box">
        <div class="login_form">
            <form action="/account/login" method="post">
                <label for="username">用户名:</label>
                <input class="form-control" type="text" name="username" id="username" autofocus>
                <span id="username-span"></span>
                <label for="password"> 密码:</label>
                <input class="form-control" type="password" name="password" id="password">
                <span id="password-span"></span>
                <label for="isRemember">下次自动登录</label>
                <input id="isRemember" type="checkbox" name="isRemember">
                <input id="submit" type="submit" value="登录">
                <p>${error}</p>
            </form>
        </div>
    </div>
</div>
</body>
</html>
