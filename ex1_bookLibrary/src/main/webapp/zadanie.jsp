<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04.06.2023
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table id="operatorTable">
    <tr>
        <th>author</th>
        <th>   book_name</th>
        <th>publication_year</th>
        <th>pages</th>
    </tr>
<c:forEach items="${knigi}" var="item">
<tr>
    <th>${item.getAuthor()}</th>
    <th>${item.getBook_name()}</th>
    <th>${item.getPublication_year()}</th>
    <th>${item.getPages()}</th>

</tr>
</c:forEach>

</table>

<form action="hello-servlet">
    <input type="submit" value="NEXT">
</form>
</body>
</html>
