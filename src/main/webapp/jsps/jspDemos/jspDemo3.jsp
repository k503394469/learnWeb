<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liu.work.Stu" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Stu s=new Stu();
    s.setAge(23);
    s.setDate(new Date());
    request.setAttribute("s",s);
%>

${requestScope.s}

<%--通过属性值  去掉setter或getter的后边--%>
${requestScope.s.age}<br>
${s.date}<br>
${s.birStr}
</body>
</html>
