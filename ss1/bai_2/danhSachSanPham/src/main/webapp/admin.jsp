<%@ page import="java.util.List" %>
<%@ page import="com.example.product.Product" %><%--
  Created by IntelliJ IDEA.
  User: macbookair
  Date: 20/03/2024
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Màn Hình Admin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
    <div class="container mt-5" style="">
        <h1>Danh Sách Sản Phẩm</h1>
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>Mã Sản Phẩm</th>
                <th>Tên Sản Phẩm</th>
                <th>Giá</th>
                <th>Số Lượng</th>
                <th>Hình Ảnh</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<Product> productList = (List<Product>) request.getAttribute("productList");
                for (Product product : productList) {
            %>
                <tr>
                    <td><%=product.getProductId()%></td>
                    <td><%=product.getProductName()%></td>
                    <td><%=product.getProductPrice()%></td>
                    <td><%=product.getProductQuantity()%></td>
                    <td>
                        <img src="<%= product.getProductImg() %>" alt="<%= product.getProductName()%>" width="100">
                    </td>
                </tr>

            <%
                }
            %>
            </tbody>
        </table>
    </div>

</body>
</html>
