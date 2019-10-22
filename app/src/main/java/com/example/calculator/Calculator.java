package com.example.calculator;

import java.util.ArrayList;

public class Calculator {
    //information specifically on storing input from user
    private ArrayList<String> contents = new ArrayList<String>();

    public void receiveInput(String input) {
        contents.add(input);
    }

    public ArrayList<String> outputDisplay() {
        return contents;
    }

    public String calculate() {


        while (contents.contains("+") || contents.contains("-")) {
            int index = 0;

            for (int i = 0; i < contents.size(); i++) {
                if (contents.get(i) == "+" || contents.get(i) == "-") {
                    index = i;
                }
            }


        }
    }
}
