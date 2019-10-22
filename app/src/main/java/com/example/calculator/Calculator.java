package com.example.calculator;

import java.util.ArrayList;

public class Calculator {
    //information specifically on storing input from user
    private ArrayList<String> contents = new ArrayList<String>();
    private String stagingArea = "";

    public void receiveInput(String input) {
        if (input.equals("+")) {
            contents.add(stagingArea);
            contents.add("+");
            stagingArea = "";

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

        //calculating all add and subtract
        while (contents.contains("+") || contents.contains("-")) {
            int index = findIndex();
            processAddSubtract(index);
        }

        return contents.get(0);
    }

    private int findIndex() {
        //looking for first instance of + or -
        for (int i = 0; i < contents.size(); i++) {

            String result = contents.get(i);
            if (result.equals("+") || result.equals("-")) {
                return i;
            }
        }

        //should never occur since we validate that a + or - exists before running
        return 0;
    }

    private void processAddSubtract(int index) {
        int x = Integer.parseInt(contents.get(index - 1));
        int y = Integer.parseInt(contents.get(index + 1));
        int result = 0;

        if (contents.get(index).equals("+")) {
            result = x + y;
        }

        //not a typo removes the middle and last value used to calculate
        contents.remove(index);
        contents.remove(index);

        //replace first value with result
        contents.set(index - 1, Integer.toString(result));
    }
}
