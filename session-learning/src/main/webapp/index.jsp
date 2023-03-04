<%@ page import="top.zxh.web.login.entity.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<% User user  =(User) request.getSession().getAttribute("user");%>
<h1><%= user.getUsername() %>,欢迎您
</h1>
</body>
</html>