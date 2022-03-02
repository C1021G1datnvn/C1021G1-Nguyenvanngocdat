<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Service List</title>
    <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<a href="/Service?action=create">
    <button>Create Service</button>
</a>
<div align="center">
    <h1>
        <a href="/Service">Service List</a>
    </h1>

    <table border="" id="list" class="table table-striped table-bordered" style="width:70%">
        <thead>
        <tr>
            <th>Id Service</th>
            <th>Name Service</th>
            <th>Service Area</th>
            <th>Service Cost</th>
            <th>Service Max People</th>
            <th>Standard Room</th>
            <th>Description Other Convenience</th>
            <th>Pool Area</th>
            <th>Number Of Floors</th>
            <th>Rent Type Id</th>
            <th>Service Type Id</th>
            <th>Function</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="service" items="${serviceList}">
            <tr>
                <td>${service.getService_id()}</td>
                <td>${service.getService_name()}</td>
                <td>${service.getService_area()}</td>
                <td>${service.getService_cost()}</td>
                <td>${service.getService_max_people()}</td>
                <td>${service.getStandard_room()}</td>
                <td>${service.getDescription_other_convenience()}</td>
                <td>${service.getPool_area()}</td>
                <td>${service.getNumber_of_floors()}</td>
                <td>${service.getRent_type_name()}</td>
                <td>${service.getService_type_name()}</td>
                <td>
                    <a href="/Service?action=update&service_id=${service.getService_id()}">Update</a>
                    <button onclick="deleteCustomer('${service.getService_id()}','${service.getService_name()}')"
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
                Are you sure delete <span class="text-danger" id="service_name"></span> ?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button onclick="submitFormDelete()" type="button" class="btn btn-danger">Delete</button>
            </div>
        </div>
    </div>
</div>
<form hidden id="form-delete" method="post" action="/Service">
    <input type="text" name="action" value="delete">
    <input type="text" name="id" id="service_id">
</form>

<script>
    function deleteCustomer(id, name) {
        document.getElementById("service_id").value = id;
        document.getElementById("service_name").innerText = name;
    }

    function submitFormDelete() {
        document.getElementById("form-delete").submit();
    }
</script>
<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
<script src="/assert/bootstrap413/js/popper.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#list').DataTable();
    });
</script>
</html>