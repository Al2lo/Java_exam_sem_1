<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04.06.2023
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="OperationServlet">
    <input type="submit" value="INFO" name="command">

    <input type="submit" value="PAY" name="command">

    <input type="submit" value="ADD" name="command">

    <input type="text" name="hhh" value="${textValue}" >
</form>
</body>
</html>
