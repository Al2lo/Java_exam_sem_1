<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>
${out}
</h1>
<br/>
<form>
    <input type="text" value="" name="group">
    <input type="text" value="" name="course">
    <input type="text" value="" name="spec">
    <input type="submit" value="submit" formaction="hello-servlet">
    <input type="submit" value="clean cookie" formaction="clearServlet">
</form>
</body>
</html>