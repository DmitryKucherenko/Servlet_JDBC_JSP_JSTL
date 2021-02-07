<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update user</title>
</head>
<body>
<h2>Update a user's info</h2>
<form method="post" action="\update">
    <input type="number" hidden name="id" value="${user.id}">
    <label><input type="text" name="first_name" value="${user.firstName}"></label>Name<br>
    <label><input type="text" name="last_name" value="${user.lastName}"></label>Last Name<br>
    <label><input type="number" name="age" value="${user.age}"></label>Age<br>
    <label><input type="text" name="login" value="${user.login}"></label>Login<br>
    <label><input type="text" name="password" value="${user.password}"></label>Password<br>
    <input type="submit" value="Ok" name="Ok"><br>
</form>

</body>
</html>
