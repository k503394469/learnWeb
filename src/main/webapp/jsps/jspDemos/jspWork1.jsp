<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.liu.work.Stu" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Map map=new HashMap();
    map.put("key1", "aaa");
    map.put("key2", "bbb");
    application.setAttribute("msg", map);
%>
<%
    Stu p1=new Stu();
    Stu p2=null;
    request.setAttribute("p1", p1);
    request.setAttribute("p2", p2);
%>
${applicationScope.msg.key2} <br>
${empty requestScope.p2}
</body>
</html>
