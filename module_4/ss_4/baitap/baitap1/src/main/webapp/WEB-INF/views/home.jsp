<%--
  Created by IntelliJ IDEA.
  User: datnvn
  Date: 3/2/2022
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Settings</h1>
<form:form action="update" modelAttribute="setting" method="post" >
    <table >
        <tr>
            <td>Languages: </td>
            <td><form:select path="languages">
                <form:options items="${listLanguages}"/>
            </form:select>
            </td>
        </tr>
        <tr>
            <td>Page Size:</td>
            <td>Show <form:select path="size">
                <form:options items="${listSize}"/>
            </form:select>email per page
            </td>
        </tr>
        <tr>
            <td>Spams Filter:</td>
            <td><form:radiobutton path="filter"/>Enable spams filter</td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td><form:textarea path="signature"/></td>
        </tr>
    </table>
        <button type="submit">Update</button>
        <button type="reset">Cancel</button>
</form:form>
</body>
</html>
