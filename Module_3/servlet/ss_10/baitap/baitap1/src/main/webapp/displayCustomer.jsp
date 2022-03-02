<%--
  Created by IntelliJ IDEA.
  User: datnvn
  Date: 1/26/2022
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            font-family: Arial;
        }
    </style>
</head>
<body>
<h2>Danh Sách Hiển Thị</h2>
<table border="1px">
    <tr>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach var="customers" items="${customer}">
        <tr>
            <td>${customers.name}</td>
            <td>${customers.birthday}</td>
            <td>${customers.address}</td>
            <td><img src="${customers.img}" width="100px"></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
