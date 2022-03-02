
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h1>Create Employee</h1>
    <form action="/Employee?action=create" method="post">
        <table border="1">
            <tr>
                <td>Employee Name</td>
                <td><input type="text" name="employee_name" id="employee_name"></td>
            </tr>
            <tr>
                <td>Employee Birthday</td>
                <td><input type="text" name="employee_birthday" id="employee_birthday"></td>
            </tr>
            <tr>
                <td>Employee Id Card</td>
                <td><input type="text" name="employee_id_card" id="employee_id_card"></td>
            </tr>
            <tr>
                <td>Employee Salary</td>
                <td><input type="text" name="employee_salary" id="employee_salary"></td>
            </tr>
            <tr>
                <td>Employee Phone</td>
                <td><input type="text" name="employee_phone" id="employee_phone"></td>
            </tr>
            <tr>
                <td>Employee Email</td>
                <td><input type="text" name="employee_email" id="employee_email"></td>
            </tr>
            <tr>
                <td>Employee Address</td>
                <td><input type="text" name="employee_address" id="employee_address"></td>
            </tr>
            <tr>
                <td>Posision Id</td>
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
                        <input type="submit" value="Create">
                    </td>
                </tr>
        </table>
    </form>
</div>
</body>
</html>
