
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css">
    <style>
        *{
            background: #20c997;
        }
    </style>
</head>
<body>
<h1 style="background: #007bff; text-align: center">Chức năng update sản phẩm</h1>
<form action="/product?action=update" method="post">
    <table class="table table-striped">
        <tr>
            <th>ID</th>
            <td><input  type="text" name="id" value="${list.idProduct}" readonly></td>
        </tr>
        <tr>
            <th>NameProduct</th>
            <td><input type="text" name="nameproduct" value="${list.nameProduct}"></td>
        </tr>
        <tr>
            <th>Price</th>
            <td><input type="text" name="price" value="${list.price}"></td>
        </tr>

        <tr>
            <th>Quantily</th>
            <td><input type="text" name="quantily" value="${list.quantily}"></td>
        </tr>
        <tr>
            <th>Color</th>
            <td><input type="text" name="color" value="${list.color}"></td>
        </tr>

        <tr>
            <th>Category</th>
            <td>
                <select id="category" name="idcategory">
                    <c:forEach var="category" items="${categoryList}">
                        <option value="${category.idCategory}">${category.nameCategory}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Update"></td>
        </tr>

    </table>

</form>

<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
<script src="/assert/bootstrap413/js/popper.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>
</body>
</html>
