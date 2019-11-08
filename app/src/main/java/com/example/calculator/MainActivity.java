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
        buttons.add((Button) findViewById(R.id.btn_C));
        buttons.add((Button) findViewById(R.id.btn_CE));
        buttons.add((Button) findViewById(R.id.btn_back));
        buttons.add((Button) findViewById(R.id.btn_dot));
        buttons.add((Button) findViewById(R.id.btn_exponent2));
        buttons.add((Button) findViewById(R.id.btn_exponent));
        buttons.add((Button) findViewById(R.id.btn_PlusMinus));

        for (Button b : buttons) {
            b.setOnClickListener(this);
        }
    }
    //TODO: Add sliding menu from side for advanced operations
    //TODO: Improve overall gui
    //TODO: Fix decimal issue

    private void renderElements() {
        String display = calculator.outputDisplay();
        TextView txt_display = findViewById(R.id.txt_display);

        txt_display.setText(display);
    }

    private void operatorInput(String input) {
        calculator.receiveOperator(input);
        renderElements();
    }

    private void numberInput(String input) {
        calculator.receiveNumber(input);
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
                numberInput("0");
                break;

            case R.id.btn_1:
                numberInput("1");
                break;

            case  R.id.btn_2:
                numberInput("2");
                break;

            case R.id.btn_3:
                numberInput("3");
                break;

            case R.id.btn_4:
                numberInput("4");
                break;

            case R.id.btn_5:
                numberInput("5");
                break;

            case R.id.btn_6:
                numberInput("6");
                break;

            case R.id.btn_7:
                numberInput("7");
                break;

            case R.id.btn_8:
                numberInput("8");
                break;

            case R.id.btn_9:
                numberInput("9");
                break;

            case R.id.btn_plus:
                operatorInput("+");
                break;

            case R.id.btn_minus:
                operatorInput("-");
                break;

            case R.id.btn_times:
                operatorInput("*");
                break;

            case R.id.btn_divide:
                operatorInput("/");
                break;

            case R.id.btn_equals:
                equalsPressed();
                break;

            case R.id.btn_C:
                calculator.clear();
                renderElements();
                break;

            case R.id.btn_CE:
                calculator.clearEntry();
                renderElements();
                break;

            case R.id.btn_back:
                calculator.deleteLast();
                renderElements();
                break;

            case R.id.btn_dot:
                calculator.receiveDot();
                renderElements();
                break;

            case R.id.btn_exponent:
                calculator.receiveExponent();
                renderElements();
                break;

            case R.id.btn_PlusMinus:
                calculator.receiveNegative();
                renderElements();
                break;
        }
    }
}
