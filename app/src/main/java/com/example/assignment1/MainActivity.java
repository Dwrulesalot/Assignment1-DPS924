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


    //Calls calculate() function in Calculator class that then either returns error or an int to add to TextView calculatorCurrentEntry?
    // take some time to figure out the best way to implement this
    //should I move chunks of this to the calculator class/ the calculate function?
    public void EqualsClicked(View view) {
        //Checks for Valid Input - Returns "Successful", or a detailed error msg
        String validation = calculator.validateInput();
        if(validation=="Successful"){
            //calculator.calculate();//to do
        }
        else{
            clear();
            ((TextView) findViewById(R.id.calcCurrentEntry)).setText(validation);
            Toast.makeText(getApplicationContext(), validation, Toast.LENGTH_LONG).show();
            return;
        }


        //checking for valid list size (3 or more, not null/empty)
        if( calcDisplay=="" || calcDisplay.length()<3){
            clear();
            Toast.makeText(getApplicationContext(), "Please click on at least two numbers separated by an operator first!", Toast.LENGTH_LONG).show();
            Log.d("equalsTest", calcDisplay);
            return;
        }

        //taking the char/first string entered
        char c = calcDisplay.charAt(0);
        //checking it does not starting with an operator
        if( c == '+' || c == '-' || c == '*' || c == '/' ){
            Log.d("equalsTest", calcDisplay);
            clear();
            Toast.makeText(getApplicationContext(), "Calculation cannot start with an operation!", Toast.LENGTH_LONG).show();
            return;
        }
        Log.d("equalsTest", calcDisplay);

        //checking for having two operators in a row
        //starting at the second char as the first cannot be an operation,
        //running the loop -1 times as the last number is check at the same time as the second last number
        for(int i=1; calcDisplay.length() > i-1; i++){
            Log.d("equalsTest", calcDisplay);
            char temp1 = calcDisplay.charAt(i);
            Log.d("temp1", Character.toString(temp1));
            char temp2 = calcDisplay.charAt(i+1);
            Log.d("temp2", Character.toString(temp2));
            if(temp1 == '+' || temp1 == '-' || temp1 == '*' || temp1 == '/'){
                if(temp2 == '+' || temp2 == '-' || temp2 == '*' || temp2 == '/'){
                    Toast.makeText(getApplicationContext(), "Cannot have two Operations in a row! Please clear and try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }

        //now code what to do if no errors




    }




    //adds operators into view and switches text from scientific to standard or vice versa
    public void ScientificClicked(View view) {
    }

}