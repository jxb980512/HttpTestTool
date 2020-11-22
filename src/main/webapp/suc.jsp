<%--
  Created by IntelliJ IDEA.
  User: 10902
  Date: 2020/9/16
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
成功
<form action="/ServletTest1" method="post">
    用户名：<input name="username" type="text">
    密码：<input name="password" type="text">
    <input type="submit" value="提交">
</form>
<span id="data1">数据1</span>
<span id="data2">数据2</span>
<span id="data3">数据3</span>
<p>password:${user.password}</p>
</body>
</html>
