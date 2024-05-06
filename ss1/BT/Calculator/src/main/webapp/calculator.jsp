<%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 19/03/2024
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>tinh toan</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<form action="calculator" method="get">
    <div class="mb-3">
        <label for="firstNumber" class="form-label">so thu 1</label>
        <input value="${firstNumber}" type="text" class="form-control" id="firstNumber" name="firstNumber">
        <p class="text-danger">${errorFirstNumber}</p>
    </div>
    <div class="mb-3">
        <label for="secondNumber" class="form-label">so thu 2</label>
        <input value="${secondNumber}" type="text" class="form-control" id="secondNumber" name="secondNumber">
        <p class="text-danger">${errorSecondNumber}</p>
    </div>
    <div class="mb-3">
        <label for="operator" class="form-label">Phép Toán</label>
        <select class="form-select" id="operator" name="operator">
            <option value="+">Cộng</option>
            <option value="-">Trừ</option>
            <option value="*">Nhân</option>
            <option value="/">Chia</option>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Tính Toán</button>
</form>
<h3>Kết quả là: ${result}</h3>
</body>
</html>
