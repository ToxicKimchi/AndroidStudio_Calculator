package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator = new Calculator();

        ArrayList<Button> buttons = new ArrayList<>();
        buttons.add((Button) findViewById(R.id.btn_0));
        buttons.add((Button) findViewById(R.id.btn_1));
        buttons.add((Button) findViewById(R.id.btn_2));
        buttons.add((Button) findViewById(R.id.btn_3));
        buttons.add((Button) findViewById(R.id.btn_4));
        buttons.add((Button) findViewById(R.id.btn_5));
        buttons.add((Button) findViewById(R.id.btn_6));
        buttons.add((Button) findViewById(R.id.btn_7));
        buttons.add((Button) findViewById(R.id.btn_8));
        buttons.add((Button) findViewById(R.id.btn_9));
        buttons.add((Button) findViewById(R.id.btn_plus));
        buttons.add((Button) findViewById(R.id.btn_minus));
        buttons.add((Button) findViewById(R.id.btn_times));
        buttons.add((Button) findViewById(R.id.btn_divide));
        buttons.add((Button) findViewById(R.id.btn_equals));
        buttons.add((Button) findViewById(R.id.btn_CE));
        buttons.add((Button) findViewById(R.id.btn_dot));

        for (Button b : buttons) {
            b.setOnClickListener(this);
        }
    }

    private void renderElements() {
        String display = calculator.outputDisplay();
        TextView txt_display = findViewById(R.id.txt_display);

        txt_display.setText(display);
    }

    private void buttonInput(String input) {
        calculator.receiveInput(input);
        renderElements();
    }

    private void equalsPressed() {
        TextView display = findViewById(R.id.txt_display);
        display.setText(calculator.calculate());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_0:
                buttonInput("0");
                break;

            case R.id.btn_1:
                buttonInput("1");
                break;

            case  R.id.btn_2:
                buttonInput("2");
                break;

            case R.id.btn_3:
                buttonInput("3");
                break;

            case R.id.btn_4:
                buttonInput("4");
                break;

            case R.id.btn_5:
                buttonInput("5");
                break;

            case R.id.btn_6:
                buttonInput("6");
                break;

            case R.id.btn_7:
                buttonInput("7");
                break;

            case R.id.btn_8:
                buttonInput("8");
                break;

            case R.id.btn_9:
                buttonInput("9");
                break;

            case R.id.btn_plus:
                buttonInput("+");
                break;

            case R.id.btn_minus:
                buttonInput("-");
                break;

            case R.id.btn_times:
                buttonInput("*");
                break;

            case R.id.btn_divide:
                buttonInput("/");
                break;

            case R.id.btn_equals:
                equalsPressed();
                break;

            case R.id.btn_CE:
                calculator.clear();
                renderElements();
                break;

            case R.id.btn_dot:
                buttonInput(".");
                break;
        }
    }
}
