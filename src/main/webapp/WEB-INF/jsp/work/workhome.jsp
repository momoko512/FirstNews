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
    <!--登录按钮的样式-->
    <script>
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
    </script>
    <!--搜索框内容为空时不进行搜索，返回警告框-->
    <script>
        function searchTrim(s) {
            return s.replace(/(^\s*)|(\s*$)/g, "");
        }

        function dosubmit() {
            var searchvalue = document.getElementById("searchput").value;
            if (searchTrim(searchvalue) == "") {
                alert("请输入搜索内容");
                return false;
            } else {
                return true;
            }
        }
    </script>
    <div style="width: 100px;margin: auto"><p>编辑模式</p></div>
    <div class="puthead">
        <div class="head">
            <div class="head1">
                <!--显示logo-->
                <img class="logo" alt="图片" src="../public/image/logo.jpg">
                <!--搜索框-->
                <span class="searchcss">
            <form id="searchform" action="search" onsubmit="return dosubmit()">
    <input id="searchput" class="searchcss1" type="text" name="searchinput" placeholder="大家都在搜"/>
    <button type="submit" class="searchcss2" id="searchbutton" name="submit" value="search">搜索</button>
            </form>
        </span>
                <!--登录状态-->
                <span class="login">

<c:if test="${sessionScope.name!=null}">
    <div class="a">
        <div>
            <a class="c" id="c1" onmousemove="bplay1()"
               onmouseout="bnone1()"><%=request.getSession().getAttribute("name")%></a>
</div>
    <div class="b" id="b1" onmousemove="bplay1()" onmouseout="bnone1()">
        <a class="editherf" href="edit">投稿</a>
        <a href="mycontribute">我的投稿</a>
        <a href="editpassword">修改密码</a>
        <form action="exit">
        <input type="submit" name="submit" value="退出登录"/>
            </form>
    </div>


    </div>
</c:if>


<c:if test="${sessionScope.name==null}">
    <div class="a">
        <div>
      <a id="c" class="c" onmousemove="bplay()" onmouseout="bnone()">登录</a>
        </div>
       <div id="b" class="b" onmousemove="bplay()" onmouseout="bnone()">
        <form action="login" method="post" onsubmit="loginorsearch()">

            <table>
                <!--用户名输入框-->
                <tr>
                    <td class="bz">
                        <table>
                            <tr>
                                <th>
                                    <input class="logininput" type="text" placeholder="账号" name="name" required/>
                                </th>
                            </tr>
                        </table>
                    </td>
                </tr>
                <!--密码输入框-->
                <tr>
                    <td class="bz">
                        <table>
                            <tr>
                                <td>
                                    <input class="logininput" type="password" placeholder="密码" name="password"
                                           required/>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <!--登录和下次自动登录功能-->
                <tr>
                    <td class="bz">
                        <table>
                            <tr>
                                <td>
                                    <input class="loginbutton" type="submit" name="submit" value="登录"/>
                                </td>
                                <td>
                                    <input type="checkbox" name="remname" value="remname"/>
                                    <span class="autologin">下次自动登录</span>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <!--忘记密码和注册功能-->
                <tr>
                    <table>
                        <tr>
                            <td class="bz"><a>忘记密码</a></td>
                            <td class="bz"><a href="register">立即注册</a></td>
                        </tr>
                    </table>
                </tr>
            </table>
        </form>
  </div>

    </div>
</c:if>

</span>
                <!--返回首页-->
                <span class="home">
        <a href="../first">首页</a>
        </span>
            </div>
        </div>
    </div>
    <!--广告-->
    <div class="advbar" style="height: 150px">
        <form action="submitadvs" method="post" enctype="multipart/form-data">
            <div>
                <div style="width: 660px;height: 150px;border:1px solid;margin: 0;float: left">
                    <p>660*90</p><br>
                    <input type="file" name="leftadv"><br>
                    <label>链接</label><input type="text" name="leftlink">
                </div>
                <div style="display: -webkit-box">
                <div style="height: 150px;border:1px solid;margin: 0">
                    <p>320*90</p><br>
                    <input type="file" name="rightadv1"><br>
                    <label>链接1</label><input type="text" name="rightlink1">
                    <input type="file" name="rightadv2"><br>
                    <label>链接2</label><input type="text" name="rightlink2">
                    <input type="file" name="rightadv3"><br>
                    <label>链接3</label><input type="text" name="rightlink3">
                </div>
                <div><input style="height: 30px;width: 60px;margin-top: 75px" type="submit"></div>
                </div>
            </div>
        </form>
    </div>
    <!--导航-->
    <div class="putnav">
        <nav>
            <ul>
                <li>
                    <table>
                        <tbody>
                        <tr>
                            <td>
                                <a>随便</a>
                                <a>随便</a>
                                <a>随便</a>
                                <a>随便</a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <a>随便</a>
                                <a>随便</a>
                                <a>随便</a>
                                <a>随便</a>
                            </td>
                        </tr>

                        </tbody>
                    </table>
                </li>
                <li>
                    <table>
                        <tbody>
                        <tr>
                            <td>
                                <a>随便</a>
                                <a>三个字</a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <a>随便</a>
                                <a>三个字</a>
                            </td>
                        </tr>

                        </tbody>
                    </table>
                </li>
                <li>
                    <table>
                        <tbody>
                        <tr>
                            <td>
                                <a>随便</a>
                                <a>随便</a>
                                <a>随便</a>
                                <a>四个字</a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <a>随便</a>
                                <a>随便</a>
                                <a>随便</a>
                                <a>四个字</a>
                            </td>
                        </tr>

                        </tbody>
                    </table>
                </li>
                <li>
                    <table>
                        <tbody>
                        <tr>
                            <td>
                                <a>随便</a>
                                <a>随便</a>
                                <a>随便</a>
                                <a>随便</a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <a>随便</a>
                                <a>随便</a>
                                <a>随便</a>
                                <a>随便</a>
                            </td>
                        </tr>

                        </tbody>
                    </table>
                </li>
            </ul>
        </nav>
    </div>
</div>


<div class="bodymain">
    <div class="space"></div>
    <!--news图片展示-->
    <script>
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
            var time = 2000;
            setInterval(function () {
                if (curIndex === newsimg.length - 1) {
                    curIndex = 0;
                }
                else {
                    curIndex += 1;
                }
                newsimages.src = newsimg[curIndex];
                newstitle.innerText = newstitles[curIndex];
                onehref.href = "view" + ids[curIndex] + ".news";
                twohref.href = "view" + ids[curIndex] + ".news";
            }, time);
        }

    </script>
    <div class="left">
        <div class="images" style="height:400px">
            <a style="position: relative;top: 200px;top: 300px; font-size: larger" href="editnews">编辑头条</a>
        </div>
        <div class="titles">
            <a id="twohref"> <span id="newstitle">${first.news.get(0).title}</span></a>
        </div>
    </div>

    <div class="contribute">
        <div style="width: 320px;height: 72px;margin-bottom: 100px">
            <p>320*72</p>
            <form action="submitconimg" method="post" enctype="multipart/form-data">
                <input type="file" name="contribute1"><br>
                <input type="submit">
            </form>
        </div>
        <a href="review" style="position: relative;top: 80px;font-size: larger">审核投稿</a>
        <div style="width: 320px;height: 50px;margin-top: 150px">
            <p>320*50</p>
            <form action="submitconimg" method="post" enctype="multipart/form-data">
                <input type="file" name="contribute2"><br>
                <input type="submit">
            </form>
        </div>

    </div>
</div>
</body>
</html>
