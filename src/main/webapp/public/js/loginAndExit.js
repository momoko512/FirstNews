function bplay() {
    document.getElementById("b").style.display = "block";
    document.getElementById("b").style.cursor = "pointer";
    document.getElementById("c").style.borderBottom = "2px solid dimgrey"
}

function bnone() {
    document.getElementById("b").style.display = "none";
    document.getElementById("c").style.borderBottom = "none";

}

function bplay1() {
    document.getElementById("b1").style.display = "block";
    document.getElementById("b1").style.cursor = "pointer";
    document.getElementById("c1").style.borderBottom = "2px solid dimgrey"
}

function bnone1() {
    document.getElementById("b1").style.display = "none";
    document.getElementById("c1").style.borderBottom = "none";

}
//js实现
function userlogin() {
    var name = document.getElementById("username").value;
    var password = document.getElementById("userpassword").value;
    var user = {"name": name, "password": password};
    var loginUser = JSON.stringify(user);
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var result = xmlhttp.responseText;
            if (result !== null && result !== "") {
                var getuser = JSON.parse(result);
                console.log(getuser.name);
            }
        }
    };
    xmlhttp.open("POST", "user/login", true);
    xmlhttp.setRequestHeader("Content-type", "application/json");
    xmlhttp.send(loginUser);

}
//jquery实现
function userlogin2() {
    var name = $("#username").val();
    var password = $("#userpassword").val();
    var user = {"name": name, "password": password};
    var loginUser = JSON.stringify(user);
    var iscookie=$("#remname").is(":checked");
    $.ajax({
        type: "post",
        contentType: "application/json; charset=utf-8",
        url: "user/login",
        async: true,
        data: loginUser,
        success: function (result) {
            if (result !== null && result !== "") {
                $("#login").load("user/headlogin");
                if(iscookie===true){
                    docookie(iscookie);
                }
            }
        }
    });
}
function docookie(iscookie) {
    $.post("user/docookie",{iscookie:iscookie});
}
function exit() {
    $("#login").load("user/exit");
}
function registe() {
    clearInterval(newstime);
    $("#bodymain").html("");
    $("#bodymain").load("user/registe");
}
