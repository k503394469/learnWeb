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

%>
${!empty requestScope.list}<br>
${pageContext.request.contextPath}
${requestScope.}

</body>
</html>
