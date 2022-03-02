<%--
  Created by IntelliJ IDEA.
  User: datnvn
  Date: 2/11/2022
  Time: 1:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit product</h1>
<p>
  <c:if test="${requestScope['message']!= null}">
      <span class="message">${requestScope["message"]}</span>
  </c:if>
</p>
<p>
    <a href="/product">Back to list Product</a>
</p>
<form action="/product?action=update" method="post">
    <filedset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td></td>
                <td><input type="hidden" name="id" value="${requestScope["product"].getId()}"></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" id="
                name" value="${requestScope["product"].getNameProduct()}"></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="text" name="price" id="price" value="${requestScope["product"].getPrice()}"></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><input type="text" name="description" id="description" value="${requestScope["product"].getProductDescription()}"></td>
            </tr>
            <tr>
                <td>Manufacturer</td>
                <td><input type="text" name="manufacturer" id="manufacturer" value="${requestScope["product"].getManufacturer()}"></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Update Product">
                </td>
            </tr>
        </table>
    </filedset>
</form>
</body>
</html>
