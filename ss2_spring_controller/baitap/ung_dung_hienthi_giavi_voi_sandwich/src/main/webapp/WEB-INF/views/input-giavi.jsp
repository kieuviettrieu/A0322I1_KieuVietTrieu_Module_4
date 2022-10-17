<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/16/2022
  Time: 1:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Checkbox</title>
</head>
<body>
<form method="post" action="/save">
    <h3>Sandwich Condiments</h3>
    <br>
    <input type="checkbox" name="condiment" value="Lettuce" />Lettuce<br/>
    <input type="checkbox" name="condiment" value="Tomato" />Tomato<br/>
    <input type="checkbox" name="condiment" value="Mustard" />Mustard<br/>
    <input type="checkbox" name="condiment" value="Sprouts" />Sprouts<br/>
    <input type="submit" value="Submit" />
</form>
</body>
</html>
