<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/calculator" method="post">
    <input type="text" placeholder="Nhập tên sản phẩm" name="nameProduct">
    <input type="text" placeholder="Giá sản phẩm" name="price">
    <input type="text" placeholder="Phần trăm giảm" name="discountPercent">

    <input type="submit" value="ProductServlet">
  </form>
  </body>
</html>
