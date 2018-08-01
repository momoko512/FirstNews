<%--
  Created by IntelliJ IDEA.
  User: Auser
  Date: 2018/7/1
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>注册结果</title>
    <style type="text/css">@import url(/FirstNews/public/css/headcss.css);</style>
</head>
<body>
<div id="header">

    <jsp:include page="head.jsp">
        <jsp:param name="text" value="how are you"/>
    </jsp:include>

</div>
<div class="bodymain">
<h1>${user.name}</h1>
</div>
</body>
</html>
