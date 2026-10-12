<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String role = (String) session.getAttribute("role");

    if (!"ADMIN".equals(role)) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<h1>🎓 Skill-Based Student Collaboration System</h1>

<h2>Admin Dashboard</h2>

<h3>
    👥 Total Students :
    <%= request.getAttribute("totalStudents") %>
</h3>

<div class="menu">

    <a class="menu-btn" href="addStudent.jsp">➕ Add Student</a>
    <a class="menu-btn" href="viewStudents">👥 View Students</a>
    <a class="menu-btn" href="viewCollaborationRequests">👥 View Collaboration Requests</a>
    <a class="menu-btn" href="searchSkill.jsp">🔍 Search by Skill</a>
    <a class="menu-btn" href="searchInterest.jsp">❤️ Search by Interest</a>
    <a class="menu-btn" href="updateStudent.jsp">✏️ Update Student</a>
    <a class="menu-btn" href="deleteStudent.jsp">🗑 Delete Student</a>
    <a class="menu-btn" href="exportExcel">📊 Download Excel Report</a>
    <a class="menu-btn" href="logout">🚪 Logout</a>

</div>

</body>
</html>