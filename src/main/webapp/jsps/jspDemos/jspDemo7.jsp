<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL</title>
</head>
<body>
<%--foreach--%>
<c:forEach begin="0" end="9" var="i" step="1">
    i=${i}
</c:forEach><br>
<%
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    request.setAttribute("list1", list);
%>
<c:forEach items="${list1}" var="tempInt" varStatus="s">
    tempInt=${tempInt}<br>
</c:forEach>
</body>
</html>
