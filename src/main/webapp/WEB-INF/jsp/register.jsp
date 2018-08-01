<%--
  Created by IntelliJ IDEA.
  User: Auser
  Date: 2018/7/1
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>注册</title>
    <style type="text/css">@import url(/FirstNews/public/css/headcss.css);</style>
    <script type="text/javascript">
        window.onload = function(){
            var oTab = document.getElementById("tabs");
            var oUl = oTab.getElementsByTagName("ul")[0];
            var oLis = oUl.getElementsByTagName("li");
            var oDivs= oTab.getElementsByTagName("div");

            for(var i= 0,len = oLis.length;i<len;i++){
                oLis[i].index = i;
                oLis[i].onclick = function() {
                    for(var n= 0;n<len;n++){
                        oLis[n].className = "";
                        oDivs[n].className = "hide";
                    }
                    this.className = "on";
                    oDivs[this.index].className = "";
                }
            };
        }
    </script>
</head>
<body>
<div id="header">
    <jsp:include page="head.jsp">
    <jsp:param name="text" value="how are you"/>
</jsp:include>
</div>
<div class="bodymain">
<h1>用户注册</h1>
<h2>只是页面不一样，实现的是同一个注册功能，没有具体分类</h2>
<div id="tabs">
    <ul>
        <li class="on">手机注册</li>
        <li>邮箱注册</li>
        <li>短信快捷</li>
    </ul>
    <div>

            <form action="registresult" method="post">
                <table>
                    <tr>
                        <table>
                            <tr>
                                <td>手机</td>
                                <td><input type="tel" name="name" required></td>
                            </tr>
                            <tr>
                                <td>密码</td>
                                <td><input type="password" name="password" required></td>
                            </tr>
                            <tr>
                                <td>确认密码</td>
                                <td><input type="password" name="repassword" required></td>
                            </tr>
                        </table></tr>
                    <tr>
                        <table><tr><th><input type="submit" value="提交"></th></tr></table></tr>
                </table>
            </form>


</div>
    <div class="hide">
        <form action="registresult" method="post">
            <table>
                <tr>
                    <table>
                        <tr>
                            <td>邮箱</td>
                            <td><input type="tel" name="name" required></td>
                        </tr>
                        <tr>
                            <td>密码</td>
                            <td><input type="password" name="password" required></td>
                        </tr>
                        <tr>
                            <td>确认密码</td>
                            <td><input type="password" name="repassword" required></td>
                        </tr>
                    </table></tr>
                <tr>
                    <table><tr><th><input type="submit" value="提交"></th></tr></table></tr>
            </table>
        </form>


    </div>
    <div class="hide">
        <form action="registresult" method="post">
            <table>
                <tr>
                    <table>
                        <tr>
                            <td>没写</td>
                            <td><input type="tel" name="name" required></td>
                        </tr>
                        <tr>
                            <td>密码</td>
                            <td><input type="password" name="password" required></td>
                        </tr>
                        <tr>
                            <td>确认密码</td>
                            <td><input type="password" name="repassword" required></td>
                        </tr>
                    </table></tr>
                <tr>
                    <table><tr><th><input type="submit" value="提交"></th></tr></table></tr>
            </table>
        </form>


    </div>
</div>
</div>
</body>

</html>
