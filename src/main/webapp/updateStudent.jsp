<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.skillcollaboration.skillbasedstudentcollaborationweb.model.Student" %>

<%
    Student student = (Student) request.getAttribute("student");
%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Update Student</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<h1>🎓 Skill-Based Student Collaboration System</h1>

<h2>Update Student</h2>

<%
    if (student == null) {
%>

    <h3>Enter Student ID</h3>

    <form action="editStudent" method="get">

        Student ID:<br>

        <input type="number"
               name="id"
               required>

        <br><br>

        <input type="submit" value="Find Student">

    </form>

<%
    } else {
%>

    <form action="updateStudent" method="post">

        Student ID:<br>

        <input type="number"
               name="id"
               value="<%= student.getId() %>"
               readonly>

        <br><br>

        Name:<br>

        <input type="text"
               name="name"
               value="<%= student.getName() %>"
               required>

        <br><br>

        Skills:<br>

        <input type="text"
               name="skills"
               value="<%= student.getSkills() %>"
               required>

        <br><br>

        Interest:<br>

        <input type="text"
               name="interest"
               value="<%= student.getInterest() %>"
               required>

        <br><br>

        <input type="submit" value="Update Student">

    </form>

<%
    }
%>

<br>

<a href="home">🏠 Back to Home</a>

</body>
</html>