<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL</title>
</head>
<body>
<c:if test="true">
    <h1>if标签体True</h1>
</c:if>

<%
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    request.setAttribute("list1", list);
    request.setAttribute("week",8);
%>
<c:if test="${!empty requestScope.list1}">
    ${list1.size()}
</c:if><br>
<c:choose>
    <c:when test="${week==1}">
        周一
    </c:when>
    <c:when test="${week==2}">
        周二
    </c:when>
    <c:when test="${week==3}">
        周三
    </c:when>
    <c:when test="${week==4}">
        周四
    </c:when>
    <c:when test="${week==5}">
        周五
    </c:when>
    <c:when test="${week==6}">
        周六
    </c:when>
    <c:when test="${week==7}">
        周日
    </c:when>
    <c:otherwise>
        数据错误
    </c:otherwise>
</c:choose>
</body>
</html>
