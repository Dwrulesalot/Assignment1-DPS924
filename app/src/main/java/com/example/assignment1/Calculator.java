package com.example.assignment1;

import android.widget.TextView;

import java.util.ArrayList;

public class Calculator {

    //TextView calculatorCurrentEntry;//example - how to access xml objects in java code
    ArrayList<String> currentEntry;

    void push (String value){

    }

    int calculate() throws ArrayIndexOutOfBoundsException{//does this exception work for valid list size?
        //checking for valid list size (3 or more, not null/empty)
        if(currentEntry!=null || currentEntry.isEmpty() || currentEntry.size()<3){
            try { //does this work instead? xD
                throw new Exception("Exception message");
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Please click on at least two numbers separated by an operator
        }
        else{
            //for loop running through currentEntry arrayList
            for (int i=0; currentEntry.size()<i; i++){


            }

            return 0;
        }

        return 0;//needs to return an int to complete :/
    }


}
