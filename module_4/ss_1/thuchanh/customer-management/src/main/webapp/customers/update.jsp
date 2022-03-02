<%--
  Created by IntelliJ IDEA.
  User: datnvn
  Date: 2/28/2022
  Time: 8:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Update Customer</h1>
<form action="/customers?action=update" method="post">
    <table border="1">
        <tr>
            <th>Id</th>
            <td>${customers.getId()}</td>
        </tr>
        <tr>
            <th>Name</th>
            <td>${customers.getName()}</td>
        </tr>
        <tr>
            <th>Email</th>
            <td>${customers.getEmail()}</td>
        </tr>
        <tr>
            <th>Address</th>
            <td>${customers.getAddress()}</td>
        </tr>
    </table>
</form>
</body>
</html>
