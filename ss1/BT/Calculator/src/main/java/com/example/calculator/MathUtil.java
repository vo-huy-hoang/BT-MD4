package com.example.calculator;

public class MathUtil {
    public static boolean isDouble(String target) {
        try {
            Double.parseDouble(target);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
