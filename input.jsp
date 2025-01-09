<%--
  Created by IntelliJ IDEA.
  User: jyj42
  Date: 2025-01-08
  Time: 오후 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/calc/makeResult" method="post"> <!--get에서 post로-->
        <input type="number" name="num1"> <!--숫자형 입력(화살표로 조절 가능)-->
        <input type="number" name="num2">
        <button type="submit">SEND</button>
    </form>
</body>
</html>
