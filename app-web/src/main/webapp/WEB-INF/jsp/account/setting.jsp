<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form tyle="text-align: center" action="${contextPath}/account/doupload" method="post" enctype="multipart/form-data">
    头像： <input type="file" name="file"><br/>
    <input id="submit" type="submit" value="submit">
</form>
</body>
</html>
