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
<form>
    <input type="text" name="loginName" value="">
    <input type="submit" value="sign in" formaction="hello-servlet">
</form>
</body>
</html>