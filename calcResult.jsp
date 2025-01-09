<%--
  Created by IntelliJ IDEA.
  User: jyj42
  Date: 2025-01-08
  Time: 오후 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Num1 ${param.num1}</h1> <!--expression language: 변수 추출-->
    <h1>Num2 ${param.num2}</h1> <!--전달되는 모든 데이터는 문자열 처리-->

    <h1>SUM ${Integer.parseInt(param.num1) + Integer.parseInt(param.num2)}</h1>
    <!--따로 Java식으로 parseInt를 하고 연산을 해야 적용됨-->
</body>
</html>
