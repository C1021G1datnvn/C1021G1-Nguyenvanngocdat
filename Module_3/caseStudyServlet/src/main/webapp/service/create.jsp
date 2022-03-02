<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
</head>
<body>
<div align="center">
    <h1>Create Service</h1>
    <form method="post" action="/Service?action=create">
        <table border="1">
            <tr>
                <td>Service Name</td>
                <td><input type="text" name="service_name" id="service_name"></td>
            </tr>
            <tr>
                <td>Service Area</td>
                <td><input type="text" name="service_area" id="service_area"></td>
            </tr>
            <tr>
                <td>Service Cost</td>
                <td><input type="text" name="service_cost" id="service_cost"></td>
            </tr>
            <tr>
                <td>Service Max People</td>
                <td><input type="text" name="service_max_people" id="service_max_people"></td>
            </tr>
            <tr>
                <td>Standard Room</td>
                <td><input type="text" name="standard_room" id="standard_room"></td>
            </tr>
            <tr>
                <td>Description Other Convenience</td>
                <td><input type="text" name="description_other_convenience" id="description_other_convenience"></td>
            </tr>
            <tr>
                <td>Pool Area</td>
                <td><input type="text" name="pool_area" id="pool_area"></td>
            </tr>
            <tr>
                <td>Number Of Floors</td>
                <td><input type="text" name="number_of_floors" id="number_of_floors"></td>
            </tr>
            <tr>
                <td>Rent Type Id</td>
                <td><select name="rent_type_id" id="rent_type_id">
                    <option value="4">Hour</option>
                    <option value="3">Day</option>
                    <option value="2">Month</option>
                    <option value="1">Year</option>
                </select></td>
            </tr>
            <tr>
                <td>Service Type Id</td>
                <td><select name="service_type_id" id="service_type_id">
                    <option value="1">Villa</option>
                    <option value="2">House</option>
                    <option value="3">Room</option>
                </select></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Create">
                </td>
            </tr>
        </table>
    </form>
</div>
<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
<script src="/assert/bootstrap413/js/popper.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>
</body>
</html>
