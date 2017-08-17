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
movie ${movie.name}'s celebrities
<table align="center" border="4">
    <tr>
        <th>演员名字</th>
        <th>岁数</th>
        <%--<th>操作</th>--%>
    </tr>

    <c:forEach var="celebrity" items="${movie.celebrityList}">
        <tr>
            <td><a href="${contextPath}/celebrity/${celebrity.celebrityId}">
                    ${celebrity.name}
            </a></td>
            <td>${celebrity.age}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
