<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Auser
  Date: 2018/6/29
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>我的投稿${contribute.title}</title>
    <style type="text/css">@import url(/FirstNews/public/css/headcss.css);</style>
</head>
<body>
<div id="header">

    <jsp:include page="head.jsp">
        <jsp:param name="text" value="how are you"/>
    </jsp:include>

</div>
<div class="bodymain">
<div>
    <h3>${contribute.title}</h3>
    <p>${contribute.detail}</p>
<c:if test="${contribute.image!=null}">
    <img src="image" class="bigimage" style="width: 600px;height: 400">
</c:if>
    <a href="view${contribute.getId()}.delete">删除</a>
</div>
</div>
</body>
</html>
