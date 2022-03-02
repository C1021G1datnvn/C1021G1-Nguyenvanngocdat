<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>

<h1 style="text-align: center ; color: lightgoldenrodyellow">List Product</h1>
<div class="container">

    <table>
        <tr>
            <td><a class="btn btn-success" href="/product?action=create">Add New</a></td>
            <td>
            <td>
                <form action="/product?action=search" method="post">
                    <input type="text" name="name" placeholder="search name">
                    <input type="submit" value="Search">
                </form>
            </td>
            </td>
        </tr>
    </table>

    <table id="product" border="1" class="table table-success">
        <thead>
        <tr>
            <th class="col-1">ID</th>
            <th class="col-1">NameProduct</th>
            <th class="col-1">Price</th>
            <th class="col-1">Quantily</th>
            <th class="col-1">Color</th>
            <th class="col-1">Category</th>
            <th class="col-2">Funtion</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${productList}">
            <tr>
                <td>${product.idProduct}</td>
                <td>${product.nameProduct}</td>
                <td>${product.price}</td>
                <td>${product.quantily}</td>
                <td>${product.color}</td>
                <td>${product.nameCategory}</td>
                <td>
                    <a href="/product?action=update&id=${product.getIdProduct()}">
                        <button class="btn btn-primary">Edit</button>
                    </a>
                    <button onclick="deleteCustomer('${product.getIdProduct()}','${product.getNameProduct()}')"
                            type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">
                        Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>


<!-- Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure delete <span class="text-danger" id="name-product"></span> ?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button onclick="submitFormDelete()" type="button" class="btn btn-danger">Delete</button>
            </div>
        </div>
    </div>
</div>


<form hidden id="form-delete" method="post" action="/product">
    <input type="text" name="action" value="delete">
    <input type="text" name="id" id="id-product">
</form>

<script>
    function deleteCustomer(id, name) {
        document.getElementById("id-product").value = id;
        document.getElementById("name-product").innerText = name;
    }

    function submitFormDelete() {
        document.getElementById("form-delete").submit();
    }
</script>


<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
<script src="/assert/bootstrap413/js/popper.min.js"></script>
<script src="/assert/datatables/js/jquery.dataTables.min.js"></script>
<script src="/assert/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>
<script>
    $(document).ready(function () {
        $('#product').DataTable();
    });
</script>
</body>
</html>