package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //should the below commented out code be in calculator?
    TextView calculatorCurrentEntry;//example - how to access xml objects in java code
    String calcDisplay = "";;
    boolean firstClick = true;

    Calculator calculator = new Calculator();

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn0;

    Button btnPlus;
    Button btnMinus;
    Button btnDivide;
    Button btnMultiply;

    //lifecycle functions / events
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Ass1", "onCreate "+ R.string.app_name);

        calculatorCurrentEntry = (TextView) findViewById(R.id.calcCurrentEntry);//temp - how to access textView in java code
        //calcDisplay = "";//Initialising string to be empty

        ((TextView) findViewById(R.id.calcCurrentEntry)).setText(R.string.welcome_msg);// Should I do this if calculator will be accessing it?

        //Number buttons onClick listeners
        btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setNumberOrOperator("1");
            }
        });
        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setNumberOrOperator("2");
            }
        });
        btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setNumberOrOperator("3");
            }
        });
        btn4 = (Button) findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setNumberOrOperator("4");
            }
        });
        btn5 = (Button) findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setNumberOrOperator("5");
            }
        });
        btn6 = (Button) findViewById(R.id.button6);
        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setNumberOrOperator("6");
            }
        });
        btn7 = (Button) findViewById(R.id.button7);
        btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setNumberOrOperator("7");
            }
        });
        btn8 = (Button) findViewById(R.id.button8);
        btn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setNumberOrOperator("8");
            }
        });
        btn9 = (Button) findViewById(R.id.button9);
        btn9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setNumberOrOperator("9");
            }
        });
        btn0 = (Button) findViewById(R.id.button0);
        btn0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setNumberOrOperator("0");
            }
        });

        //Operator buttons onClick listeners
        btnPlus = (Button) findViewById(R.id.buttonPlus);
        btnPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setNumberOrOperator("+");
            }
        });
        btnMinus = (Button) findViewById(R.id.buttonMinus);
        btnMinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setNumberOrOperator("-");
            }
        });
        btnMultiply = (Button) findViewById(R.id.buttonMultiply);
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setNumberOrOperator("*");
            }
        });
        btnDivide = (Button) findViewById(R.id.buttonDivide);
        btnDivide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setNumberOrOperator("/");
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Ass1", "onStart");
    }

    //adds number/operator to TextView calculatorCurrentEntry and calls push("button's text/string value")
    public void setNumberOrOperator(String s){
        if(firstClick){
            firstClick=false;
            clear();
            ((TextView) findViewById(R.id.calcCurrentEntry)).setText("");
        }
        calcDisplay += s;
        ((TextView) findViewById(R.id.calcCurrentEntry)).setText(calcDisplay);
        calculator.push(s);

    }

    //Clear button clicked calling the clear function
    public void ClearClicked(View view) {
        clear();
    }
    //clears TextView calculatorCurrentEntry and calls new clear() function in Calculator class to clear ArrayList<String> currentEntry
    public void clear(){
        calcDisplay = "";
        ((TextView) findViewById(R.id.calcCurrentEntry)).setText(calcDisplay);
        calculator.clear();
    }


    //Calls validateInput() in the Calculator class to check if input is valid, then calls the calculate() function in the Calculator class
    //Either returns error or an int to add to TextView calculatorCurrentEntry
    public void EqualsClicked(View view) {
        //if first click/ first click after calculation will just clear all
        if(firstClick) {
            clear();
            firstClick=false;
            ((TextView) findViewById(R.id.calcCurrentEntry)).setText("");
        }
        else{
            //Checks for Valid Input - Returns "Successful", or a detailed error msg
            String validation = calculator.validateInput();
            if (validation == "Successful") {
                //if successful adds answer to the textview
                calcDisplay += " = " + calculator.calculate();
                ((TextView) findViewById(R.id.calcCurrentEntry)).setText(calcDisplay);

                //sets first click to true so after a calculation next button click will clear() etc
                firstClick = true;
            } else {
                //clears the input replacing it with the error/what was invalid about the input
                clear();
                ((TextView) findViewById(R.id.calcCurrentEntry)).setText(validation);
                Toast.makeText(getApplicationContext(), validation, Toast.LENGTH_LONG).show();
                return;
            }
        }
    }


    //adds buttons/operators into view and switches text from scientific to standard or vice versa
    public void ScientificClicked(View view) {
    }

}