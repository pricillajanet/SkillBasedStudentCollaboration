<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search by Skill</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<h1>Skill-Based Student Collaboration System</h1>

<h2>Search Student by Skill</h2>

<form action="searchSkill" method="post">

    Enter Skill:<br>

    <input type="text" name="skill" required>

    <br><br>

    <input type="submit" value="Search">

</form>

<br>

<a href="home">🏠 Back to Home</a>

</body>
</html>