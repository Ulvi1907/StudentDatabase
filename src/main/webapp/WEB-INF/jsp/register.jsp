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
<body>
<form:form modelAttribute="form" action="register" method="post">
    <h1>Sign up</h1><br/>

    Name : &nbsp; &nbsp; &nbsp; <form:input path="name"/>
    <br/>
    <span><form:errors path="name" cssClass="error"/></span> <br/>
    Surname : &nbsp; <form:input path="surname"/>
    <br/>
    <span><form:errors path="surname" cssClass="error"/></span><br/>
    Student Id : <form:input path="student_id"/>
    <br/>
    <span><form:errors path="student_id" cssClass="error"/></span><br/>
    Grade year : <form:input path="gradeYear"/> <br/>
    <span><form:errors path="gradeYear" cssClass="error"/> </span> <br/>
    Password : &nbsp; <form:password path="password"/>
    <br/>
    <span><form:errors path="password" cssClass="error"/></span><br/>
    <input type="submit" value="Sign Up">
</form:form>

</body>
<head>
    <title>Register</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
</html>
