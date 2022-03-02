<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee List</title>
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css">

</head>
<body>
<a href="/Employee?action=create">
    <button>Create Employee</button>
</a>
<div align="center">
    <h1>
        <a href="/Employee">Employee List</a>
    </h1>
    <form action="/Employee?action=search" method="post">
        <input type="text" name="employee_name" placeholder="search">
        <input type="submit" value="Search">
    </form>

    <table id="list" class="table table-striped table-bordered" style="width:70%">
        <thead>
        <tr>
            <th>Employee Id</th>
            <th>Employee Name</th>
            <th>Employee Birthday</th>
            <th>Employee Id Card</th>
            <th>Employee Salary</th>
            <th>Employee Phone</th>
            <th>Employee Email</th>
            <th>Employee Address</th>
            <th>Position Id</th>
            <th>Education Degree Id</th>
            <th>Division Id</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="employee" items="${employee}">
            <tr>
                <td>${employee.getEmployee_id()}</td>
                <td>${employee.getEmployee_name()}</td>
                <td>${employee.getEmployee_birthday()}</td>
                <td>${employee.getEmployee_id_card() }</td>
                <td>${employee. getEmployee_salary()}</td>
                <td>${employee.getEmployee_phone()}</td>
                <td>${employee.getEmployee_email()}</td>
                <td>${employee.getEmployee_address()}</td>
                <td>${employee.getPosition_name()}</td>
                <td>${employee.getEducation_degree_name()}</td>
                <td>${employee.getDivision_name() }</td>
                <td>
                    <a href="/Employee?action=update&employee_id=${employee.getEmployee_id()}">Update</a>
                    <button onclick="deleteCustomer('${employee.getEmployee_id()}','${employee.getEmployee_name()}')" type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">
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
                Are you sure delete <span class="text-danger" id="employee_name"></span> ?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button onclick="submitFormDelete()" type="button" class="btn btn-danger">Delete</button>
            </div>
        </div>
    </div>
</div>
<form hidden id="form-delete" method="post" action="/Employee">
    <input type="text" name="action" value="delete">
    <input type="text" name="id" id="employee_id">
</form>

<script>
    function deleteCustomer(id, name) {
        document.getElementById("employee_id").value = id;
        document.getElementById("employee_name").innerText = name;
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