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
    <script src="${contextPath}/resources/js/jquery-3.2.1.min.js"></script>
    <script src="${contextPath}/resources/js/submit-check.js"></script>
</head>
<body>
login<br/>
<form action="${contextPath}/account/dologin" method="post">
        username: <input type="text" name="username"><br/>
        password: <input type="password" name="password"><br/>
    <input id="submit" type="submit" value="submit">
    </form>
</body>
</html>
