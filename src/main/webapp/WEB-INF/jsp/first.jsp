<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>首页</title>
    <style type="text/css">
        @import url(/FirstNews/public/css/headcss.css);
        @import url(/FirstNews/public/css/first.css);
    </style>
    <script src="/FirstNews/public/js/jquery-1.11.1.js"></script>
</head>
<body>
<!--通用头部-->

<div id="header">
    <%@ include file="head.jsp" %>
</div>

<div class="bodymain" id="bodymain">
    <div class="space"></div>
    <div class="left">
        <div class="images">
            <a id="onehref"> <img id="newsimage"></a>
        </div>
        <div class="titles">
            <a id="twohref"> <span id="newstitle">${first.news.get(0).title}</span></a>
        </div>
    </div>
    <div class="contribute">
        <div>
            <img width="320px" height="72px" src="contribute1">
        </div>

        <ul id="contributelist">
                <li><h2><a href="view${contribute.id}.contribute">${contribute.title}</a></h2></li>
        </ul>
        <div>
            <img width="320px" height="50px" src="contribute2">
        </div>

    </div>
</div>
<script src="/FirstNews/public/js/homeget.js"></script>
<!--news图片切换-->
<script>
    var curIndexnews = 0;
    var time = 2000;
    var newstime = setInterval(newsimgs, time);

    function newsimgs() {
        var newsimg = new Array(5);
        var newstitles = new Array(5);
        var ids = new Array(5);
        for (var i = 0; i < news.content.length; i++) {
            newsimg[i] = news.content[i].id + ".newsimage";
            newstitles[i] = news.content[i].title;
            ids[i] =news.content[i].id;
        }

        var newsimages = document.getElementById("newsimage");
        var newstitle = document.getElementById("newstitle");
        var onehref = document.getElementById("onehref");
        var twohref = document.getElementById("twohref");
        if (curIndexnews === newsimg.length - 1) {
            curIndexnews = 0;
        }
        else {
            curIndexnews += 1;
        }
        newsimages.src = newsimg[curIndexnews];
        newstitle.innerText = newstitles[curIndexnews];
        onehref.href ="javascript:detail('news',"+ids[curIndexnews]+")";
        twohref.href = "javascript:detail('news',"+ids[curIndexnews]+")";
    };

</script>
<!--window.onload-->
<script>
    window.onload = function () {
        getNews();
        getContribute();
        getCookie();
        getweather();
    }
</script>
<!--广告图片自动切换-->
<script src="/FirstNews/public/js/adv.js"></script>
<!--登录块样式、登录按钮点击事件、退出登录按钮点击事件-->
<script src="/FirstNews/public/js/loginAndExit.js"></script>
</body>
</html>