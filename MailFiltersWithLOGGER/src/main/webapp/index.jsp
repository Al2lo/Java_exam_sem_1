<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form action="out.jsp">
    <p>PHONE:
        <input type="text" name="phone"value="">
    </p>
    <p>MAIL:
        <input type="text" name="mail" value="">
    </p>
    <input type="submit" value="GO">
</form>
</body>
</html>