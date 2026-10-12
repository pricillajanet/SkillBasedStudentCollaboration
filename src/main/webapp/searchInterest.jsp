<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search by Interest</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<h1>Skill-Based Student Collaboration System</h1>

<h2>Search Student by Interest</h2>

<form action="searchInterest" method="post">

    Enter Interest:<br>

    <input type="text" name="interest" required>

    <br><br>

    <input type="submit" value="Search">

</form>

<br>

<a href="index.jsp">🏠 Back to Home</a>

</body>
</html>