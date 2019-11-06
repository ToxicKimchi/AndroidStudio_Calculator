package com.example.calculator.operations;

import java.math.BigDecimal;

public class MultiplyDivideOperation extends Operation {
    @Override
    public String[] setOperators() {
        return new String[]{"*", "/"};
    }

    @Override
    public BigDecimal handleOperation(String operator, BigDecimal[] variables) {
        BigDecimal result = new BigDecimal(0);

        if (operator.equals("*")) {
            result = variables[0].multiply(variables[1]);
        } else if (operator.equals("/")) {
            result = variables[0].divide(variables[1]);
        }

        return result;
    }
}
