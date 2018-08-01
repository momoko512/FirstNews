<%--
  Created by IntelliJ IDEA.
  User: Auser
  Date: 2018/7/4
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>编辑</title>
    <style type="text/css">@import url(/FirstNews/public/css/headcss.css);</style>
    <style type="text/css">@import url(/FirstNews/public/css/contribute.css);</style>
</head>
<body>
<script>
    function searchTrim(s) {
        return s.replace(/(^\s*)|(\s*$)/g, "");
    }

    function editsubmit() {
        var editdetail = document.getElementById("detail").value;
        var editfile = document.getElementById("file").value;
        if (searchTrim(editdetail) === "" && editfile === "") {
            alert("请编辑内容");
            return false;
        } else {
            return true;
        }
    }
</script>
<jsp:include page="head.jsp">
    <jsp:param name="text" value="how are you"/>
</jsp:include>
<script>
    function fileCheak(target) {
        var fileSize = target.files[0].size;
        var size = fileSize / 1024;
        if (size > 1024*3) {
            alert("图片不能大于3M");
            target.value = "";
            return false;   //阻止submit提交
        }
        var name = target.value;
        var fileName = name.substring(name.lastIndexOf(".") + 1).toLowerCase();
        if (fileName !== "jpg" && fileName !=="jpeg" && fileName !=="png" && fileName !=="dwg" && fileName !== "gif") {
            alert("请选择图片格式文件上传(jpg,png,gif,dwg,pdf,gif等)！");
            target.value = "";
            return false;   //阻止submit提交
        }
    }
</script>


<div class="bodymain">
    <div class="contribute">
    <form name="editform" action="submitedit" method="post" enctype="multipart/form-data"
          onsubmit="return editsubmit()">
        <ul>
            <li>            <label for="title">标题</label><input name="title" id="title" type="text" required/><br>
            </li>
            <li style="display: flex">        <label for="detail">内容</label><textarea id="detail" name="detail"></textarea><br>
            </li>
            <li>        <input id="file" type="file" name="image" onchange="fileCheak(this)"/><br>
            </li>
        </ul>
        <input type="submit" class="submit">
    </form>
    <a href="first">返回首页</a>
</div>
</div>
</body>
</html>
