function getweather() {
    console.log("getweather");
    var weatherhttp;
    if (window.XMLHttpRequest) {
        // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        weatherhttp = new XMLHttpRequest();
    }
    else {
        // IE6, IE5 浏览器执行代码
        weatherhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    weatherhttp.onreadystatechange = function () {
        if (weatherhttp.readyState == 4 && weatherhttp.status == 200) {
            if (weatherhttp.responseText !== null && weatherhttp.responseText !== "") {
                var weatherjson = JSON.parse(weatherhttp.responseText);
                if (weatherjson.weather != null && weatherjson.weather !== "") {
                    var text = weatherjson.weather.city + ":" + weatherjson.weather.weatherdetail + weatherjson.weather.tempreture;
                    document.getElementById("weather").innerHTML = text;
                }
            }
        }
    };
    weatherhttp.open("GET", "/FirstNews/weather", true);
    weatherhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    weatherhttp.send();
};
