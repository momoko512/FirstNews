
function getContribute() {
    var Contributehttp;
    var text = "";
    if (window.XMLHttpRequest) {
        // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        Contributehttp = new XMLHttpRequest();
    }
    else {
        // IE6, IE5 浏览器执行代码
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    Contributehttp.onreadystatechange = function () {
        if (Contributehttp.readyState == 4 && Contributehttp.status == 200) {
            var contributes = JSON.parse(Contributehttp.responseText);
            for (var i = 0; i < contributes.content.length; i++) {
                text += " <li><h2><a href=\"javascript:detail('contribute',"+contributes.content[i].id+")\">" + contributes.content[i].title + "</a></h2></li>"
            }
            document.getElementById("contributelist").innerHTML = text;
        }
    };
    Contributehttp.open("GET", "/FirstNews/contribute/home/5", true);
    Contributehttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    Contributehttp.send();
}

function getNews() {
    var newshttp;
    if (window.XMLHttpRequest) {
        // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        newshttp = new XMLHttpRequest();
    }
    else {
        // IE6, IE5 浏览器执行代码
        newshttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    newshttp.onreadystatechange = function () {
        if (newshttp.readyState == 4 && newshttp.status == 200) {
            news = JSON.parse(newshttp.responseText);
        }
    };
    newshttp.open("GET", "/FirstNews/news/home/5", true);
    newshttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    newshttp.send();
}
function getCookie() {
    $.post("user/getcookie").done(function (data) {
        if (data !== null && data !== "") {
            $("#login").load("user/headlogin");
        }
    });

}