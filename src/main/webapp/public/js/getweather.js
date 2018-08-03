var getweather = document.getElementById("getweather");
getweather.onclick = function () {
    console.log("getweather");
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
        console.log("getresponce");
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var k = JSON.parse(xmlhttp.responseText);
            console.log(k);
            var text=k.weather.city+":"+k.weather.weatherdetail+k.weather.tempreture;
            console.log(text);
            document.getElementById("weather").innerHTML = text;
        }
    };
    xmlhttp.open("POST", "/FirstNews/weather", true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.send();
};
