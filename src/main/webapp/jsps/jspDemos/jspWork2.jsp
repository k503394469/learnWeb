<%@ page import="com.liu.work.Stu" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Stu> stuList=new ArrayList<>();
    stuList.add(new Stu("Tom",20,new Date()));
    stuList.add(new Stu("Jerry",25,new Date()));
    stuList.add(new Stu("Jax",56,new Date()));
    request.setAttribute("stuList",stuList);
%>
<table border="1" width="500" align="center">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>日期</th>
    </tr>
    <c:forEach items="${stuList}" var="tempStu" varStatus="s">
        <c:if test="${s.count%2==0}">
        <tr>
            <td>${s.count}</td>
            <td>${tempStu.name}</td>
            <td>${tempStu.age}</td>
            <td>${tempStu.birStr}</td>
        </tr>
        </c:if>
        <c:if test="${s.count%2!=0}">
            <tr bgcolor="#66ccff">
                <td>${s.count}</td>
                <td>${tempStu.name}</td>
                <td>${tempStu.age}</td>
                <td>${tempStu.birStr}</td>
            </tr>
        </c:if>
    </c:forEach>
</table>
</body>
</html>
