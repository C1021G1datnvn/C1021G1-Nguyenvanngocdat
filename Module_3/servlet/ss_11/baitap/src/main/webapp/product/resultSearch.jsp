<%--
  Created by IntelliJ IDEA.
  User: datnvn
  Date: 2/12/2022
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    <a href="/product">Back to list Product</a>
</p>
<c:choose>
    <c:when test="${message == null}">
        <c:forEach var="product" items="${products}">
            <table>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th>Manufacturer</th>
                </tr>
                <tr>
                    <td>${product.getId()}</td>
                    <td>${product.getNameProduct()}</td>
                    <td>${product.getPrice()}</td>
                    <td>${product.getProductDescription()}</td>
                    <td>${product.getManufacturer()}</td>
                </tr>
            </table>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <h1>${message}</h1>
    </c:otherwise>
</c:choose>
</body>
</html>
