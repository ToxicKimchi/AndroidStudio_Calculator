package com.example.calculator;

public class StringUtil {
    private static final char[] OPERATOR = new char[] { '+', '-', '/', '*' };

    public static boolean isOperator(String input) {
        for (char operator : OPERATOR) {
            if (input.equals(Character.toString(operator))) {
                return true;
            }
        }

        return false;
    }
}
