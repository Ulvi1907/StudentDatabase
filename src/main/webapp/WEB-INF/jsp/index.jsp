<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.04.2021
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="index" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Management System</title>
</head>
<body>
<h1>Student Information System</h1>
<hr/> <br/>

<index:form modelAttribute="form1" method="post" action="/">
    Id :  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<index:input path="student_id"/> <br/> <br/>
    Password : <index:password path="password"/> <br/> <br/>
    <a href="/forgot">Can't access my account</a> &nbsp;
    <input type="submit" value="Login"> <br/> <br/>
    <a href="/register">Register</a>
</index:form>

</body>
</html>
