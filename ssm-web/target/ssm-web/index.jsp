<%--
  Created by IntelliJ IDEA.
  User: zhouhang
  Date: 2018/9/1
  Time: 下午7:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<jsp:forward page="pages/main.jsp"></jsp:forward>
<a href="${pageContext.request.contextPath}/product/findAll.do">查询产品信息</a>
</body>
</html>
