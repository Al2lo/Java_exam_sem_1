<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="myshortname" uri="tagdirectory" %>
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
    <input type="text" name="text">
    <input type="submit" value="check">
</form>
<c:if test="${param.text != null}">
    <p><c:out value="${myshortname:check(param.text) ? 'Корректно' : 'Некорректно'}"/></p>
</c:if>
</body>
</html>