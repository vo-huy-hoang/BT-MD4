<%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 20/03/2024
  Time: 08:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tra cứu</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
    <h1>Từ Điển</h1>
    <form action="dictionary" method="get" onsubmit="return validateForm()" class="row g-3">
        <div class="col-auto">
            <input value="${englishWord}" type="text" class="form-control" id="english-word" placeholder="Nhập từ tiếng anh" id="english-word" name="englishWord">
        </div>
        <div class="col-auto">
            <button type="submit" class="btn btn-primary mb-3">Tìm Kiếm</button>
        </div>
        <p class="text-danger" id="error-english-word"></p>
    </form>

<%--    Hiển thị kết quả từ Servlet--%>
    <h3 class="text-success">${vietnameseMeaning == null ? 'Không tìm thấy' : vietnameseMeaning}</h3>
    <script src="jquery-3.7.1.min.js"></script>
    <script>
        function validateForm() {
            let englishWordInput = $('#english-word').val();
            if (englishWordInput.trim() === "") {
                $('#error-english-word').text('vui lòng nhập từ tiếng anh')
                return false;
            }
            return true;
        }
    </script>


</body>
</html>
