<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<%
    String user = (String) request.getSession().getAttribute("user");
    request.setAttribute("user", user);
%>
<h2>index动态页面，需要经过过滤器才能访问，显示登录用户信息</h2>
<h3>
    当前用户:<%=user%>
</h3>
<a href="${pageContext.request.contextPath}/logout">注销</a>
</body>
</html>