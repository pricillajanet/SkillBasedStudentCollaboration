<%@ page import="java.util.List" %>
<%@ page import="com.skillcollaboration.skillbasedstudentcollaborationweb.model.Student" %>

<%
    List<Student> collaborators =
            (List<Student>) request.getAttribute("collaborators");
%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>My Collaborators</title>

    <link rel="stylesheet" href="css/style.css">

    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

</head>

<body>

<h1>

    <i class="fa-solid fa-user-group"></i>

    My Collaborators

</h1>

<table border="1" cellpadding="10">

    <tr>

        <th>Name</th>

        <th>Skills</th>

        <th>Interest</th>

    </tr>

    <%
        if (collaborators == null || collaborators.isEmpty()) {
    %>

    <tr>

        <td colspan="3">

            No Collaborators Yet

        </td>

    </tr>

    <%
    } else {

        for (Student s : collaborators) {
    %>

    <tr>

        <td><%= s.getName() %></td>

        <td><%= s.getSkills() %></td>

        <td><%= s.getInterest() %></td>

    </tr>

    <%
            }
        }
    %>

</table>

<br><br>

<a href="studentHome">

    <i class="fa-solid fa-arrow-left"></i>

    Back to Dashboard

</a>

</body>

</html>