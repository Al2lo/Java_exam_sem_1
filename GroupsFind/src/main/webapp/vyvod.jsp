<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 06.06.2023
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br >
<br>
<form>
  <tr>
    <td>  Group</td>
    <td>  FullName</td>
  </tr></br>
  <c:forEach var="item" items="${groups}">
    <tr>
      <td>  ${item.getGroup()}</td>
      <td>  ${item.getFullName()}</td>
    </tr><br>
  </c:forEach>
  <p>${countGr}</p></br>
  <input type="submit" value="COUNT" formaction="getCount">
  <input type="submit" value="HOME" formaction="index.jsp">
</form>
</body>
</html>
