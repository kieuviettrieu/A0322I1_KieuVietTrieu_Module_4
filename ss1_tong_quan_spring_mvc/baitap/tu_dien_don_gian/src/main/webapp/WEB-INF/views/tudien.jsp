<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/14/2022
  Time: 12:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/showform">
    <h3>Tra cứu từ điển</h3>
    <label>English:</label>
    <input name="keytudien" type="text" value="${keytudien}">
<%--    <c:if test="${check==1}">--%>
<%--        <input name="keytudien" type="text" value="${keytudien}">--%>
<%--    </c:if>--%>
    <input type="submit" value="Search">
</form>

<c:if test="${check==1}">
    <p>Tiếng Việt: ${result}</p>
</c:if>
</body>
</html>
