<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<a href="/CaseStudy?action=create">
    <button>Create</button>
</a>
<div align="center">
        <h1>
            <a href="/CaseStudy">Customer List</a>
        </h1>
    <form action="/CaseStudy?action=search" method="post">
        <input type="text" name="customer_name" placeholder="search">
        <input type="submit" value="Search">
    </form>

    <table border="" id="list" class="table table-striped table-bordered" style="width:70%">
        <thead>
        <tr>
            <th>Id Customer</th>
            <th>Name Customer</th>
            <th>Customer Birthday</th>
            <th>Customer Gender</th>
            <th>Customer Id Card</th>
            <th>Customer Phone</th>
            <th>Customer Email</th>
            <th>Customer Address</th>
            <th>Customer Type Name</th>
            <th>Function</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${customerList}">
            <tr>
                <td>${customer.getCustomer_id()}</td>
                <td>${customer.getCustomer_name()}</td>
                <td>${customer.getCustomer_birthday()}</td>
                <td>${customer.getCustomer_gender() ? 'Nam':'Nữ'}</td>
                <td>${customer.getCustomer_id_card()}</td>
                <td>${customer.getCustomer_phone()}</td>
                <td>${customer.getCustomer_email()}</td>
                <td>${customer.getCustomer_address()}</td>
                <td>${customer.getCustomer_type_name()}</td>
                <td>
                    <a href="/CaseStudy?action=update&customer_id=${customer.getCustomer_id()}">Update</a>
                    <button onclick="deleteCustomer('${customer.getCustomer_id()}','${customer.getCustomer_name()}')" type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">
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
                Are you sure delete <span class="text-danger" id="customer_name"></span> ?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button onclick="submitFormDelete()" type="button" class="btn btn-danger">Delete</button>
            </div>
        </div>
    </div>
</div>
<form hidden id="form-delete" method="post" action="/CaseStudy">
    <input type="text" name="action" value="delete">
    <input type="text" name="id" id="customer_id">
</form>

<script>
    function deleteCustomer(id, name) {
        document.getElementById("customer_id").value = id;
        document.getElementById("customer_name").innerText = name;
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
</body>
<script>
$(document).ready(function() {
$('#list').DataTable();
} );
</script>
</html>
