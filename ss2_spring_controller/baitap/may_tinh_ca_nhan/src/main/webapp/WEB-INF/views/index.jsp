<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h2>Caculator</h2>
<br/>
<form method="post">
    <input type="number" name="number1" placeholder="0" value="${number1}">
    <input type="number" name="number2" placeholder="0" value="${number2}">

    <br><br>
    <input type="submit" formaction="/addition" value="Addtion(+)">
    <input type="submit" formaction="/subtraction" value="Subtraction(-)">
    <input type="submit" formaction="/multiplication" value="Multiplication(X)">
    <input type="submit" formaction="/division" value="Division(/)">
</form>

<br>
<br>
<h5>Result ${str} ${result}</h5>
</body>
</html>