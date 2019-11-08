package com.example.calculator.operations;

import java.math.BigDecimal;

public abstract class Operation {
    public String[] operators;

    public Operation() {
        operators = setOperators();
    }

    public abstract String[] setOperators();

    public String[] getOperators() {
        return operators;
    }
}
