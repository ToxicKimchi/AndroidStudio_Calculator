package com.example.calculator.operations;

import java.math.BigDecimal;

public class ExponentOperation extends SingleInputOperation {

    @Override
    public String[] setOperators() {
        return new String[]{"^"};
    }

    @Override
    public BigDecimal handleOperation(BigDecimal[] variables) {
        return new BigDecimal(0);
    }
}
