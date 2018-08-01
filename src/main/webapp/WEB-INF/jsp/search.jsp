<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: Auser
  Date: 2018/7/2
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>搜索</title>
    <style type="text/css">@import url(/FirstNews/public/css/headcss.css);</style>
</head>
<body>
<!--通用头部-->
<div id="header">

<%@ include file="head.jsp"%>


</div>
<div class="bodymain">
<h1>我在搜索页面哈</h1>
<c:if test="${(news.size()>0)}">
    <ul>
    <c:forEach items="${news}" var="newss">

        <li><a href="view${newss.value.getId()}.news">${newss.value.getTitle()}</a></li>

    </c:forEach>
    </ul>
</c:if>
<c:if test="${!(news.size()>0)}">
    <p>搜索结果不存在，请重新搜索</p>
</c:if>
</div>
</body>
</html>
