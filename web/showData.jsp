<%@ page import="com.shuyun.entity.User" %>
<%--
  Created by IntelliJ IDEA.
  User: shuyun
  Date: 2016/8/4
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>数据显示</title>
</head>
<body>
<%
    Object object=request.getSession().getAttribute("user");
    User user=(User)object;
%>
欢迎亲爱的&nbsp;&nbsp;<%=user==null?"wwww":user.getUserName()%>&nbsp;&nbsp;Login

<h1>显示用户上传的所有数据</h1><br/>
<table>
    <tr><th>信息ID</th><th>信息内容</th></tr>
    <c:forEach var="b" items="${userDataList}">
        <tr>
            <td>${b.dataId}</td><td>${b.dataTitle}</td><td><a href="dataContent.jsp?dataContent=${b.dataContent}">查看数据内容</a></td>
        </tr>

    </c:forEach>
</table>
<h1>用户上传数据</h1><br/>
<form action="saveUserData" method="post">
    <input type="text" name="userId" value="<%=user==null?"hhhh":user.getUserId()%>" style="display:none"/><br/>
    信息标题: <input type="text" name="dataTitle"/><br/>
    描述内容: <input type="text" name="dataContent"/><br/>
    文件名字:  <input type="text" name="dataName" /><br>
    <input type="submit" value="提交"/>
</form>

</body>
</html>
