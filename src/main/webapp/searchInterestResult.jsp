<%@ page import="java.util.ArrayList" %>
<%@ page import="com.skillcollaboration.skillbasedstudentcollaborationweb.model.Student" %>

<%
    ArrayList<Student> students =
            (ArrayList<Student>) request.getAttribute("students");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Interest Result</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<h1>Search Result</h1>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Skills</th>
        <th>Interest</th>
    </tr>

    <%
        if (students.isEmpty()) {
    %>
    <tr>
        <td colspan="4">No Students Found</td>
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
    </tr>

    <%
            }
        }
    %>

</table>

<br><br>

<a href="index.jsp">🏠 Back to Home</a>

</body>
</html>