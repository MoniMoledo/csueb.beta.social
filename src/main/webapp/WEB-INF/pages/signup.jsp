<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../CSS/signup_stylesheet.css" rel="stylesheet" type="text/css"/>
    <link rel="shortcut icon" href="../IMAGES/static_ico.ico">
    <title>Sign up</title>
</head>
<body class="darkGreen">
<div class="mainDiv">

    <form class="mainForm" action="/register">
        First name<br>
        <input type="text" name="first_name"><br>
        Last name<br>
        <input type="text" name="last_name"><br>
        Email<br>
        <input type="email" name="email"><br>
        Password<br>
        <input type="password" name="password"><br>
        Gender<br>
        <select class="styled-select">
            <option value="Male">Male</option>
            <option value="Female">Female</option>
        </select>
        <br><br>
        <input class="greenButton" type="submit" value="Register">
        <img class="actionIcons" src="../IMAGES/home.png" onclick="location.href='../'">
    </form>
</div>
</body>
</html>
