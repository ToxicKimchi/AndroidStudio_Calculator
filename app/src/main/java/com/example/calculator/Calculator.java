package com.example.calculator;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<String> contents = new ArrayList<>();
    private String stagingArea = "";
    private boolean resetStagingArea = false;
    private ArithmeticHandler arithmeticHandler = new ArithmeticHandler();

    public void receiveInput(String input) {

        if (input.equals(".") && !stagingArea.contains(".")) {
            stagingArea += input;

        } else if (input.equals("-") && stagingArea.length() > 0) {
            if (stagingArea.charAt(0) == '-') {
                stagingArea = stagingArea.substring(1);
            }

            else {
                stagingArea = "-" + stagingArea;
            }
        }
    }

    public void receiveOperator(String operator) {
        if (StringUtil.isOperator(stagingArea)) {
            stagingArea = operator;
        }

        else {
            commitStagingArea(operator);
            resetStagingArea = false;
        }

    }

    public void receiveNumber(String number) {
        if (StringUtil.isOperator(stagingArea)) {
            commitStagingArea(number);
        }

        else {
            if (resetStagingArea) {
                stagingArea = number;
                resetStagingArea = false;
            }

            else {
                stagingArea += number;
            }
        }
    }

    public String outputDisplay() {
        String output = "";

        for (String item : contents) {
            output += item + " ";
        }

        output += stagingArea;
        return output;
    }

    public String calculate() {
        if (stagingArea.equals("") || StringUtil.isOperator(stagingArea)) {
            return outputDisplay();
        }

        commitStagingArea();
        stagingArea = arithmeticHandler.calculate(contents);
        resetStagingArea = true;

        return stagingArea;
    }


    private boolean commitStagingArea(String input) {
        if (stagingArea.equals("")) {
            return false;
        }

        contents.add(stagingArea);
        stagingArea = input;
        return true;
    }

    private boolean commitStagingArea() {
        return commitStagingArea("");
    }

    public void backspace() {
        if (!StringUtil.isOperator(stagingArea) && !stagingArea.equals("")) {
            stagingArea = stagingArea.substring(0, stagingArea.length() - 1);
        }
    }

    public void clear() {
        contents.clear();
        stagingArea = "";
    }

    public void clearEntry() {
        stagingArea = "";
    }
}
