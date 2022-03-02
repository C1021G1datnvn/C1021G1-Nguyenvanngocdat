<%--
  Created by IntelliJ IDEA.
  User: datnvn
  Date: 2/14/2022
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Cập Nhật Bệnh Án</h1>
<p>
    <a href="/CenterServlet">Trở Về Danh Sách Bệnh Án</a>
</p>
<form method="post" action="/CenterServlet?action=update">
    <filedset>
        <legend>Thông Tin Bệnh Án</legend>
        <table>
            <tr>
                <td>Stt</td>
                <td><input type="hidden" name="stt" value="${update.getStt()}"></td>
            </tr>
            <tr>
                <td>Mã Bệnh Án</td>
                <td><input type="text" name="maBenhAn" value="${update.getMaBenhAn()}" readonly></td>
            </tr>
            <tr>
                <td>Mã Bệnh Nhân</td>
                <td><input type="text" name="maBenhNhan" value="${update.getMaBenhNhan()}" readonly></td>
            </tr>
            <tr>
                <td>Tên Bệnh Nhân</td>
                <td><input type="text" name="tenBenhNhan" value="${update.getTenBenhNhan()}"></td>
            </tr>
            <tr>
                <td>Ngày Nhập Viện</td>
                <td><input type="text" name="ngayNhapVien" value="${update.getNgayNhapVien()}"></td>
            </tr>
            <tr>
                <td>Ngày Ra Viện</td>
                <td><input type="text" name="ngayRaVien" value="${update.getNgayRaVien()}"></td>
            </tr>
            <tr>
                <td>Lí Do Nhập Viện</td>
                <td><input type="text" name="liDoNhapVien" value="${update.getLidoNhapVien()}"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Update"></td>
            </tr>
        </table>
    </filedset>
</form>
</body>
</html>
