package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator = new Calculator();
    }

    public void btn_1(View view) {
        calculator.receiveInput("1");

        renderElements();
    }

    private void renderElements() {
        ArrayList<String> contents = calculator.outputDisplay();
        TextView txt_display = findViewById(R.id.txt_display);

        txt_display.setText(contents.get(0));
    }
}
