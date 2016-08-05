<%@ page import="com.shuyun.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: shuyun
  Date: 2016/8/4
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>userLogin</title>
  </head>
  <body>
  ${requestScope.msg}<br/>
  <form action="userLogin" method="post">
    用户名: <input type="text" name="userName"/><br/>
    密&nbsp;码: <input type="password" name="userPassword"/><br/>
    自动登录  <input type="checkbox" name="mark" value="mark"/>
    <input type="submit" value="登陆"/>
  </form>
  </body>
</html>
