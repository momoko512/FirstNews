<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Auser
  Date: 2018/6/30
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!--广告图片自动切换-->

<script src="/FirstNews/public/js/adv.js"></script>

<!--登录按钮的样式-->
<script src="/FirstNews/public/js/loginbutton.js"></script>

<div class="puthead">
    <div class="head">
        <div class="head1">
            <!--显示logo-->
            <img class="logo" alt="图片" src="/FirstNews/public/image/logo.jpg">
            <!--当地天气-->
            <p id="weather">天气</p>
            <button id="getweather">点嘛</button>
            <script src="/FirstNews/public/js/getweather.js"></script>
            <!--搜索框-->
            <span class="searchcss">
    <input id="searchput" class="searchcss1" type="text" name="searchinput" placeholder="大家都在搜"/>
    <button type="submit" class="searchcss2" id="searchbutton" name="submit" value="search">搜索</button>
                <!--搜索框内容为空时不进行搜索，返回警告框,不为空是提交json-->
     <script src="/FirstNews/public/js/search.js"></script>
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
        <form action="exit" method="post">
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
        <a href="first">首页</a>
        </span>
            <!--在线人数-->
            <span><p>在线人数${count}</p></span>
        </div>
    </div>
</div>
<!--广告-->
<div class="advbar">
    <img style="float: left; width: 660px;height: 90px;border: none" src="leftadv">
    <img style="width: 320px;height: 90px;border: none" id="adv" src="rightadv1">
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
                            <a>图片</a>
                            <a>是在</a>
                            <a>网上</a>
                            <a>下载</a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <a>用于</a>
                            <a>学习</a>
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