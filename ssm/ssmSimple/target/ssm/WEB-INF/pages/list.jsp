<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/23
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>查找所有</h2>
    <c:forEach items="${accountList}" var="account">
        ${account}<br/>
    </c:forEach>
</body>
</html>
