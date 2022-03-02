<%--
  Created by IntelliJ IDEA.
  User: datnvn
  Date: 2/16/2022
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/users?action=addUser" method="post">
  <table>
    <tr>
      <td>Name</td>
      <td><input type="text" name="name"></td>
    </tr>
    <tr>
      <td>Email</td>
      <td><input type="text" name="email"></td>
    </tr>
    <tr>
      <td>Country</td>
      <td><input type="text" name="country"></td>
    </tr>
    <tr>
      <td><input type="submit" value="Add New"></td>
    </tr>
  </table>
</form>

</body>
</html>
