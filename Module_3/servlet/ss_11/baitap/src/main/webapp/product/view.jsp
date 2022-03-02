<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/10/2022
  Time: 3:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <h1>Product details</h1>
<p>
    <a href="/product">Back To Product</a>
</p>
<table border="1">
 <tr>
     <td>NameProduct</td>
     <td>${requestScope["product"].getNameProduct()}</td>
 </tr>
    
    <tr>
        <td>Price</td>
        <td>${requestScope["product"].getPrice()}</td>
    </tr>

    <tr>
        <td>ProductDescription</td>
        <td>${requestScope["product"].getProductDescription()}</td>
    </tr>

    <tr>
        <td>ProductDescription</td>
        <td>${requestScope["product"].getManufacturer()}</td>
    </tr>
    
</table>
</body>
</html>
