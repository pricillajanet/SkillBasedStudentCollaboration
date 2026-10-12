<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Student Registration</title>

    <link rel="stylesheet" href="css/style.css">

    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

</head>

<body>

<h1>
    <i class="fa-solid fa-user-plus"></i>
    Student Registration
</h1>

<form action="register" method="post">

    <!-- Name -->
    <label>
        <i class="fa-solid fa-user"></i>
        Name
    </label>

    <br>

    <input type="text"
           name="name"
           placeholder="Enter your name"
           required>

    <br><br>


    <!-- Password -->
    <label>
        <i class="fa-solid fa-lock"></i>
        Password
    </label>

    <br>

    <input type="password"
           name="password"
           placeholder="Enter your password"
           required>

    <br><br>


    <!-- Skills -->
    <label>
        <i class="fa-solid fa-code"></i>
        Skills
    </label>

    <br>

    <input type="text"
           name="skills"
           placeholder="Example: Java, SQL, HTML"
           required>

    <br><br>


    <!-- Interest -->
    <label>
        <i class="fa-solid fa-heart"></i>
        Interest
    </label>

    <br>

    <input type="text"
           name="interest"
           placeholder="Example: Web Development"
           required>

    <br><br>


    <!-- Register -->
    <button type="submit">

        <i class="fa-solid fa-user-plus"></i>
        Register

    </button>

</form>

<br>

<p>
    Already have an account?

    <a href="login.jsp">
        <i class="fa-solid fa-right-to-bracket"></i>
        Login Here
    </a>
</p>

</body>

</html>