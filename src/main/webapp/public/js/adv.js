var curIndex = 0;
//时间间隔 单位毫秒
var timeInterval = 1000;
var arr = new Array(3);
arr[0] = "rightadv1";
arr[1] = "rightadv2";
arr[2] = "rightadv3";
var advtime = setInterval(changeImg, timeInterval);

function changeImg() {
    var adv = document.getElementById("adv");
    if (curIndex === arr.length - 1) {
        curIndex = 0;
    }
    else {
        curIndex += 1;
    }
    adv.src = arr[curIndex];
}