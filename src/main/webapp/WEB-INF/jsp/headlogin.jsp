<%--
  Created by IntelliJ IDEA.
  User: Auser
  Date: 2018/8/17
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>


<div class="a">
    <div>
        <a class="c" id="c1" onmousemove="bplay1()"
           onmouseout="bnone1()"><%=request.getSession().getAttribute("name")%>
        </a>
    </div>
    <div class="b" id="b1" onmousemove="bplay1()" onmouseout="bnone1()">
        <a class="editherf" href="edit">投稿</a><br>
        <a href="mycontribute">我的投稿</a><br>
        <a href="editpassword">修改密码</a><br>
        <input type="submit" name="submit" value="退出登录" onclick="exit()"/>
    </div>
</div>
