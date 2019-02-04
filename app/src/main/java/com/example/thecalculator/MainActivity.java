package com.example.thecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Instantiate buttons and TextViews
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    Button btnPlus, btnMinus, btnMult, btnDiv, btnDec, btnSign, btnEqls;
    TextView eqnDisplay, inputDisplay;

    String eText = " ";
    double operand1;
    double operand2;
    double result;
    char operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.number1);
        btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.number2);
        btn2.setOnClickListener(this);
        btn3 = (Button) findViewById(R.id.number3);
        btn3.setOnClickListener(this);
        btn4 = (Button) findViewById(R.id.number4);
        btn4.setOnClickListener(this);
        btn5 = (Button) findViewById(R.id.number5);
        btn5.setOnClickListener(this);
        btn6 = (Button) findViewById(R.id.number6);
        btn6.setOnClickListener(this);
        btn7 = (Button) findViewById(R.id.number7);
        btn7.setOnClickListener(this);
        btn8 = (Button) findViewById(R.id.number8);
        btn8.setOnClickListener(this);
        btn9 = (Button) findViewById(R.id.number9);
        btn9.setOnClickListener(this);
        btn0 = (Button) findViewById(R.id.number0);
        btn0.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnPlus = (Button) findViewById(R.id.additionBtn);
        btnPlus.setOnClickListener(this);
        btnMinus = (Button) findViewById(R.id.subtractionBtn);
        btnMinus.setOnClickListener(this);
        btnMult = (Button) findViewById(R.id.multiplicationBtn);
        btnMult.setOnClickListener(this);
        btnDiv = (Button) findViewById(R.id.divisionBtn);
        btnDiv.setOnClickListener(this);
        btnDec = (Button) findViewById(R.id.decimal);
        btnDec.setOnClickListener(this);
        btnSign = (Button) findViewById(R.id.signNumber);
        btnSign.setOnClickListener(this);
        btnEqls = (Button) findViewById(R.id.enterBtn);
        btnEqls.setOnClickListener(this);
        eqnDisplay = (TextView) findViewById(R.id.eqtnDisplay);
        inputDisplay = (TextView) findViewById(R.id.inputText);
    }

    public void onClick(View v) {
        String pattern = "(\\.+)";
        //String patternMAth = "(\\d+)(\\.\\d)*";
        Pattern decSearch = Pattern.compile(pattern);
        Matcher decMatch;
        if (v.getId() == R.id.number1) {
            eText = eText + "1";
            inputDisplay.setText(eText);
        } else if (v.getId() == R.id.number2) {
            eText = eText + '2';
            inputDisplay.setText(eText);
        } else if (v.getId() == R.id.number3) {
            eText = eText + '3';
            inputDisplay.setText(eText);
        } else if (v.getId() == R.id.number4) {
            eText = eText + '4';
            inputDisplay.setText(eText);
        } else if (v.getId() == R.id.number5) {
            eText = eText + '5';
            inputDisplay.setText(eText);
        } else if (v.getId() == R.id.number6) {
            eText = eText + '6';
            inputDisplay.setText(eText);
        } else if (v.getId() == R.id.number7) {
            eText = eText + '7';
            inputDisplay.setText(eText);
        } else if (v.getId() == R.id.number8) {
            eText = eText + '8';
            inputDisplay.setText(eText);
        } else if (v.getId() == R.id.number9) {
            eText = eText + '9';
            inputDisplay.setText(eText);
        } else if (v.getId() == R.id.number0) {
            eText = eText + '0';
            inputDisplay.setText(eText);
        } else if (v.getId() == R.id.signNumber) {

            if (eText.startsWith("-")) {
                eText = eText.substring(1);
                inputDisplay.setText(eText);
            } else {
                eText = '-' + eText;
                inputDisplay.setText(eText);
            }
        } else if (v.getId() == R.id.decimal) {
            decMatch = decSearch.matcher(eText);
            if (decMatch.find() == false) {
                if (eText == " ") {
                    eText = "0";
                    eText = eText + '.';
                    inputDisplay.setText(eText);
                } else {
                    eText = eText + '.';
                    inputDisplay.setText(eText);
                }

            }
        }
        //Add the addition buttons and maybe a clear and backspace button
        else if (v.getId() == R.id.additionBtn) {
            operand1 = Double.parseDouble(eText);
            eqnDisplay.setText(eText + " " + "+");
            eText = " ";
            inputDisplay.setText(eText);
            operation = '+';
        } else if (v.getId() == R.id.subtractionBtn) {
            operand1 = Double.parseDouble(eText);
            eqnDisplay.setText(eText + " " + "-");
            eText = " ";
            inputDisplay.setText(eText);
            operation ='-';
        } else if (v.getId() == R.id.multiplicationBtn) {
            operand1 = Double.parseDouble(eText);
            eqnDisplay.setText(eText + " " + "*");
            eText = " ";
            inputDisplay.setText(eText);
            operation = '*';
        } else if(v.getId() == R.id.divisionBtn){
            operand1 = Double.parseDouble(eText);
            eqnDisplay.setText(eText + " " + "/");
            eText = " ";
            inputDisplay.setText(eText);
            operation = '/';
        } else if(v.getId() == R.id.enterBtn){
            operand2 = Double.parseDouble(eText);
            if(operation == '+'){
                result = operand1 + operand2;
            }else if(operation == '-') {
                result = operand1 - operand2;
            }else if(operation == '*') {
                result = operand1 * operand2;
            }else if(operation == '/') {
                result = operand1 / operand2;
            }
            eqnDisplay.setText(operand1 + " " + operation + " "+ operand2 + " " + '=' + result);
            eText = " ";
            operation = ' ';
            inputDisplay.setText(eText);
        }
    }
}


