<%--
  Created by IntelliJ IDEA.
  User: Auser
  Date: 2018/8/17
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="a">
    <div>
        <a id="c" class="c" onmousemove="bplay()" onmouseout="bnone()">登录</a>
    </div>
    <div id="b" class="b" onmousemove="bplay()" onmouseout="bnone()">
        <!-- <form>-->

        <table>
            <!--用户名输入框-->
            <tr>
                <td class="bz">
                    <table>
                        <tr>
                            <th>
                                <input id="username" class="logininput" type="text" placeholder="账号" name="name" required/>
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
                                <input id="userpassword" class="logininput" type="password" placeholder="密码" name="password"
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
                                <input class="loginbutton" type="submit" name="submit" value="登录" onclick="userlogin2()"/>
                            </td>
                            <td>
                                <input id="remname" type="checkbox" name="remname" value="remname"/>
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
                        <td class="bz"><a href="javascript:registe()">立即注册</a></td>
                    </tr>
                </table>
            </tr>
        </table>
        <!--  </form>-->
    </div>

</div>
