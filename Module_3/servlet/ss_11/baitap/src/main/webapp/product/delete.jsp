<%--
  Created by IntelliJ IDEA.
  User: datnvn
  Date: 2/11/2022
  Time: 11:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Delete Product</h1>
<p>
    <a href="/product">Back to list Product</a>
</p>
<form method="post" action="/product?action=delete">
    <h3>Are you sure</h3>
    <filedset>
        <legend>
            Product information
        </legend>
        <table>
            <input type="hidden" name="id" value="${product.getId()}">
            <tr>
                <td>Id</td>
                <td>${requestScope["product"].getId()}</td>
            </tr>
            <tr>
                <td>Name Product</td>
                <td>${requestScope["product"].getNameProduct()}</td>
            </tr>
            <tr>
                <td>Price</td>
                <td>${requestScope["product"].getPrice()}</td>
            </tr>
            <tr>
                <td>Description</td>
                <td>${requestScope["product"].getProductDescription()}</td>
            </tr>
            <tr>
                <td>Manufacturer</td>
                <td>${requestScope["product"].getManufacturer()}</td>
            </tr>
            <tr>
                <td><input type="submit", value="Delete Product"></td>
                <td><a href="/product">Back to list Product</a></td>
            </tr>
        </table>
    </filedset>
</form>
</body>
</html>
