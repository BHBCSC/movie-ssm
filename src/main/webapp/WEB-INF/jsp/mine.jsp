<%@ page import="com.csc.movie.entity.User" %>
<%@ page import="com.csc.movie.entity.Watched" %><%--
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
<table align="center" border="4">


    <tr>
        <th>name</th>
        <th>score</th>
        <th>your score</th>
        <th>your comment</th>
    </tr>
${watchedList}
    <c:forEach var="watched" items="${watchedList}">
    <tr>
        <td>${watched["movie"].name}</td>
        <td>${watched["movie"].score}</td>
        <td>${watched.score}</td>
        <td>${watched.comment}</td>
    </tr>
    </c:forEach>


</table>
</body>
</html>
