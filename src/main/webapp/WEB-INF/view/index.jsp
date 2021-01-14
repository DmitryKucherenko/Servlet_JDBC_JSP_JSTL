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
        <td>Name</td>
        <td>Last name</td>
        <td>Age</td>
        <td>Update</td>
        <td>Delete</td>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="user" items="${users}">
        <tr>
            <td><c:out value="${user.first_name}"/></td>
            <td><c:out value="${user.last_name}"/></td>
            <td><c:out value="${user.age}"/></td>
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
    <input type="submit" value="Ok" name="Ok"><br>
</form>

</body>
</html>
