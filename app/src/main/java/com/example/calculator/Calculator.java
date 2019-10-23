package com.example.calculator;

import java.util.ArrayList;

public class Calculator {
    //information specifically on storing input from user
    private ArrayList<String> contents = new ArrayList<String>();
    private String stagingArea = "";
    private final char[] OPERATOR = new char[] { '+', '-', '/', '*' };

    public void receiveInput(String input) {
        if (isOperator(input)) {
            if (!stagingArea.equals("")) {
                contents.add(stagingArea);
                stagingArea = "";
            }

            contents.add(input);

        } else {
            stagingArea += input;
        }
    }

    public String outputDisplay() {
        String output = "";

        for (String item : contents) {
            output += item;
            output += " ";
        }

        output += stagingArea;
        return output;
    }

    public String calculate() {
        contents.add(stagingArea);
        stagingArea = "";

        //calculating all multiply and divide
        while (contents.contains("*") || contents.contains("/")) {
            int index = findIndex(new char[] { '*', '/'});
            processIndex(index);
        }

        //calculating all add and subtract
        while (contents.contains("+") || contents.contains("-")) {
            int index = findIndex(new char[] { '+', '-'});
            processIndex(index);
        }

        return contents.get(0);
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
        return 0;
    }

    //receives index in array and processes the value before and after index
    private void processIndex(int index) {
        int result = getResult(index);

        //not a typo removes the middle and last value used to calculate
        contents.remove(index);
        contents.remove(index);

        //replace first value with result
        contents.set(index - 1, Integer.toString(result));
    }

    private int getResult(int index) {
        int x = Integer.parseInt(contents.get(index - 1));
        int y = Integer.parseInt(contents.get(index + 1));
        int result = 0;
        char operator = contents.get(index).charAt(0); //only 1 char anyway index is needed

        switch (operator) {
            case '+':
                result = x + y;
                break;

            case '-':
                result = x - y;
                break;

            case '*':
                result = x * y;
                break;

            case '/':
                result = x / y;
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }

        return result;
    }

    private boolean isOperator(String input) {
        for (char operator : OPERATOR) {
            if (input.equals(Character.toString(operator))) {
                return true;
            }
        }

        return false;
    }
}
