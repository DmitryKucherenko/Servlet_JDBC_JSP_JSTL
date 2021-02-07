<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>User info</title>
    <meta charset="UTF-8">
    <style>
        td{text-align: center;}
    </style>
</head>
<body>
<h2>All users</h2>

<table border="1" cellspacing="0" cellpadding="0" width="400px">
    <thead>
    <tr>
        <td>№</td>
        <td>Имя</td>
        <td>Фамилия</td>
        <td>Возраст</td>
        <td>Логин</td>
        <td>Пароль</td>
        <td>Update</td>
        <td>Delete</td>
    </tr>
    </thead>
    <tbody>




    <c:forEach var="user" items="${users}" varStatus="сounter" >
        <tr>
            <td><c:out value="${сounter.count}"/></td>
            <td><c:out value="${user.firstName}"/></td>
            <td><c:out value="${user.lastName}"/></td>
            <td><c:out value="${user.age}"/></td>
            <td><c:out value="${user.login}"/></td>
            <td><c:out value="${user.password}"/></td>
            <td><a href='<c:url value="/update?id=${user.id}" />'>update</a></td>
            <td><a href='<c:url value="/delete?id=${user.id}" />'>delete</a></td>
        </tr>
    </c:forEach>

    </tbody>


</table>

<h2>Create a new user</h2>
<form method="post" action="\add">
    <label><input type="text" name="first_name" ></label>Name<br>
    <label><input type="text" name="last_name" ></label>Last Name<br>
    <label><input type="number" name="age"></label>Age<br>
    <label><input type="text" name="login"></label>Login<br>
    <label><input type="number" name="password"></label>Password<br>
    <input type="submit" value="Ok" name="Ok"><br>
</form>


<a href='<c:url value="/logout" />'>logout</a>

</body>
</html>
