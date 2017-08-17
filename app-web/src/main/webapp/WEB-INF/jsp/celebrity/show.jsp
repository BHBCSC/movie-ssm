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
演员名: ${celebrity.name}<br>
岁数: ${celebrity.age}<br>
出演过的电影：<c:forEach var="movie" items="${celebrity.movieList}">
    <a href="${contextPath}/movie/${movie.movieId}">${movie.name}</a>
</c:forEach><br>

</body>
</html>
