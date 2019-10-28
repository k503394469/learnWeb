<%@ page import="com.liu.cartDemo.Goods" %><%--
  Created by IntelliJ IDEA.
  User: Mr.c
  Date: 2019/10/28
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>goodsInfo</title>
</head>
<body>
<%
    Goods goodsInfo = (Goods) request.getAttribute("goodsInfo");
%>
<form action="/learnWeb/addToCart" method="post">
    编号:<input type="text" name="pid" value="<%=goodsInfo.getPid()%>"><br>
    <input type="hidden" name="pname" value="${goodsInfo.pname}">
    名称:<span>${goodsInfo.pname}</span><br>
    <input type="hidden" name="pdesc" value="${goodsInfo.pdesc}">
    简介:<span name="pdesc">${goodsInfo.pdesc}</span><br>
    <input type="hidden" name="price" value="${goodsInfo.price}">
    价格:<span name="price">${goodsInfo.price}</span><br>
    数量:<input type="text" name="num" value="${goodsInfo.num}"><br>
    <input type="submit" name="addCart" value="addToCart">
</form>
</body>
</html>
