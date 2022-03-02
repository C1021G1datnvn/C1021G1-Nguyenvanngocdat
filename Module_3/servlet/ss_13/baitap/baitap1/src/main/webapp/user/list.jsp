<%--
  Created by IntelliJ IDEA.
  User: datnvn
  Date: 2/16/2022
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">
</head>
<body>
<div align="center">
    <h1>List Player Soccer</h1>
    <form action="/users?action=search" method="post">
        <input type="text" name="search">
        <input type="submit" value="search">
    </form>
</div>
<div>
    <a href="/users?action=addUser">Add new player soccer</a>
</div>
<div align="center">
    <table border="1" id="list" class="table table-striped table-bordered" style="width:70%">
        <thead>
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Email</td>
            <td>Country</td>
            <td>Function</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${userList}">
            <tr>
                <td>${list.getId()}</td>
                <td>${list.getName()}</td>
                <td>${list.getEmail()}</td>
                <td>${list.getCountry()}</td>
                <td>
                    <a href="/users?action=delete&id=${list.getId()}">Delete</a>
                    <a href="/users?action=update&id=${list.getId()}">Update</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#list').DataTable();
    });
</script>
</html>
