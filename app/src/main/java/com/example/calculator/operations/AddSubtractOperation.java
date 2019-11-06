package com.example.calculator.operations;

import java.math.BigDecimal;

public class AddSubtractOperation extends Operation {

    @Override
    public String[] setOperators() {
        return new String[]{"+", "-"};
    }

    @Override
    public BigDecimal handleOperation(String operator, BigDecimal[] variables) {

        if (operator.equals("+")) {
            variables[0].add(variables[1]);
            return variables[0];
        } else if (operator.equals("-")) {
            variables[0].add(variables[1]);
            return variables[0];
        }

        return variables[0];
    }
}
