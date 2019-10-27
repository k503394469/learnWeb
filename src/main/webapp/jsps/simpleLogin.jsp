<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<%
    String username=null;
    Cookie[] cookies = request.getCookies();
    if (cookies.length!=0||cookies!=null){
        for (Cookie temp:cookies){
            if ("username".equals(temp.getName())){
                username=temp.getValue();
                break;
            }
        }
    }
%>

<form action="/learnWeb/loginSer" method="post">
    <input type="text" name="username" placeholder="用户名" value="<%=(username!=null)?username:""%>"><br>
    <input type="password" name="password" placeholder="密码"><br>
    <input type="checkbox" name="remember" value="check">记住用户<br>
    <input type="submit" value="go">
</form>
</body>
</html>
