<%@ page import="java.util.List" %>
<%@ page import="com.skillcollaboration.skillbasedstudentcollaborationweb.model.CollaborationRequest" %>

<%
    String role = (String) session.getAttribute("role");

    if (!"ADMIN".equals(role)) {
        response.sendRedirect("login.jsp");
        return;
    }

    List<CollaborationRequest> requests =
            (List<CollaborationRequest>) request.getAttribute("requests");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Collaboration Requests</title>

    <link rel="stylesheet" href="css/style.css">

    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
</head>

<body>

<h1>
    <i class="fa-solid fa-handshake"></i>
    Collaboration Requests
</h1>

<h2>All Collaboration Requests</h2>

<table>
    <tr>
        <th>Request ID</th>
        <th>Sender</th>
        <th>Receiver</th>
        <th>Status</th>
        <th>Request Date</th>
    </tr>

    <%
        if (requests == null || requests.isEmpty()) {
    %>

    <tr>
        <td colspan="5">No Collaboration Requests Found</td>
    </tr>

    <%
        } else {
            for (CollaborationRequest requestItem : requests) {
    %>

    <tr>
        <td><%= requestItem.getRequestId() %></td>
        <td><%= requestItem.getSenderName() %></td>
        <td><%= requestItem.getReceiverName() %></td>
        <td><%= requestItem.getStatus() %></td>
        <td><%= requestItem.getRequestDate() %></td>
    </tr>

    <%
            }
        }
    %>

</table>

<br><br>

<a href="home">
    <i class="fa-solid fa-house"></i>
    Back to Home
</a>

</body>
</html>