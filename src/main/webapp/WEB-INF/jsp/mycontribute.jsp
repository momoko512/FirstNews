<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Auser
  Date: 2018/7/8
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>我的投稿</title>
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
    <ul>
        <c:forEach items="${contributes}" var="contribute">

            <li style="display: -webkit-box;">
                <h2 style="margin-right: 10px"><a href="view${contribute.getId()}.contribute">${contribute.getTitle()}</a></h2>
                <a href="view${contribute.getId()}.delete">删除</a>
            </li>

        </c:forEach>
    </ul>
    </div>
</div>
</body>
</html>
