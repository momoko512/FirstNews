<%--
  Created by IntelliJ IDEA.
  User: Auser
  Date: 2018/7/10
  Time: 4:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>工作人员通道</title>
    <style>tr{height: 50px;}
    a{font-size: smaller}
    a:link,a:visited{border-bottom: none;color: black;}
    </style>
</head>
<body>
<div style="height: 50px; background-color: firebrick;margin-top: 200px"></div>
<div style="width: 500px; margin: auto; margin-top: 30px">
    <form action="login" method="post">
        <table>
            <tbody>
            <tr><td><label>用户名</label></td><td><input style="height: 30px" name="name" type="text" required/> </td></tr>
            <tr><td><lable>密码</lable></td><td><input style="height: 30px" name="password" type="password" required/></td></tr>
            <tr><td><a href="register">申请工号</a></td><td><input type="submit" style="margin-left: 50px;"></td></tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
