<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/15 0015
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p align="center">添加电影</p>
<form action="/movie/add">
    <label for="name">电影名</label>
    <input type="text" name="name" id="name"/>
    <input type="submit" value="添加">
</form>

<a href="/movie/admind">返回</a>

<p>${message}</p>
</body>
</html>
