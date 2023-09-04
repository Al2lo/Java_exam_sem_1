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
    <input type="submit" value="GET" formaction="hello-servlet" formmethod="get">
    <input type="submit" value="POST" formaction="hello-servlet" formmethod="post">
</form>

<p>Time: ${cookie.time.value}</p>
<p>Method: ${cookie.method.value}</p>

</body>
</html>