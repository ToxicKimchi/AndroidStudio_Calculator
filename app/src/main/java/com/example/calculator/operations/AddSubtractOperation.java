package com.example.calculator.operations;

public class AddSubtractOperation extends Operation {

    @Override
    public String[] setOperators() {
        return new String[]{"+", "-"};
    }

    @Override
    public void handleOperation(String operator) {
        if (operator.equals("+")) {

        } else if (operator.equals("-")) {

        }
    }
}
