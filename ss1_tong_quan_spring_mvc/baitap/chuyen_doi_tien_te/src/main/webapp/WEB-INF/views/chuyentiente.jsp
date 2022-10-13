<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/13/2022
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/showtiente">
    <h3>Chuyển đổi tiền tệ</h3>
    <label>USD</label>
    <input name="usd" type="number" min="0" required value="${usd}">

    <label>Tỉ giá</label>
    <input name="tigia" type="number" min="0" required value="${tigia}">

    <input type="submit" value="Submit">
</form>

<c:if test="${check==1}">
    <p>${result} VND</p>
</c:if>
</body>
</html>
