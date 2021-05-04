<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.04.2021
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="index" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<%--    <meta charset="utf-8">--%>
    <title>Student Management System</title>
<%--    <link type="text/css" rel="stylesheet" href="/jsp/style.css">--%>
<style> <%@include file="style.css" %> </style>
    <%--    <style>--%>
<%--    body {--%>
<%--    margin: 0;--%>
<%--    padding: 0;--%>
<%--    font-family: sans-serif;--%>
<%--    background: #34495e;--%>
<%--    }--%>
<%--    </style>--%>
</head>
<body>
<h1 class="h1">Student Management System</h1>
<hr/> <br/>

<index:form modelAttribute="form1" class = "box" method="post" action="/">
    <h1>Login</h1>
    <index:input path="student_id" placeholder = "Id" />
    <index:password path="password" placeholder="Password"/>
    <input type="submit" value="Login">
    <a href="/register">Register</a>
</index:form>

</body>
</html>
