<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
hi, ${username}

<a href="/account/logout" style="position:absolute ;right: 0;top: 0">注销登录</a>

<table align="center" border="4">
    <tr>
        <th>名字</th>
        <th>分数</th>
    </tr>
    <c:forEach var="movie" items="${movieList}">
        <tr>
            <td><a href="${contextPath}/movie/${movie.movieId}/">
                    ${movie.name}
            </td>
            <td>${movie.score}</td>
        </tr>
    </c:forEach>
</table>

<p align="center">
    <a href="${contextPath}/search/?text=${text}&page=${1}">首页</a>
    <a href="${contextPath}/search/?text=${text}&page=${current-1}">前一页</a>
    <c:forEach var="page" begin="1" end="${pages}" step="1">
        <c:choose>
            <c:when test="${page == current}">
                ${page}
            </c:when>
            <c:otherwise>
                <a href="${contextPath}/search/?text=${text}&page=${page}">${page}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <a href="${contextPath}/search/?text=${text}&page=${current+1}">后一页</a>
    <a href="${contextPath}/search/?text=${text}&page=${pages}">末页</a>
</p>
</body>
</html>
