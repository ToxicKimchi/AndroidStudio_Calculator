package com.example.calculator;

import com.example.calculator.operations.AddSubtractOperation;
import com.example.calculator.operations.Operation;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ArithmeticHandler {
    private ArrayList<String> contents;

    public String calculate(ArrayList<String> contents) {
        this.contents = contents;

        //calculating all multiply and divide

        ArrayList<Operation> operations = new ArrayList<>();
        operations.add(new AddSubtractOperation());
        //operations.add(new)
        for (Operation o : operations) {
            processOperators(o);
            //processOperators('+','-');
        }


        //done to leave contents array empty
        String result = contents.get(0);
        contents.remove(0);
        return result;
    }

    private void processOperators(char x, char y) {

        while (contents.contains(Character.toString(x))
                || contents.contains(Character.toString(y))) {

            int index = findIndex(new char[]{x, y});
            processIndex(index);
        }
    }

    private int findIndex(char[] searchTerms) {
        //looking for first instance of + or -
        for (int i = 0; i < contents.size(); i++) {

            String result = contents.get(i);
            if (result.equals(Character.toString(searchTerms[0]))
                    || result.equals(Character.toString(searchTerms[1]))) {
                return i;
            }
        }

        //should never occur since we validate that a + or - exists before running
        return -1;
    }

    //receives index in array and processes the value before and after index
    private void processIndex(int index) {
        BigDecimal result = getResult(index);

        //not a typo removes the middle and last value used to calculate
        contents.remove(index);
        contents.remove(index);

        //replace first value with result
        contents.set(index - 1, result.toString());
    }

    private BigDecimal getResult(int index) {
        if (contents.size() == index + 1) {
            return new BigDecimal(contents.get(index - 1));
        }

        BigDecimal x = new BigDecimal(contents.get(index - 1));
        BigDecimal y = new BigDecimal(contents.get(index + 1));


        char operator = contents.get(index).charAt(0); //only 1 char anyway index is needed

        BigDecimal result;
        switch (operator) {
            case '+':
                result = x.add(y);
                break;

            case '-':
                result = x.subtract(y);
                break;

            case '*':
                result = x.multiply(y);
                break;

            case '/':
                result = x.divide(y);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }

        return result;
    }
}
