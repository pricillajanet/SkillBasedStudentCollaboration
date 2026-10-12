<%@ page import="java.util.List" %>
<%@ page import="com.skillcollaboration.skillbasedstudentcollaborationweb.model.CollaborationRequest" %>

<%
    List<CollaborationRequest> requests =
            (List<CollaborationRequest>) request.getAttribute("requests");
%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>My Collaboration Requests</title>

    <link rel="stylesheet" href="css/style.css">

    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

</head>

<body>

<h1>
    <i class="fa-solid fa-envelope"></i>
    My Collaboration Requests
</h1>

<table border="1" cellpadding="10">

    <tr>

        <th>Sender</th>

        <th>Status</th>

        <th>Date</th>

        <th>Action</th>

    </tr>

    <%
        if(requests == null || requests.isEmpty()){
    %>

    <tr>

        <td colspan="4">No Requests Found</td>

    </tr>

    <%
    } else {

        for(CollaborationRequest r : requests){
    %>

    <tr>

        <td><%= r.getSenderName() %></td>

        <td>

            <%
                if("PENDING".equals(r.getStatus())){
            %>

            <i class="fa-solid fa-clock" style="color:orange"></i>
            PENDING

            <%
            } else if("ACCEPTED".equals(r.getStatus())){
            %>

            <i class="fa-solid fa-circle-check" style="color:green"></i>
            ACCEPTED

            <%
            } else {
            %>

            <i class="fa-solid fa-circle-xmark" style="color:red"></i>
            REJECTED

            <%
                }
            %>

        </td>

        <td><%= r.getRequestDate() %></td>

        <td>

            <%
                if("PENDING".equals(r.getStatus())){
            %>

            <a href="acceptRequest?id=<%= r.getRequestId() %>">
                <i class="fa-solid fa-check"></i>
                Accept
            </a>

            &nbsp;&nbsp;

            <a href="rejectRequest?id=<%= r.getRequestId() %>">
                <i class="fa-solid fa-xmark"></i>
                Reject
            </a>

            <%
            } else if("ACCEPTED".equals(r.getStatus())){
            %>

            <span style="color:green;font-weight:bold;">
                    <i class="fa-solid fa-circle-check"></i>
                    Already Accepted
                </span>

            <%
            } else {
            %>

            <span style="color:red;font-weight:bold;">
                    <i class="fa-solid fa-circle-xmark"></i>
                    Already Rejected
                </span>

            <%
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

<a href="studentHome">
    <i class="fa-solid fa-arrow-left"></i>
    Back to Dashboard
</a>

</body>

</html>