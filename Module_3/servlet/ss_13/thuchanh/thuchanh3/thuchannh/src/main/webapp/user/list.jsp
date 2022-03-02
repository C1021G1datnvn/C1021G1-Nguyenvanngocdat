<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/13/2022
  Time: 1:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">
</head>
<body>
<center>
    <q>
        <h1> <a href="/users">User Management</a></h1>
    </q>

    <h2>
        <a href="/users?action=create">Add New User</a>
    </h2>
    <form action="/users?action=search" method="post">
        <input type="text" name="country">
        <input type="submit" value="Search">
    </form>

</center>
<div align="center">
    <table cellpadding="5" id="list" class="table table-striped table-bordered" style="width:70%" border="1">
        <caption><h2>List of Users</h2></caption>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><a href="/users?action=view&id=${user.id}"><c:out value="${user.id}"/></a></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a href="/users?action=edit&id=${user.id}">Edit</a>
                    <a href="/users?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#list').DataTable();
    });
</script>
</body>
</html>
