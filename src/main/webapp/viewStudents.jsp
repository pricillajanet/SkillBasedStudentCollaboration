<%@ page import="java.util.ArrayList" %>
<%@ page import="com.skillcollaboration.skillbasedstudentcollaborationweb.model.Student" %>

<%
    ArrayList<Student> students =
            (ArrayList<Student>) request.getAttribute("students");

    String role = (String) session.getAttribute("role");

    Student loggedStudent =
            (Student) session.getAttribute("student");
%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>View Students</title>

    <link rel="stylesheet" href="css/style.css">

    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

</head>

<body>

<h1>
    <i class="fa-solid fa-user-group"></i>
    Skill-Based Student Collaboration System
</h1>

<h2>All Students</h2>

<table>

    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Skills</th>
        <th>Interest</th>
        <th>Actions</th>
    </tr>

    <%
        if (students == null || students.isEmpty()) {
    %>

    <tr>
        <td colspan="5">No Students Found</td>
    </tr>

    <%
        } else {
            for (Student student : students) {
    %>

    <tr>

        <td><%= student.getId() %></td>

        <td><%= student.getName() %></td>

        <td><%= student.getSkills() %></td>

        <td><%= student.getInterest() %></td>

        <td>

            <%
                if ("ADMIN".equals(role)) {
            %>

            <a class="edit-btn"
               href="editStudent?id=<%= student.getId() %>">

                <i class="fa-solid fa-pen-to-square"></i>
                Edit

            </a>

            &nbsp;&nbsp;

            <a class="delete-btn"
               href="deleteStudent.jsp?id=<%= student.getId() %>">

                <i class="fa-solid fa-trash"></i>
                Delete

            </a>

            <%
                }
                else if ("STUDENT".equals(role)) {

                    if (loggedStudent != null &&
                        loggedStudent.getId() == student.getId()) {
            %>

            <span style="color:green;font-weight:bold;">

                <i class="fa-solid fa-user-check"></i>
                This is You

            </span>

            <%
                    } else {
            %>

            <a class="menu-btn"
               href="sendRequest?receiverId=<%= student.getId() %>">

                <i class="fa-solid fa-handshake"></i>
                Send Request

            </a>

            <%
                    }
                }
            %>

        </td>

    </tr>

    <%
            }
        }
    %>

</table>

<br><br>

<a href="<%= "ADMIN".equals(role) ? "home" : "studentHome" %>">

    <i class="fa-solid fa-house"></i>
    Back to Home

</a>

</body>

</html>