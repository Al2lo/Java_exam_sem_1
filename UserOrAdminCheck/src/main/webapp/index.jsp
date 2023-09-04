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
<form action="hello-servlet">
    <p>user</p>
    <input type="checkbox" value="true" name="user">
    <p>admin</p>
    <input type="checkbox" value="true" name="admin">
    <input type="text" value="" name="password">
    <input type="submit" value="go">
</form>
</body>
</html>