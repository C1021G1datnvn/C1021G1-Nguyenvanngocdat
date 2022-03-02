
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/save" method="post">
    <input id="lettuce" type="checkbox" name="condiment" value="Lettuce">
    <label for="lettuce">Lettuce</label>
    <input id="tomato" type="checkbox" name="condiment" value="Tomato">
    <label for="tomato">Tomato</label>
    <input id="mustard" type="checkbox" name="condiment" value="Mustard">
    <label for="mustard">Mustard</label>
    <input id="sprouts" type="checkbox" name="condiment" value="Sprouts">
    <label for="sprouts">Sprouts</label>
    <input type="submit" name="Save">
  </form>
  <h1>Các gia vị mà bạn đã chọn là:</h1>
  <c:forEach var="sandwich" items="${save}">
      <p>${sandwich}</p>
  </c:forEach>
  </body>
</html>
