<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Auser
  Date: 2018/7/10
  Time: 5:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FirstNews${contribute.title}</title>
</head>
<body>
<div>
    <h3>${contribute.title}</h3>
    <p>auther ${contribute.name}</p><br>
    <p>${contribute.detail}</p>
    <c:if test="${contribute.image!=null}">
        <img src="image" class="bigimage" style="width: 600px;height: 400px">
    </c:if>
    <form action="submitreview" method="post">
        <input type="text" value="${contribute.id}" name="id" style="display: none">
        <input type="hidden" name="hide" value="0">
        <input type="submit" name="nopass" value="不通过">
    </form>
    <form action="submitreview" method="post">
        <input type="hidden" value="${contribute.id}" name="id" style="display: none">
        <input type="hidden" name="hide" value="1">
        <input type="submit" name="pass" value="通过">
    </form>

</div>


</body>
</html>
