<%--
  Created by IntelliJ IDEA.
  User: datnvn
  Date: 3/1/2022
  Time: 4:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/Calculate" method="post">
    <label for="num1">Số đầu tiên</label>
    <input type="text" name="num1" id="num1">
    <select name="calculate" id="calculate">
      <option value="Add">Add</option>
      <option value="Sub">Sub</option>
      <option value="Mul">Mul</option>
      <option value="Div">Div</option>
    </select>
    <input type="text" name="num2" id="num2">
    <label for="num2">Số thứ hai</label>
    <input type="submit" name="Submit">
  </form>
  <h3>Kết quả: ${result}</h3>
  </body>
</html>
