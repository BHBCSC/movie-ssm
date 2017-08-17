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
    <title>register</title>
    <script src="${contextPath}/resources/js/jquery-3.2.1.min.js"></script>
    <script src="${contextPath}/resources/js/submit-check.js"></script>
    <script src="${contextPath}/resources/js/blur-empty-check.js"></script>
    <script src="${contextPath}/resources/js/blur-username-check.js"></script>
</head>
<body>
reg<br/>
<form tyle="text-align: center" action="${contextPath}/account/doreg" method="post">
    <p>username: <input type="text" name="username" id="username"><span id="username-span"></span></p>
    <p>password: <input type="password" name="password" id="password"><span id="password-span"></span></p>
    <p><input id="submit" type="submit" value="submit">
    </form>
</body>
</html>
