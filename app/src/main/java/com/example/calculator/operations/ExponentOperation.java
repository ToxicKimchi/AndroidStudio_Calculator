package com.example.calculator.operations;

import java.math.BigDecimal;

public class ExponentOperation extends SingleInputOperation {

    @Override
    public String[] setOperators() {
        return new String[]{"^"};
    }

    @Override
    public BigDecimal handleOperation(BigDecimal[] variables) {
        BigDecimal result = variables[0];

        BigDecimal addBy = new BigDecimal(variables[0].intValue());
        for (int i = 0; i < variables[1].intValue() - 1; i++) {
            result = result.multiply(addBy);
        }

        BigDecimal percent = new BigDecimal(variables[1].doubleValue() - variables[1].intValue());
        result = result.add(variables[0].multiply(percent));

        return result;
    }
}
