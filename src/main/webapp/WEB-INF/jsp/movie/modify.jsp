<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/15 0015
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p align="center">编辑电影</p>

<form name="form" action="/movie/${id}/modify">
    <label for="name">电影id:</label>
    <input type="text" value="${id}" name="id" id="id"/><br>
    <label for="name">电影名:</label>
    <input type="text" value="${name}" name="name" id="name"/>
    <input type="submit" value="编辑">
</form>
<<a href="/movie/${id}/delete">删除</a>
${message}
</body>
</html>
