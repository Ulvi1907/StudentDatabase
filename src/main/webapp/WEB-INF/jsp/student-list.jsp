<%--
  Created by IntelliJ IDEA.
  User: ramin
  Date: 01.12.20
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css"/>
    <script type="text/javascript" language="javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" language="javascript"
            src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
</head>
<body>
<table id="student_table" class="display" style="width:100%">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Point</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="std">
        <tr>
            <td>${std.id}</td>
            <td>${std.name}</td>
            <td>${std.surname}</td>
            <td>${std.point}</td>
            <td>N/A</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script>
    $(document).ready(function() {
        $('#student_table').DataTable();
    } );
</script>
</body>
</html>
