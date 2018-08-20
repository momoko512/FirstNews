<%--
  Created by IntelliJ IDEA.
  User: Auser
  Date: 2018/7/1
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<h1>用户注册</h1>
<h2>只是页面不一样，实现的是同一个注册功能，没有实现具体分类</h2>
<div id="regi">
    <ul>
        <li class="on">手机注册</li>
        <li>邮箱注册</li>
        <li>短信快捷</li>
    </ul>
    <div>

        <form action="registresult" method="post">
            <table>
                <tr>
                    <table>
                        <tr>
                            <td>手机</td>
                            <td><input type="tel" name="name" required></td>
                        </tr>
                        <tr>
                            <td>密码</td>
                            <td><input type="password" name="password" required></td>
                        </tr>
                        <tr>
                            <td>确认密码</td>
                            <td><input type="password" name="repassword" required></td>
                        </tr>
                    </table>
                </tr>
                <tr>
                    <table>
                        <tr>
                            <th><input type="submit" value="提交"></th>
                        </tr>
                    </table>
                </tr>
            </table>
        </form>


    </div>
    <div class="hide">
        <form action="registresult" method="post">
            <table>
                <tr>
                    <table>
                        <tr>
                            <td>邮箱</td>
                            <td><input type="tel" name="name" required></td>
                        </tr>
                        <tr>
                            <td>密码</td>
                            <td><input type="password" name="password" required></td>
                        </tr>
                        <tr>
                            <td>确认密码</td>
                            <td><input type="password" name="repassword" required></td>
                        </tr>
                    </table>
                </tr>
                <tr>
                    <table>
                        <tr>
                            <th><input type="submit" value="提交"></th>
                        </tr>
                    </table>
                </tr>
            </table>
        </form>


    </div>
    <div class="hide">
        <form action="registresult" method="post">
            <table>
                <tr>
                    <table>
                        <tr>
                            <td>没写</td>
                            <td><input type="tel" name="name" required></td>
                        </tr>
                        <tr>
                            <td>密码</td>
                            <td><input type="password" name="password" required></td>
                        </tr>
                        <tr>
                            <td>确认密码</td>
                            <td><input type="password" name="repassword" required></td>
                        </tr>
                    </table>
                </tr>
                <tr>
                    <table>
                        <tr>
                            <th><input type="submit" value="提交"></th>
                        </tr>
                    </table>
                </tr>
            </table>
        </form>


    </div>
</div>
<!--注册表样式-->
<script type="text/javascript">
    var li1=$("#regi ul li:eq(0)");
    var li2=$("#regi ul li:eq(1)");
    var li3=$("#regi ul li:eq(2)");

    var div1=("#regi div:eq(0)");
    var div2=("#regi div:eq(1)");
    var div3=("#regi div:eq(2)");



    function registlook() {
        for (var n = 0; n < 3; n++) {
            li1.
            oLis[n].className = "";
            oDivs[n].className = "hide";
        }
        this.className = "on";
        oDivs[this.index].className = "";
    }


</script>



