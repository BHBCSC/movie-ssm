<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>管理电影</p>
<p><a href="/movie/add">添加电影</a></p>

<table align="center">
    <th>id</th>
    <th>电影名</th>
    <shiro:hasRole name="admin">
        <th>操作</th>
    </shiro:hasRole>

    <c:forEach var="movie" items="${movieList}">
        <tr>
            <td>${movie.movieId}</td>
            <td>${movie.name}</td>
            <shiro:hasRole name="admin">
                <td><a href="/movie/${movie.movieId}/modify">编辑</a> | <a href="/movie/${movie.movieId}/delete">删除</a>
                </td>
            </shiro:hasRole>

        </tr>
    </c:forEach>
</table>

<p align="center">
    <a href="${contextPath}/movie/?page=${1}">首页</a>
    <a href="${contextPath}/movie/?page=${current-1}">前一页</a>
    <c:forEach var="page" begin="1" end="${pages}" step="1">
        <c:choose>
            <c:when test="${page == current}">
                ${page}
            </c:when>
            <c:otherwise>
                <a href="${contextPath}/movie/admin?page=${page}">${page}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <a href="${contextPath}/movie/?page=${current+1}">后一页</a>
    <a href="${contextPath}/movie/?page=${pages}">末页</a>
</p>

</body>
</html>
