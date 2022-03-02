<%--
  Created by IntelliJ IDEA.
  User: datnvn
  Date: 2/21/2022
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h1>Update Employee</h1>
    <form action="/Employee?action=update" method="post">
        <table border="1">
            <tr>
                <th>Id Employee</th>
                <td><input type="text" name="employee_id" value="${employee.getEmployee_id()}" readonly></td>
            </tr>
            <tr>
                <th>Name Employee</th>
                <td><input type="text" name="employee_name" value="${employee.getEmployee_name()}"></td>
            </tr>
            <tr>
                <th>Birthday Employee</th>
                <td><input type="text" name="employee_birthday" value="${employee.getEmployee_birthday()}"></td>
            </tr>
            <tr>
                <th>Employee id Card</th>
                <td><input type="text" name="employee_id_card" value="${employee.getEmployee_id_card()}"></td>
            </tr>
            <tr>
                <th>Employee Salary</th>
                <td><input type="text" name="employee_salary" value="${employee.getEmployee_salary()}"></td>
            </tr>
            <tr>
                <th>Employee Phone</th>
                <td><input type="text" name="employee_phone" value="${employee.getEmployee_phone()}"></td>
            </tr>
            <tr>
                <th>Employee Email</th>
                <td><input type="text" name="employee_email" value="${employee.getEmployee_email()}"></td>
            </tr>
            <tr>
                <th>Employee Address</th>
                <td><input type="text" name="employee_address" value="${employee.getEmployee_address()}"></td>
            </tr>
            <tr>
                <th>Position Id</th>
                <td><select name="position_id" id="position_id">
                    <option value="1">Quản Lý</option>
                    <option value="2">Nhân Viên</option>
                    <option value="3">Lễ tân</option>
                    <option value="4">Phục vụ</option>
                    <option value="5">Chuyên viên</option>
                    <option value="6">Giám sát</option>
                    <option value="7">Giám đốc</option>
                </select></td>
            </tr>
            <tr>
                <td>Education Degree Id</td>
                <td><select name="education_degree_id" id="education_degree_id">
                    <option value="1">Trung Cấp</option>
                    <option value="2">Cao Đẳng</option>
                    <option value="3">Đại Học</option>
                    <option value="4">Sau Đại Học</option>
                </select></td>
            </tr>
            <tr>
                <td>Division Id</td>
                <td><select name="division_id" id="division_id">
                    <option value="1">Sale-Marketting</option>
                    <option value="2">Hành Chính</option>
                    <option value="3">Dịch Vụ</option>
                    <option value="4">Quản Lí</option>
                </select></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Update">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
