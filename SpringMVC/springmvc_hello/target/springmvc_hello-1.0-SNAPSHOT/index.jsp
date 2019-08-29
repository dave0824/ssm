<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/8
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <a href="helloController/hello">hello按钮</a><br/>

    <a href="/helloController/params?name=dave">params测试按钮</a>
    <a href="/helloController/params?name=hehe">params测试按钮2</a><br/>

    <a href="/helloController/int?age=20">参数绑定测试按钮int</a>
    <a href="/helloController/double?price=88.88">参数绑定测试按钮double</a>
    <a href="/helloController/string?name=xixi">参数绑定测试按钮string</a>
    <a href="/helloController/intAndString?name=ee&age=20">参数绑定测试按钮int,string</a>
    <a href="/helloController/date?date=2018-12-24">参数绑定测试按钮date</a>
    <a href="/helloController/service">参数绑定测试按钮service</a><br/>

    <form action="/helloController/user">
    姓名： <input type="text" name="name"/><br/>
    年龄：<input type="text" name="age"/><br/>
    价格：<input type="text" name="price"/><br/>
    <input type="submit" value="提交"/>
    </form>
    <br/><br/>

    <form action="/helloController/account">
        姓名： <input type="text" name="username"/><br/>
        密码：<input type="text" name="password"/><br/>
        价格：<input type="text" name="money"/><br/>
        <!--account中存在user对象封装-->
        用户名:<input type="text" name="user.name"/><br/>
        年龄：<input type="text" name="user.age"/><br/>
        <!--map封装数据-->
        用户名:<input type="text" name="map['one'].name"/><br/>
        年龄：<input type="text" name="map['one'].age"/><br/>
        <!--list封装数据-->
        用户名:<input type="text" name="list[0].name"/><br/>
        年龄：<input type="text" name="list[0].age"/><br/>
        <input type="submit" value="提交"/>
    </form>
</head>
<body>

</body>
</html>
