<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.skillcollaboration.skillbasedstudentcollaborationweb.model.Student" %>

<%
    Student student = (Student) session.getAttribute("student");

    if (student == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    Integer pendingCount = (Integer) request.getAttribute("pendingCount");

    if (pendingCount == null) {
        pendingCount = 0;
    }
%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Student Dashboard</title>

    <link rel="stylesheet" href="css/style.css">

    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

</head>

<body>

<h1>
    <i class="fa-solid fa-user-graduate"></i>
    Student Dashboard
</h1>

<h2>
    Welcome,
    <%= student.getName() %>
</h2>

<hr>

<h3>
    <i class="fa-solid fa-id-card"></i>
    My Profile
</h3>

<p>
    <b>ID :</b>
    <%= student.getId() %>
</p>

<p>
    <b>Name :</b>
    <%= student.getName() %>
</p>

<p>
    <b>Skills :</b>
    <%= student.getSkills() %>
</p>

<p>
    <b>Interest :</b>
    <%= student.getInterest() %>
</p>

<br>

<div class="menu">

    <a class="menu-btn" href="viewStudents">
        <i class="fa-solid fa-users"></i>
        View Students
    </a>

    <a class="menu-btn" href="myRequests">
        <i class="fa-solid fa-envelope"></i>
        My Requests (<%= pendingCount %>)
    </a>

    <a class="menu-btn" href="mySentRequests">
        <i class="fa-solid fa-paper-plane"></i>
        My Sent Requests
    </a>

    <a class="menu-btn" href="myCollaborators">
        <i class="fa-solid fa-user-group"></i>
        My Collaborators
    </a>
    <a class="menu-btn" href="searchSkill.jsp">
        <i class="fa-solid fa-magnifying-glass"></i>
        Search by Skill
    </a>

    <a class="menu-btn" href="searchInterest.jsp">
        <i class="fa-solid fa-heart"></i>
        Search by Interest
    </a>

    <a class="menu-btn" href="logout">
        <i class="fa-solid fa-right-from-bracket"></i>
        Logout
    </a>
    <a class="menu-btn" href="editProfile">
        <i class="fa-solid fa-user-pen"></i>
        Edit Profile
    </a>

</div>

</body>

</html>