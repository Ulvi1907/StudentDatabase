<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
 <head>
    <title>Student list Ajax</title>
     <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
           integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
           crossorigin="anonymous">
     <link rel="stylesheet" href="<c:url value="/web/css/students.css"/>"/>

 </head>
 <body>
  <nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <!-- Brand -->
    <a class="navbar-brand" href="/student/ajax">Student Management System</a>

    <!-- Toggler/collapsibe Button -->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>

    <!-- Navbar links -->
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/student/ajax" style="color: white">Student List</a>
            </li>
        </ul>
    </div>
  </nav>
     <br/> <br/>

     <!-- Table -->
     <table id="students" class="table table-striped table-bordered" style="display: table" >
     <button class="nav-link" onclick="showStudentDetailsAdd()" style="color:black;">Add Student</button>
     <h2>Student List</h2> <br/>
     <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Point</th>
        <th>Actions</th>
     </tr>

     </table>

     <!-- Update form -->
     <form class="box1" id="update" style="display: none">

     <h1>Update</h1>

     <span id="id" style="display: none"></span>

       <input type="text" id="name"/>

       <input type="text" id="surname" />

       <input type="number" id="point" />

       <button onclick="updateStudent()" >Update</button>

     </form>

     <!-- Add form -->
     <form class="box1" id="add" style="display: none">

     <h1>Add new student</h1>

     <span id="addId" style="display: none"></span>

       <input type="text" id="addName" placeholder="Name"/>

       <input type="text" id="addSurname" placeholder="Surname"/>

       <input type="number" id="addPoint" placeholder="Point"/>

       <button onclick="addStudent()" >Submit</button>

     </form>

 </body>

  <script src="<c:url value="/web/js/student-xhr.js"/>"></script>

</html>