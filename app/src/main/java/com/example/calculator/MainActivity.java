package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Map.Entry;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Calculator calculator;
    Map<Button, String> buttons = new HashMap<>();
    String[] str_num = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    List<String> numbers = Arrays.asList(str_num);
    Map<String, String> operations = new HashMap<String, String>(){{
        put("times","x");
        put("divide","/");
        put("plus","+");
        put("minus","-");
        put("exponent","^");
    }};
    String[] str_butts = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "times", "divide", "plus", "minus", "exponent", "C", "CE", "back", "dot", "PlusMinus", "equals"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator = new Calculator();
        // ArrayList<Button> buttons = new ArrayList<>();
        for (String butts : str_butts) {
            buttons.put((Button) findViewById(getResources().getIdentifier("btn_" + butts, "id",
                    this.getPackageName())) , butts);

        }
       /* buttons.put((Button) findViewById(R.id.btn_0),("0"));
        buttons.put((Button) findViewById(R.id.btn_1),("1"));
        buttons.put((Button) findViewById(R.id.btn_2),("2"));
        buttons.put((Button) findViewById(R.id.btn_3),("3"));
        buttons.put((Button) findViewById(R.id.btn_4),("4"));
        buttons.put((Button) findViewById(R.id.btn_5),("5"));
        buttons.put((Button) findViewById(R.id.btn_6),("6"));
        buttons.put((Button) findViewById(R.id.btn_7),("7"));
        buttons.put((Button) findViewById(R.id.btn_8),("8"));
        buttons.put((Button) findViewById(R.id.btn_9),("9"));
        buttons.put((Button) findViewById(R.id.btn_plus),("+"));
        buttons.put((Button) findViewById(R.id.btn_minus),("-"));
        buttons.put((Button) findViewById(R.id.btn_times),("*"));
        buttons.put((Button) findViewById(R.id.btn_divide),("/"));
        buttons.put((Button) findViewById(R.id.btn_equals),("="));
        buttons.put((Button) findViewById(R.id.btn_exponent),("^"));
        buttons.put((Button) findViewById(R.id.btn_C),("C"));
        buttons.put((Button) findViewById(R.id.btn_CE),("CE"));
        buttons.put((Button) findViewById(R.id.btn_back),("<-"));
        buttons.put((Button) findViewById(R.id.btn_dot),("."));
        buttons.put((Button) findViewById(R.id.btn_PlusMinus),("+/-"));
*/
        for (Map.Entry<Button, String> entry : buttons.entrySet()) {
            Button b = (entry.getKey());
            b.setOnClickListener(this);
        }
        //    for (Button b : buttons) {
        //        b.setOnClickListener(this);
        //    }
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
    }

    private void numberInput(String input) {
        calculator.receiveNumber(input);
    }

    private void equalsPressed() {
        TextView display = findViewById(R.id.txt_display);
        display.setText(calculator.calculate());
    }

    @Override
    public void onClick(View v) {
        if(v != null) {
            Button click = (Button) v;
            if (numbers.contains(buttons.get(click))) {
                numberInput(buttons.get(click));
            } else if (operations.containsKey(buttons.get(click))) {
                operatorInput(operations.get(buttons.get(click)));
            } else if (buttons.get(click).equals("C")) {
                calculator.clear();
            } else if (buttons.get(click).equals("CE")) {
                calculator.clearEntry();
            } else if (buttons.get(click).equals("equals")) {
                equalsPressed();
            } else if (buttons.get(click).equals("dot")) {
                calculator.receiveDot();
            } else if (buttons.get(click).equals("PlusMinus")) {
                calculator.receiveNegative();
            } else if (buttons.get(click).equals("back")) {
                calculator.deleteLast();
            }
            renderElements();
        }
    }

    /*public void onClick(View v) {
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
    }*/
}

