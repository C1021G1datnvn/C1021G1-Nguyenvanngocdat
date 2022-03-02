<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/22/2022
  Time: 9:06 AM
  To change this template use File | Settings | File Templates.
--%>
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
<h1 style="text-align: center; color: #007bff">Thêm mới sản phẩm</h1>
<div class="container-fluid">
    <div class="row">
        <div class="col-3">
        </div>
        <div class="col-9">
            <form action="/product?action=create" method="post" >
                <div class="form-group invalid">
                    <label for="name-customer">Name</label>
                    <input type="text" class="form-control" id="name-customer" name="name" required placeholder="VD:Phạm Duy Thuận">
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="birthday">Price</label>
                    <input type="text" class="form-control" id="birthday" name="price" placeholder="" >
                </div>
                <div class="form-group">
                    <label for="code-customer">Quantily</label>
                    <input type="text" class="form-control" id="code-customer" name="quantily">
                </div>
                <div class="form-group">
                    <label for="phone-customer">Color</label>
                    <input type="text" class="form-control" id="phone-customer" name="color">
                </div>

                <div class="form-group">
                    <label for="category">NameCategory</label>
                    <select class="form-control" id="category" name="idCategory">
                        <c:forEach var="type" items="${categoryList}">
                            <option value="${type.idCategory}">${type.nameCategory}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>

<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
<script src="/assert/bootstrap413/js/popper.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>
</body>
</html>
