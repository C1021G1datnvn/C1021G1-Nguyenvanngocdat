<%--
  Created by IntelliJ IDEA.
  User: datnvn
  Date: 2/14/2022
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Xoá Thông Tin Bệnh Án</h1>

<form action="/CenterServlet?action=delete" method="post">
    <h3>Bạn có muốn xoá không?</h3>
    <filedset>
        <legend>Thông Tin Bệnh Án</legend>
        <table>
            <tr>
                <td>Stt</td>
                <td><input type="hidden" name="stt" value="${delete.getStt()}"></td>
            </tr>
            <tr>
                <td>Mã Bệnh Án</td>
                <td><input type="text" name="maBenhAn" value="${delete.getMaBenhAn()}" readonly></td>
            </tr>
            <tr>
                <td>Mã Bệnh Nhân</td>
                <td><input type="text" name="maBenhNhan" value="${delete.getMaBenhNhan()}" readonly></td>
            </tr>
            <tr>
                <td>Tên Bệnh Nhân</td>
                <td><input type="text" name="tenBenhNhan" value="${delete.getTenBenhNhan()}"></td>
            </tr>
            <tr>
                <td>Ngày Nhập Viện</td>
                <td><input type="text" name="ngayNhapVien" value="${delete.getNgayNhapVien()}"></td>
            </tr>
            <tr>
                <td>Ngày Ra Viện</td>
                <td><input type="text" name="ngayRaVien" value="${delete.getNgayRaVien()}"></td>
            </tr>
            <tr>
                <td>Lí Do Nhập Viện</td>
                <td><input type="text" name="liDoNhapVien" value="${delete.getLidoNhapVien()}"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete"></td>
            </tr>
            <tr>
                <td>
                        <a href="/CenterServlet">Trở Về Danh Sách Bệnh Án</a>
                </td>
            </tr>
        </table>
    </filedset>
</form>
</body>
</html>
