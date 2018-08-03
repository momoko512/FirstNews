var butt = document.getElementById("searchbutton");
function searchTrim(s) {
    return s.replace(/(^\s*)|(\s*$)/g, "");
}
butt.onclick = function () {
    var searchvalue = document.getElementById("searchput").value;
    console.log("searchvalue"+searchvalue);
    console.log("searchvaluetrim"+searchTrim(searchvalue));
    if (searchTrim(searchvalue) == "") {
        alert("请输入搜索内容");
    } else {
        var obj = {"search": searchTrim(searchvalue)};
        console.log(obj);
        var myJSON = JSON.stringify(obj);
        var xmlhttp;
        if (window.XMLHttpRequest) {
            // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
            xmlhttp = new XMLHttpRequest();
        }
        else {
            // IE6, IE5 浏览器执行代码
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                var k = JSON.parse(xmlhttp.responseText);
                var text = "";
                if (k.searchresult.length == 0) {
                    text = "<p>您搜索的内容不存在</p>"
                } else {
                    for (i in k.searchresult) {
                        text += "<a href=\"view" + k.searchresult[i].id + ".news\"><p>" + k.searchresult[i].title + "</p></a></br>"
                    }
                }
                document.getElementById("bodymain").innerHTML = text;
            }
        };
        xmlhttp.open("POST", "/FirstNews/search", true);
        xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlhttp.send(myJSON);
    }
}