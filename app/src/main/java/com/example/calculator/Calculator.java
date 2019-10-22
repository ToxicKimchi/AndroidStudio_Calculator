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
}
