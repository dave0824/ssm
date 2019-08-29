<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<body>
    <a href="account/findAll">测试查找所有</a><hr/>

    <h2>测试添加用户</h2><hr/>
    <form action="account/add" method="post">
        账户名：<input name="name" type="text"/>
        金  额：<input name="money" type="text"/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
