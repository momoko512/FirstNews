var butt = document.getElementById("searchbutton");
function searchTrim(s) {
    return s.replace(/(^\s*)|(\s*$)/g, "");
}
butt.onclick = function () {
    var searchvalue = document.getElementById("searchput").value;
    if (searchTrim(searchvalue) == "") {
        alert("请输入搜索内容");
    } else {
        var searchhttp;
        if (window.XMLHttpRequest) {
            // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
            searchhttp = new XMLHttpRequest();
        }
        else {
            // IE6, IE5 浏览器执行代码
            searchhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        searchhttp.onreadystatechange = function () {
            if (searchhttp.readyState == 4 && searchhttp.status == 200) {
                var searchresult = JSON.parse(searchhttp.responseText);
                var text = "";
                console.log("searchresult.content.length"+searchresult.content.length)
                if (searchresult.content.length == 0) {
                    text = "<p>您搜索的内容不存在</p>"
                } else {
                    clearInterval(newstime);
                    for (i in searchresult.content) {
                        console.log("id"+searchresult.content[i].id);
                        text += "<a href=\"javascript:detail('news',"+searchresult.content[i].id+")\"><p>" + searchresult.content[i].title + "</p></a></br>"
                    }
                }
                document.getElementById("bodymain").innerHTML = text;
            }
        };
        searchhttp.open("GET", "/FirstNews/news/search?keyword="+searchTrim(searchvalue), true);
        searchhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        searchhttp.send();
    }
};
function detail(y,x) {
    //clearInterval(newstime);
    $.get(y+"/id",{id:x}).done(function (data) {
        clearInterval(newstime);
        var text="<p>"+data.title+"</p><br><p>"+data.detail+"</p><br>";
        if(data.image!=null){
            text+="<img src=\""+data.id+"."+y+"image\">";
        }
        $("#bodymain").html(text);
    });
}