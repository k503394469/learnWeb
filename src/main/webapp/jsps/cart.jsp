<%@ page import="java.util.Map" %>
<%@ page import="com.liu.cartDemo.Goods" %>
<%@ page import="java.util.Set" %><%--
  Created by IntelliJ IDEA.
  User: Mr.c
  Date: 2019/10/28
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cart</title>
</head>
<body>
<%
    Map<Integer, Goods> goodsMap = (Map<Integer, Goods>) request.getSession().getAttribute("cart");
    Set<Integer> pid_list = goodsMap.keySet();
    for (Integer id_temp : pid_list) {
        Goods goods = goodsMap.get(id_temp);
%>
Goods:
name:<%=goods.getPname()%><br>
price:<%=goods.getPrice()%><br>
Num:<%=goods.getNum()%><br>
<%
    }
%>
</body>
</html>
