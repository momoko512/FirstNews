window.onload = function () {
    newsimgs();
};
function newsimgs() {
    var newsimages = document.getElementById("newsimage");
    var newstitle = document.getElementById("newstitle");
    var onehref = document.getElementById("onehref");
    var twohref = document.getElementById("twohref");
    var newsimg = new Array(5);
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
    var curIndex = 0;
    var time=2000;
    setInterval(function () {
        if (curIndex === newsimg.length - 1) {
            curIndex = 0;
        }
        else {
            curIndex += 1;
        }
        newsimages.src = newsimg[curIndex];
        newstitle.innerText=newstitles[curIndex];
        onehref.href="view"+ids[curIndex]+".news";
        twohref.href="view"+ids[curIndex]+".news";
    }, time);
}
