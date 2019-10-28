<%@ page import="com.liu.cartDemo.Goods" %><%--
  Created by IntelliJ IDEA.
  User: Mr.c
  Date: 2019/10/28
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    名称:<span name="pname"><%=goodsInfo.getPname()%></span><br>
    简介:<span name="pdesc"><%=goodsInfo.getPdesc()%></span><br>
    价格:<span name="price"><%=goodsInfo.getPrice()%></span><br>
    数量:<input type="text" name="num" value="<%=goodsInfo.getNum()%>"><br>
    <input type="submit" name="addCart" value="addToCart">
</form>
</body>
</html>
