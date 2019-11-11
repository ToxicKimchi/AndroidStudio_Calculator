package com.example.calculator.operations;

import java.math.BigDecimal;

public abstract class MultiInputOperation extends Operation {

    public abstract BigDecimal handleOperation(String operator, BigDecimal[] variables);
}
