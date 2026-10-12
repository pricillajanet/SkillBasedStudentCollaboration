<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.skillcollaboration.skillbasedstudentcollaborationweb.model.Student" %>

<%
    Student student = (Student) request.getAttribute("student");
%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Edit Profile</title>

    <link rel="stylesheet" href="css/style.css">

    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

</head>

<body>

<h1>
    <i class="fa-solid fa-user-pen"></i>
    Edit My Profile
</h1>

<form action="updateProfile" method="post">

    <input type="hidden"
           name="id"
           value="<%= student.getId() %>">

    <label>Name</label><br>

    <input type="text"
           name="name"
           value="<%= student.getName() %>"
           required>

    <br><br>

    <label>Skills</label><br>

    <input type="text"
           name="skills"
           value="<%= student.getSkills() %>"
           required>

    <br><br>

    <label>Interest</label><br>

    <input type="text"
           name="interest"
           value="<%= student.getInterest() %>"
           required>

    <br><br>

    <button type="submit">
        <i class="fa-solid fa-floppy-disk"></i>
        Save Changes
    </button>

</form>

<br>

<a href="studentHome">
    <i class="fa-solid fa-arrow-left"></i>
    Back to Dashboard
</a>

</body>

</html>