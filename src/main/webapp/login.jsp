<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Login</title>

    <link rel="stylesheet" href="css/style.css">

    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

</head>

<body>

<h1>
    <i class="fa-solid fa-lock"></i>
    Login
</h1>

<form action="login" method="post">

    <label>Username / Student ID</label><br>

    <input type="text"
           name="username"
           required>

    <br><br>

    <label>Password</label><br>

    <input type="password"
           name="password"
           required>

    <br><br>

    <button type="submit">
        <i class="fa-solid fa-right-to-bracket"></i>
        Login
    </button>

</form>

<br>

<p>
    New student?
    <a href="register.jsp">
        <i class="fa-solid fa-user-plus"></i>
        Register Here
    </a>
</p>

</body>

</html>