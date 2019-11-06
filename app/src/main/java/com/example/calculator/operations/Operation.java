package com.example.calculator.operations;

import java.math.BigDecimal;

public abstract class Operation {
    public String[] operators;

    public Operation() {
        operators = setOperators();
    }

    public abstract String[] setOperators();

    public abstract BigDecimal handleOperation(String operator, BigDecimal[] variables);

    public String[] getOperators() {
        return operators;
    }
}
