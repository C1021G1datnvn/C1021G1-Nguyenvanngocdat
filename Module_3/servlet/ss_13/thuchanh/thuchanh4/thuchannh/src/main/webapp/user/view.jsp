<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/14/2022
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Users Information</h1>
<p>
    <a href="/users">Back to list Users</a>
</p>
<table border="1">
    <tr>
        <td>Name</td>
        <td>${users.getName()}</td>
    </tr>
    <tr>
        <td>Email</td>
        <td>${users.getEmail()}</td>
    </tr>
    <tr>
        <td>Country</td>
        <td>${users.getCountry()}</td>
    </tr>
</table>
</body>
</html>
