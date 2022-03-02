<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/10/2022
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create new product</h1>
<p>
    <c:if test='${requestScope["message"]!=null}'>
      <span>${requestScope["message"]}</span>
    </c:if>
</p>

<p>
    <a href="/product">Back to product list</a>
</p>

<form action="/product?action=create" method="post">

<table border="1">
    <h2>Product informaiton</h2>

        <tr>
            <td>IdProduct:</td>
            <td><input type="text" name="id" id="id"></td>
        </tr>

        <tr>
            <td>NameProduct:</td>
            <td><input type="text" name="nameProduct" id="nameProduct"></td>
        </tr>

        <tr>
            <td>Price:</td>
            <td><input type="text" name="price" id="price"></td>
        </tr>

        <tr>
            <td>ProductDescription:</td>
          <td><input type="text" name="productDescription" id="productDescription"></td>
        </tr>
        <tr>
            <td>Manufacturer:</td>
            <td><input type="text" name="manufacturer" id="manufacturer"></td>
        </tr>

        <tr>
            <td><input type="submit" value="Create Product"></td>
        </tr>

</table>
</form>
</body>
</html>
