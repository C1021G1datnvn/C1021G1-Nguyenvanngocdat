<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
</head>
<body>
<div align="center">
    <h1>Create Customer</h1>
    <form method="post" action="/CaseStudy?action=create">
        <table border="1">
            <tr>
                <td>Customer Name</td>
                <td><input type="text" name="customer_name" id="customer_name"></td>
            </tr>
            <tr>
                <td>Customer Birthday</td>
                <td><input type="date" name="customer_birthday" id="customer_birthday"></td>
            </tr>
            <tr>
                <td>Customer Gender</td>
                <td><select name="customer_gender" id="customer_gender">
                    <option value="true">Nam</option>
                    <option value="false">Nữ</option>
                </select></td>
            </tr>
            <tr>
                <td>Customer Id Card</td>
                <td><input type="text" name="customer_id_card" id="customer_id_card"></td>
            </tr>
            <tr>
                <td>Customer Phone</td>
                <td><input type="text" name="customer_phone" id="customer_phone"></td>
            </tr>
            <tr>
                <td>Customer Email</td>
                <td><input type="text" name="customer_email" id="customer_email"></td>
            </tr>
            <tr>
                <td>Customer Address</td>
                <td><input type="text" name="customer_address" id="customer_address"></td>
            </tr>
            <tr>
                <td>Customer Type Id</td>
                <td><select name="customer_type_id" id="customer_type_id">
                    <option value="5">Member</option>
                    <option value="4">Sliver</option>
                    <option value="3">Gold</option>
                    <option value="2">Platinum</option>
                    <option value="1">Diamond</option>
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
