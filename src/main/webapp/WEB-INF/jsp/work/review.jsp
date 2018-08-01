<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Auser
  Date: 2018/7/10
  Time: 4:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>审核</title>
</head>
<body>
<div>

    <ul>

        <c:forEach items="${contributes}" var="contribute">

            <li><h2><a href="review${contribute.getId()}.review">${contribute.getTitle()}</a></h2></li>

        </c:forEach>

    </ul>
</div>

</body>
</html>
