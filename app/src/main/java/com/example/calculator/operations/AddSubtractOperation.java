package com.example.calculator.operations;

import java.math.BigDecimal;

public class AddSubtractOperation extends MultiInputOperation {

    @Override
    public String[] setOperators() {
        return new String[]{"+", "-"};
    }

    @Override
    public BigDecimal handleOperation(String operator, BigDecimal[] variables) {
        BigDecimal result = new BigDecimal(0);

        if (operator.equals("+")) {
            result = variables[0].add(variables[1]);
        } else if (operator.equals("-")) {
            result = variables[0].subtract(variables[1]);
        }

        return result;
    }
}
