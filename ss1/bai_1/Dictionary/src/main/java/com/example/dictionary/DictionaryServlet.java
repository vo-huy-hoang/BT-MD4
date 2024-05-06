package com.example.dictionary;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "DictionaryServlet", value = "/dictionary")
public class DictionaryServlet extends HttpServlet {
    private static Map<String, String> dictionaryMap;

    static {
        dictionaryMap = new HashMap<>();
        dictionaryMap.put("hello", "xin chào");
        dictionaryMap.put("cat", "con mèo");
        dictionaryMap.put("dog", "con chó");
        dictionaryMap.put("car", "ô tô");
        dictionaryMap.put("apple", "quả táo");
        dictionaryMap.put("banana", "quả chuối");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String englishWord = request.getParameter("englishWord");
        String vietnameseMeaning = dictionaryMap.get(englishWord);

        request.setAttribute("vietnameseMeaning", vietnameseMeaning);
        request.setAttribute("englishWord", englishWord); // đưa englishWord xuống cho file jsp
        request.getRequestDispatcher("/dictionary.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    }
}
