<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Student</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<h1>Skill-Based Student Collaboration System</h1>

<h2>Delete Student</h2>

<form action="deleteStudent" method="post">

    Student ID:<br>

    <input type="number" name="id" required>

    <br><br>

    <input type="submit" value="Delete Student">

</form>

<br>

<a href="home">🏠 Back to Home</a>

</body>
</html>