<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/11 0011
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
name is : ${movie.name}<br>
score is : ${movie.score}<br>
<c:choose>
    <c:when test="${not empty watched}">
        <form action="${contextPath}/movie/${movie.movieId}/watched" method="post">
            分数：<input type="text" name="score" value="${watched.score}"><br>
            评价：<input type="text" name="comment" value="${watched.comment}"><br>
            <input type="submit" value="提交修改">
        </form>
        <a href="${contextPath}/movie/${movie.movieId}/delete">没看过</a>
    </c:when>

    <c:otherwise>
        <form action="${contextPath}/movie/${movie.movieId}/watched" method="post">
            分数：<input type="text" name="score"><br>
            评价：<input type="text" name="comment"><br>
            <input type="submit" value="看过">
        </form>
    </c:otherwise>
</c:choose>
</body>
</html>
