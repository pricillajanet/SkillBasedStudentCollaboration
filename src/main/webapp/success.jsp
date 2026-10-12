<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Successful</title>

    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<h1>✅ Registration Successful!</h1>

<h2>Your Student ID is:</h2>

<h1>
    <%= request.getAttribute("studentId") %>
</h1>

<p>
    Please remember this Student ID.
    You can use it to log in to your account.
</p>

<br>

<div class="menu">

    <a class="menu-btn" href="login.jsp">
        🔐 Login
    </a>

    <a class="menu-btn" href="home">
        🏠 Home
    </a>

</div>

</body>
</html>