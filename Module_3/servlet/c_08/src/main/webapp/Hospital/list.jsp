<%--
  Created by IntelliJ IDEA.
  User: datnvn
  Date: 2/13/2022
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">
</head>
<body>
<h1 align="center">Danh Sách Bệnh Án</h1>
<div align="center">
    <table border="1" id="bang">
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã Bệnh Án</th>
            <th>Mã Bênh Nhân</th>
            <th>Tên Bệnh Nhân</th>
            <th>Ngày Nhập Viện</th>
            <th>Ngày Ra Viện</th>
            <th>Lý Do Nhập Viện</th>
            <th>Tác Vụ</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="benhAn" items="${hosoBenhAn}">
            <tr>
                <td>${benhAn.getStt()}</td>
                <td>${benhAn.getMaBenhAn()}</td>
                <td>${benhAn.getMaBenhNhan()}</td>
                <td>${benhAn.getTenBenhNhan()}</td>
                <td>${benhAn.getNgayNhapVien()}</td>
                <td>${benhAn.getNgayRaVien()}</td>
                <td>${benhAn.getLidoNhapVien()}</td>
                <td>
                    <a href="/CenterServlet?action=update&maBenhAn=${benhAn.getMaBenhAn()}">Edit</a>
                    <a href="/CenterServlet?action=delete&maBenhAn=${benhAn.getMaBenhAn()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#bang').DataTable();
    });
</script>
</body>
</html>
