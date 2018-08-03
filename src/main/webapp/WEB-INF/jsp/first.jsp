<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>首页</title>
    <style type="text/css">
        @import url(/FirstNews/public/css/headcss.css);
        @import url(/FirstNews/public/css/first.css);
    </style>
</head>
<body>
<!--通用头部-->
<div id="header">
    <%@ include file="head.jsp" %>
</div>
<div class="bodymain" id="bodymain">
    <div class="space"></div>
    <!--news图片展示-->
<script>var newsimg = new Array(5);
newsimg[0] = "0.image";
newsimg[1] = "1.image";
newsimg[2] = "2.image";
newsimg[3] = "3.image";
newsimg[4] = "4.image";
var newstitles = new Array(5);
newstitles[0] = "${first.news.get(0).title}";
newstitles[1] = "${first.news.get(1).title}";
newstitles[2] = "${first.news.get(2).title}";
newstitles[3] = "${first.news.get(3).title}";
newstitles[4] = "${first.news.get(4).title}";
var ids = new Array(5);
ids[0] = "${first.news.get(0).id}";
ids[1] = "${first.news.get(1).id}";
ids[2] = "${first.news.get(2).id}";
ids[3] = "${first.news.get(3).id}";
ids[4] = "${first.news.get(4).id}";
var curIndex1 = 0;
var time=2000;
var newstime = setInterval(newsimgs, timeInterval);

function newsimgs() {
    var newsimages = document.getElementById("newsimage");
    var newstitle = document.getElementById("newstitle");
    var onehref = document.getElementById("onehref");
    var twohref = document.getElementById("twohref");
    setInterval(function () {
        if (curIndex1 === newsimg.length - 1) {
            curIndex1 = 0;
        }
        else {
            curIndex1 += 1;
        }
        newsimages.src = newsimg[curIndex1];
        newstitle.innerText=newstitles[curIndex1];
        onehref.href="view"+ids[curIndex1]+".news";
        twohref.href="view"+ids[curIndex1]+".news";
    }, time);
}
</script>
    <div class="left">
        <div class="images">
            <a id="onehref"> <img id="newsimage" src="0.image"></a>
        </div>
        <div class="titles">
            <a id="twohref"> <span id="newstitle">${first.news.get(0).title}</span></a>
        </div>
    </div>
    <div class="contribute">
        <div>
    <img width="320px" height="72px" src="contribute1">
        </div>
        <ul>
            <c:forEach items="${first.contributes}" var="contribute">

                <li><h2><a href="view${contribute.id}.contribute">${contribute.title}</a></h2></li>

            </c:forEach>
        </ul>
        <div>
        <img width="320px" height="50px" src="contribute2">
        </div>

    </div>
</div>
</body>
</html>