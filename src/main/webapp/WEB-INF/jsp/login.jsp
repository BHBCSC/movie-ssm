<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/13 0013
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
login<br/>
<form action="<%=request.getContextPath()%>/account/dologin" method="post">
        username: <input type="text" name="username"><br/>
        password: <input type="password" name="password"><br/>
        <input type="submit" value="submit">
    </form>
</body>
</html>
