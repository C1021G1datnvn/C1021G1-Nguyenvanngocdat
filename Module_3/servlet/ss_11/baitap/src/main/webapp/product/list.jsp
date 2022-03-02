<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/10/2022
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center">Product</h1>
<p style="text-align: center">
    <a href="/product?action=create">Create new Product</a>
    <a href="/product?action=search">Search Product</a>
</p>
<table border="1" style="margin: auto">
    <tr>
        <th>Id</th>
        <th>NameProduct</th>
        <th>Price</th>
        <th>ProductDescription</th>
        <th>Manufacturer</th>
        <th>Function1</th>
        <th>Function2</th>
    </tr>

    <c:forEach var="products" items='${requestScope["product"]}'>
        <tr>
            <td>${products.getId()}</td>
            <td><a href="/product?action=view&id=${products.getId()}">${products.getNameProduct()}</a></td>
            <td>${products.getPrice()}</td>
            <td>${products.getProductDescription()}</td>
            <td>${products.getManufacturer()}</td>
            <td><a href="/product?action=update&id=${products.getId()}">Update</a></td>
            <td><a href="/product?action=remove&id=${products.getId()}">Remove</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
