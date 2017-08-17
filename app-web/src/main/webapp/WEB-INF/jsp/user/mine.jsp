<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/13 0013
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>欢迎, <shiro:principal/></p>
<div style="position:absolute ;right: 0;top: 0">
    <a href="${pageContext.request.contextPath}/account/setting">我的设定</a>
    <a href="${pageContext.request.contextPath}/account/logout">注销登录</a>
</div>


<form style="text-align: center" action="${pageContext.request.contextPath}/search" method="get">
    <input type="text" name="text">
    <button type="submit">搜索</button>
</form>

<table align="center" border="4">
    <tr>
        <th>名字</th>
        <th>分数</th>
        <th>你的评分</th>
        <th>你的评论</th>
    </tr>

    <c:forEach var="watched" items="${watchedList}">
        <tr>
            <td><a href="${contextPath}/movie/${watched.movie.movieId}/">
                    ${watched.movie.name}
            </a></td>
            <td>${watched.movie.score}</td>
            <td>${watched.score}</td>
            <td>${watched.comment}</td>
        </tr>
    </c:forEach>
</table>
</body>
<p>
    管理员操作：
    <shiro:hasRole name="admin">
        <a href="/movie/">电影管理</a>
    </shiro:hasRole>
</p>
</html>
