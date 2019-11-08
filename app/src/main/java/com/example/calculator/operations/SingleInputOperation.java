package com.example.calculator.operations;

import java.math.BigDecimal;

public abstract class SingleInputOperation extends Operation {

    public abstract BigDecimal handleOperation(BigDecimal[] variables);
}
