<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

  <title>Login</title>
</head>
<body>
<div>
  <form action="/authenticate" method="POST">
    email:<br>
    <input type="text" name="email"><br>
    password:<br>
    <input type="password" name="password"><br>
    <input type="submit" value="Login">
  </form>
</div>
</body>
</html>
