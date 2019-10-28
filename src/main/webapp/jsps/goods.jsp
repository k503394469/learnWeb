<%@ page import="com.liu.cartDemo.GoodsDao" %>
<%@ page import="com.liu.cartDemo.Goods" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Mr.c
  Date: 2019/10/28
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>goods</title>
</head>
<body>
<%
    GoodsDao goodsDao = new GoodsDao();
    List<Goods> goods = goodsDao.goodsList();
%>
<table border="1">
    <tr>
        <th>名称</th>
        <th>查看</th>
    </tr>
    <%
        for (Goods temp : goods) {
    %>
    <tr><td><%=temp.getPname()%></td><td><a href="/learnWeb/gotoGoodsInfo?pid=<%=temp.getPid()%>">查看详情</a></td></tr>
    <%
        }
    %>
</table>
<span><a href="/learnWeb/jsps/cart.jsp">查看购物车</a></span>
</body>
</html>
