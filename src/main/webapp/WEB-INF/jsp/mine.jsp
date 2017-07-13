<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/13 0013
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
hi, ${username}
<table align="center" border="4">
    <tr>
        <th>名字</th>
        <th>分数</th>
        <th>你的评分</th>
        <th>你的评论</th>
        <th>操作</th>
    </tr>

    <c:forEach var="watched" items="${watchedList}">
        <tr>
            <td><a href="${contextPath}/movie/${watched.movie.movieId}/">
                    ${watched.movie.name}
            </a></td>
            <td>${watched.movie.score}</td>
            <td>${watched.score}</td>
            <td>${watched.comment}</td>
            <td><a href="{contextPath}/movie/${watched.movie.movieId}/delete">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
