<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.04.2021
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Register</title>
    <style>
        <%@include file="register.css" %>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<form:form modelAttribute="form" action="register" method="post" class="box1">

    <h1>Sign up</h1>

    <form:input path="name" placeholder="name"/>
    <form:errors path="name" cssClass="error"/>

    <form:input path="surname" placeholder="surname"/>
    <form:errors path="surname" cssClass="error"/>

    <form:input path="student_id" placeholder="Id"/>
    <form:errors path="student_id" cssClass="error"/>

    <form:password path="password" placeholder="Password"/>
    <form:errors path="password" cssClass="error"/>

    <input type="submit" value="Sign Up">
</form:form>

</body>
</html>
