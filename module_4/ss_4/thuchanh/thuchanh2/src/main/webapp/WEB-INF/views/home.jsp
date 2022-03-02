<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>
</head>
<body>
<h3>Home</h3>
<form action="login" method="post" modelAttribute="login">
  <fieldset>
    <legend>Login</legend>
    <table>
      <tr>
        <td>Account:</td>
        <td><input type="text" name="account"></td>
      </tr>
      <tr>
        <td>Password:</td>
        <td><input type="password" name="password"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" name="Login"></td>
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>