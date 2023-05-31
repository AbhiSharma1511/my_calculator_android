package com.company.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button  btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
            btnDot, btnPlus, btnMinus, btnMulti, btnDivide, btnEqual, btnAC, btnDel;
    TextView textViewHistory, textViewResult;

    String number = null;

    double firstNumber = 0;
    double lastNumber = 0;

    String status = null;
    Boolean operator = false;

    DecimalFormat format =  new DecimalFormat("####.####");

    String history, currentResult;

    Boolean dot = true;

    Boolean btnAcControl = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMulti = findViewById(R.id.btnMulti);
        btnDivide = findViewById(R.id.btnDivide);

        btnAC = findViewById(R.id.btnAC);
        btnDel = findViewById(R.id.btnDel);
        btnDot = findViewById(R.id.btnDot);
        btnEqual = findViewById(R.id.btnEqual);

        textViewHistory = findViewById(R.id.textViewHistory);
        textViewResult = findViewById(R.id.textViewResult);


        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("9");
            }
        });




        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history + currentResult + "+");

                if (operator){
                    if (status == "multiplication")
                    {
                        multiply();
                    }
                    else if (status == "divide")
                    {
                        divide();
                    }
                    else if (status == "subtraction")
                    {
                        minus();
                    }else
                    {
                        plus();
                    }
                }
                status = "addition";
                operator = false;
                number = null;
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history + currentResult + "-");
                if (operator){
                    if (status == "multiplication")
                    {
                        multiply();
                    }
                    else if (status == "divide")
                    {
                        divide();
                    }
                    else if (status == "addition")
                    {
                        plus();
                    }else
                    {
                        minus();
                    }
                }
                status = "subtraction";
                operator = false;
                number = null;
            }
        });
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history + currentResult + "*");
                if (operator){
                    if (status == "addition")
                    {
                        plus();
                    }
                    else if (status == "divide")
                    {
                        divide();
                    }
                    else if (status == "subtraction")
                    {
                        minus();
                    }else
                    {
                        multiply();
                    }
                }
                status = "multiplication";
                operator = false;
                number = null;
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history + currentResult + "/");
                if (operator){
                    if (status == "multiplication")
                    {
                        multiply();
                    }
                    else if (status == "addition")
                    {
                        plus();
                    }
                    else if (status == "subtraction")
                    {
                        minus();
                    }else
                    {
                        divide();
                    }
                }
                status = "divide";
                operator = false;
                number = null;
            }
        });


        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = null;
                status = null;
                textViewResult.setText("0");
                textViewHistory.setText("");
                firstNumber=0;
                lastNumber=0;
                dot = true;
                btnAcControl = true;

            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnAcControl){
                    textViewResult.setText("0");
                }
                else{
                    number = number.substring(0,number.length()-1);
                    if (number.length() == 0){
                        btnDel.setClickable(false);
                    }
                    else if (number.contains(".")){
                        dot = false;
                    }
                    else{
                        dot = true;
                    }
                    textViewResult.setText(number);
                }
            }
        });


        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dot){
                    if (number == null)
                    {
                        number = "0.";
                    }
                    else{
                        number = number + ".";
                    }
                }
                textViewResult.setText(number);
                dot = false;
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operator){
                    if (status == "addition"){
                        plus();
                    }
                    else if (status == "subtraction")
                    {
                        minus();
                    }
                    else if (status == "multiplication")
                    {
                        multiply();
                    }
                    else if (status == "divide")
                    {
                        divide();
                    }
                    else{
                        firstNumber = Double.parseDouble(textViewResult.getText().toString());
                    }
                }
            }
        });

    }



    private void numberClick(String view){
        if (number == null){
                number = view;
        }else{
                number = number + view;
        }
        textViewResult.setText(number);
        operator = true;
        btnAcControl = false;
        btnDel.setClickable(true);
    }

    private void plus(){
        lastNumber = Double.parseDouble(textViewResult.getText().toString());
        firstNumber = firstNumber + lastNumber;
        textViewResult.setText(format.format(firstNumber));
        dot = true;
    }

    private void minus(){
        if (firstNumber == 0){
            firstNumber = Double.parseDouble(textViewResult.getText().toString());
        }else{
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber - lastNumber;
        }
        textViewResult.setText(format.format(firstNumber));
        dot = true;}
    private void multiply(){
        if (firstNumber == 0)
        {
            firstNumber = 1;
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber * lastNumber;
        }
        else
        {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber * lastNumber;
        }
        textViewResult.setText(format.format(firstNumber));
        dot = true;}

    public void divide(){
        if (firstNumber == 0){
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = lastNumber / 1;
        }
        else{
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber / lastNumber;
        }
        textViewResult.setText(format.format(firstNumber));
        dot = true;}

}