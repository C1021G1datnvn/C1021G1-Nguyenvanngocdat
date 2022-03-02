<%--
  Created by IntelliJ IDEA.
  User: datnvn
  Date: 1/26/2022
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Simple Calculator</h2>
  <form action="/CalculatorServlet" method="post">
    <input type="text" name="firstOperand" placeholder="Input Number one">
    <select name="operator">
      <option value="add">Add</option>
      <option value="sub">Sub</option>
      <option value="mul">Mul</option>
      <option value="div">Div</option>
    </select>
    <input type="text" name="lastOperand" placeholder="Input Number two">
    <input type="submit" value="Calculate">
  </form>
  </body>
</html>
