<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Student</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<h1>Skill-Based Student Collaboration System</h1>

<h2>Add Student</h2>

<form action="addStudent" method="post">

    Name:<br>
    <input type="text" name="name" required>

    <br>

    Skills:<br>
    <input type="text" name="skills" required>

    <br>

    Interest:<br>
    <input type="text" name="interest" required>

    <br><br>

    <input type="submit" value="Add Student">

</form>

<br>

<a href="home">🏠 Back to Home</a>

</body>
</html>