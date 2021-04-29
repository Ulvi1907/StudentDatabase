<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.04.2021
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="forgot" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Management System</title>
</head>
<body>
<h3>Forgot password?</h3> <br/>

<forgot:form modelAttribute="form2" method="post" action="/forgot">
    Your Id : &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <forgot:input path="student_id"/> <br/> <br/>
    New password : <forgot:input path="password"/> &nbsp; &nbsp;
    <input type="submit" value="Continue"/>
</forgot:form>

</body>
</html>
