package com.example.calculator;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CalculatorServlet", value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String firstNumberStr = request.getParameter("firstNumber");
        String secondNumberStr = request.getParameter("secondNumber");
        // đưa dữ liệu về lại cho client
        request.setAttribute("firstNumber", firstNumberStr); // giữ nguyên giá trị ở phần nhập
        request.setAttribute("secondNumber", secondNumberStr); // giữ nguyên giá trị ở phần nhập

        if ("".equals(firstNumberStr)) {
            request.setAttribute("errorFirstNumber", "Không được để trống");
        } else if ("".equals(secondNumberStr)) {
            request.setAttribute("errorSecondNumber", "Không được để trống");
        } else if (!MathUtil.isDouble(firstNumberStr)) {
            request.setAttribute("errorFirstNumber", "Phải nhấp số!");
        } else if (!MathUtil.isDouble(secondNumberStr)) {
            request.setAttribute("errorSecondNumber", "Phải nhấp số!");
        } else {
            double firstNumber = Double.parseDouble(firstNumberStr);
            double secondNumber = Double.parseDouble(secondNumberStr);
            double result = 0;
            String operator = request.getParameter("operator");

            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                case "/":
                    if (secondNumber == 0) {
                        request.setAttribute("errorSecondNumber", "Mẫu phải khác 0!");
                        request.getRequestDispatcher("/calculator.jsp").forward(request, response);
                    }
                    result = firstNumber / secondNumber;
            }
            request.setAttribute("result", result);
        }
        request.getRequestDispatcher("/calculator.jsp").forward(request, response);
//        response.sendRedirect("calculator.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

    }
}
