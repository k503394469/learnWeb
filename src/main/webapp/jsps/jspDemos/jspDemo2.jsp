<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("name","zhangsan");
    session.setAttribute("age","23");
%>

<h1>EL表达获取</h1>
${requestScope.name}<br>
${sessionScope.age}<br>
${name}
</body>
</html>
