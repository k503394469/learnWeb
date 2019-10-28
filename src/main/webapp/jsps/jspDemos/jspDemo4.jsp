<%@ page import="com.liu.work.Stu" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Integer> l=new ArrayList<>();
    for (int i=0;i<10;i++){
        l.add(i);
    }
    request.setAttribute("list",l);
    Map map=new HashMap();
    map.put("name","male");
    map.put("age","23");
    request.setAttribute("map",map);
%>
${list[5]}<br>
${map.name}
</body>
</html>
