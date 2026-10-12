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

    <title>My Sent Requests</title>

    <link rel="stylesheet" href="css/style.css">

    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

</head>

<body>

<h1>
    <i class="fa-solid fa-paper-plane"></i>
    My Sent Requests
</h1>

<table border="1" cellpadding="10">

    <tr>

        <th>Receiver</th>

        <th>Status</th>

        <th>Date</th>

    </tr>

    <%
        if(requests == null || requests.isEmpty()){
    %>

    <tr>

        <td colspan="3">No Requests Sent</td>

    </tr>

    <%
    } else {

        for(CollaborationRequest r : requests){
    %>

    <tr>

        <td><%= r.getReceiverName() %></td>

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

    </tr>

    <%
            }
        }
    %>

</table>

<br><br>

<a href="studentHome.jsp">

    <i class="fa-solid fa-arrow-left"></i>
    Back to Dashboard

</a>

</body>

</html>