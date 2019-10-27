<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: Mr.k
  Date: 2019/10/27
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>time</title>
</head>
<body>
<%
    boolean flag = false;
    Date time = null;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分dd秒");
    String dateFormat = sdf.format(new Date());
    dateFormat = URLEncoder.encode(dateFormat, "utf-8");

    Cookie[] cookies = request.getCookies();
    if (cookies.length != 0 || cookies != null) {
        for (Cookie temp : cookies) {
            if ("time".equals(temp.getName())) {
                flag = true;
%>
<h1>WelcomeBack</h1>
<p>last login time is&nbsp;<%=URLDecoder.decode(temp.getValue(), "utf-8")%>
</p>
<%
                temp.setValue(dateFormat);
                temp.setMaxAge(60 * 60);
                response.addCookie(temp);
                break;
            }
        }
    }
    if (cookies.length == 0 || cookies == null || flag == false) {
%>
        <h1>Welcome</h1>
        <p>This is your first time login</p>
<%
        Cookie cookie = new Cookie("time",dateFormat);
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
    }
%>
</body>
</html>
