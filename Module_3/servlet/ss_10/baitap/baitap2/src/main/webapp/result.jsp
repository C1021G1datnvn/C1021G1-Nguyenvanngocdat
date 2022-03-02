<%--
  Created by IntelliJ IDEA.
  User: datnvn
  Date: 1/26/2022
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Double parameter = (Double) request.getAttribute("result");
%>
<%=parameter%>
</body>
</html>
