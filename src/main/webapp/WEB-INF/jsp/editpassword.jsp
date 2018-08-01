<%--
  Created by IntelliJ IDEA.
  User: Auser
  Date: 2018/7/9
  Time: 8:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
    <style type="text/css">@import url(/FirstNews/public/css/headcss.css);</style>
</head>
<body>
<!--通用头部-->
<div id="header">

    <jsp:include page="head.jsp">
        <jsp:param name="text" value="how are you"/>
    </jsp:include>

</div>
<!--是否提交表单 有问题-->
<script>
    var form=document.forms['form'];
    var name=Form.elements['name'].value;
    var sename=<%=session.getAttribute("name").toString()%>;
    var password=Form.elements['password'].value;
    var sepass=<%=session.getAttribute("password").toString()%>;
    var newpassword=Form.elements['newpassword'].value;
    var repassword=Form.elements['repassword'].value;
function dodo() {
    <%System.out.println("进入function");%>
    if(name==sename){<%System.out.println("name");%>
        if(password==sepass){<%System.out.println("password");%>
            if(newpassword!=""){<%System.out.println("no null");%>
                if(newpassword==repassword){<%System.out.println("the same");%>;return true;}else {return false;}
            }else {return false;}
        }else {return false;}
    }else{return false;}
};
function momo() {
    <%System.out.println("进入事件");%>
    var name1 = document.getElementById("name").value;
    var name2 =<%=session.getAttribute("name").toString()%>;
    if (name1 !== name2) {<%System.out.println("进入if");%>alert("名字不符");return ;}
        };

</script>
<div class="bodymain">
<form action="submiteditpassword" name="form">
<table>
    <tr>
        <td><label>用户名</label></td>
        <td><input type="text" name="name" id="name" placeholder="用户名" required/></td>
        <td><span class="warn">*</span></td>
    </tr>
    <tr>
        <td><label>密码</label></td>
        <td><input type="password" name="password" placeholder="密码" required/></td>
        <td><span class="warn">*</span></td>
    </tr>
    <tr><td><label>新密码</label></td>
        <td><input type="password" name="newpassword" placeholder="新密码"required/></td>
        <td><span class="warn">*</span></td>
    </tr>
    <tr>
        <td><label>确认密码</label></td>
        <td><input type="password" name="repassword" placeholder="确认密码" required/></td>
        <td><label class="warn">*</label></td>
    </tr>
    <tr>
        <td><input type="submit"/></td>
    </tr>
</table>
</form>
</div>
</body>
</html>
