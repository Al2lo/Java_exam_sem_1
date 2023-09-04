<%@ page import="com.example.like_dislike.Message" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04.06.2023
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>${message.getText()}</h2>
    <h3>likes: ${message.getLikes()}</h3>
    <h3>dislikes: ${message.getDislikes()}</h3>
</body>

<form>
    <input type="submit" value="like" formaction="likeServlet">
    <input type="submit" value="dislike" formaction="disLikeServlet">
</form>
</html>
