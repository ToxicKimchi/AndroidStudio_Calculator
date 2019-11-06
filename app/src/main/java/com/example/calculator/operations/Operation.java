package com.example.calculator.operations;

public abstract class Operation {
    public String[] operators;

    public Operation() {
        operators = setOperators();
    }

    public abstract String[] setOperators();

    public abstract void handleOperation(String operator);

    public String[] getOperators() {
        return operators;
    }
}
