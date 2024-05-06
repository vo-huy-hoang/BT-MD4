package com.example.danhsachsanpham;

import com.example.product.Product;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList = new ArrayList<>();

        productList.add(new Product("SP001", "Iphone 14promax", 2000000, 30, "https://product.hstatic.net/200000409445/product/14-max-tim_6dc05b654a3943fb8e9b03883b223d04_master.jpg"));
        productList.add(new Product("SP002", "Iphone 14promax", 2000000, 30, "https://product.hstatic.net/200000409445/product/14-max-tim_6dc05b654a3943fb8e9b03883b223d04_master.jpg"));
        productList.add(new Product("SP003", "Iphone 14promax", 2000000, 30, "https://product.hstatic.net/200000409445/product/14-max-tim_6dc05b654a3943fb8e9b03883b223d04_master.jpg"));
        productList.add(new Product("SP004", "Iphone 14promax", 2000000, 30, "https://product.hstatic.net/200000409445/product/14-max-tim_6dc05b654a3943fb8e9b03883b223d04_master.jpg"));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.contains("user") && password.contains("user")) {
            request.setAttribute("productList", productList);
            request.getRequestDispatcher("/user.jsp").forward(request, response);
            return;
        }
        if (username.contains("admin") && password.contains("admin")) {
            request.setAttribute("productList", productList);
            request.getRequestDispatcher("/admin.jsp").forward(request, response);
            return;
        }
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
