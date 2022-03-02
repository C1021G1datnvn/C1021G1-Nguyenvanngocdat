<%--
  Created by IntelliJ IDEA.
  User: datnvn
  Date: 2/19/2022
  Time: 8:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit Customer</h1>
<p>
    <a href="/CaseStudy">Back to list Customer</a>
</p>
<form action="/CaseStudy?action=update" method="post">
    <filedset>
        <table border="1" align="center">
            <tr>

                <th>Customer Id</th>
                <td><input type="text" name="customer_id" value="${customer.getCustomer_id()}" readonly></td>
            </tr>
            <tr>
                <th>Customer Name</th>
                <td><input type="text" name="customer_name" value="${customer.getCustomer_name()}"></td>
            </tr>
            <tr>
                <th>Customer Birthday</th>
                <td><input type="text" name="customer_birthday" value="${customer.getCustomer_birthday()}"></td>
            </tr>
            <tr>
                <th>Customer Gender</th>
                <td><input type="text" name="customer_gender" value="${customer.getCustomer_gender() ? "Nam" : "Nữ"}"></td>
            </tr>
            <tr>
                <th>Customer Id Card</th>
                <td><input type="text" name="customer_id_card" value="${customer.getCustomer_id_card()}"></td>
            </tr>
            <tr>
                <th>Customer Phone</th>
                <td><input type="text" name="customer_phone" value="${customer.getCustomer_phone()}"></td>
            </tr>
            <tr>
                <th>Customer Phone</th>
                <td><input type="text" name="customer_email" value="${customer.getCustomer_email()}"></td>
            </tr>
            <tr>
                <th>Customer Address</th>
                <td><input type="text" name="customer_address" value="${customer.getCustomer_address()}"></td>
            </tr>
            <tr>
                <th>Customer Type Id</th>
                <td><select name="customer_type_id" id="customer_type_id">
                    <option value="1">Diamond</option>
                    <option value="2">Platinum</option>
                    <option value="3">Gold</option>
                    <option value="4">Sliver</option>
                    <option value="5">Member</option>
                </select></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Update">
                </td>
            </tr>
        </table>
    </filedset>
</form>
</body>
</html>
