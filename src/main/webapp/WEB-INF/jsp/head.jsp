<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Auser
  Date: 2018/6/30
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>


<div class="puthead">
    <div class="head">
        <div class="head1">
            <!--显示logo-->
            <img class="logo" alt="图片" src="/FirstNews/public/image/logo.jpg">
            <!--当地天气-->
            <p id="weather" class="weather">天气</p>
            <script src="/FirstNews/public/js/getweather.js"></script>
            <!--搜索框-->
            <span class="searchcss">
    <input id="searchput" class="searchcss1" type="text" name="searchinput" placeholder="大家都在搜"/>
    <button type="submit" class="searchcss2" id="searchbutton" name="submit" value="search">搜索</button>
                <!--搜索框内容为空时不进行搜索，返回警告框,不为空是提交json-->
     <script src="/FirstNews/public/js/search.js"></script>
            </span>
            <!--登录状态-->
            <span id="login" class="login">


                <c:if test="${cookie[name].value!=null}">
                    <h2>cookie</h2>
                </c:if>



<c:if test="${sessionScope.name!=null}">
    <%@ include file="headlogin.jsp" %>
</c:if>


<c:if test="${sessionScope.name==null}">
    <%@ include file="headnologin.jsp" %>
</c:if>
</span>
            <!--返回首页-->
            <span class="home">
        <a href="first">首页</a>
        </span>
            <!--在线人数-->
            <span class="count"><p>在线人数${count}</p></span>
        </div>
    </div>
</div>
<!--广告-->
<div class="advbar">
    <img id="leftadv" style="float: left; width: 660px;height: 90px;border: none" src="leftadv">
    <!--
    <script>
        var leftadv=document.getElementById("leftadv");
        leftadv.onload=getweather();
    </script>
    -->
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
