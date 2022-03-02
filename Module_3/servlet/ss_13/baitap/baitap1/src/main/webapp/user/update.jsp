<%--
  Created by IntelliJ IDEA.
  User: datnvn
  Date: 2/16/2022
  Time: 10:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    Player Soccer information
</h1>
<form method="post" action="/users?action=update">
<table>
    <tr>
        <td></td>
        <td><input type="hidden" name="id" value="${user.getId()}"></td>
    </tr>
    <tr>
        <td>Name</td>
        <td><input type="text" name="name" value="${user.getName()}"></td>
    </tr>
    <tr>
        <td>Email</td>
        <td><input type="text" name="email" value="${user.getEmail()}"></td>
    </tr>
    <tr>
        <td>Country</td>
        <td><input type="text" name="country" value="${user.getCountry()}"></td>
    </tr>
    <tr>
        <td><input type="submit" value="update"></td>
    </tr>
</table>
</form>
</body>
</html>
