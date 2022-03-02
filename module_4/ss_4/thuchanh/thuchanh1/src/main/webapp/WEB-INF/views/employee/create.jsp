<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Create a new employee</title>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>
<form method="POST" action="addEmployee" modelAttribute="employee">
    <table>
        <tr>
            <td>Employee ID:</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>Employee's name:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Contact's number:</td>
            <td><input type="text" name="contactNumber"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form>
</body>
</html>