package com.example.assignment1;


import java.util.ArrayList;

public class Calculator {

    ArrayList<String> currentEntry = new ArrayList<String>();

    //adds string into the currentEntry ArrayList - to be used by all buttons
    void push (String value){
        currentEntry.add(value);
    }

    //clears the arrayList and creates a new one
    void clear (){
        currentEntry.clear();
        currentEntry = new ArrayList<String>();
    }

    //called when the equals button is pressed
    //I kinda wanna make this void/string and then just add the int as a string to the arrayList or change the TextView from here
    //i think to keep this as an int return I'd need to error check in main activity not here
    int calculate() throws ArrayIndexOutOfBoundsException{//does this exception work for valid list size?
        //checking for valid list size (3 or more, not null/empty)
        if(currentEntry!=null || currentEntry.isEmpty() || currentEntry.size()<3){
            //calculatorCurrentEntry = (TextView)"";
            //Please click on at least two numbers separated by an operator first!
        }
        else{
            //for loop running through currentEntry arrayList
            for (int i=0; currentEntry.size()<i; i++) {

                //if in the first iteration
                if (i == 0) {
                    String first = currentEntry.get(0);
                    //validating first entry isn't an operation
                    if (first.equals("+") || first.equals("-") || first.equals("+") || first.equals("+")) {

                    }
                }
            }



            return 0;
        }

        return 0;//needs to return an int to complete :/
     }

    //Validate Input Function
    String validateInput (){
        //checks if ArrayList is null, empty or has less than three inputs
        if(currentEntry!=null || currentEntry.isEmpty() || currentEntry.size()<3){
            return "Please click on at least two numbers separated by an operator first!";
        }
        //checks if first input is an operator
        else if (isOperator(currentEntry.get(0))){
            return "Calculation cannot start with an operation!";
        }
        //checking for having two operators in a row
        else if (ifDoubleOperator()){
            return "Cannot have two Operations in a row!";
        }
        else{
            return "Successful";
        }
    }

    //checks if there's two operators in a row throughout the whole ArrayList
    boolean ifDoubleOperator(){
        //running the loop size()-1 time as the last string is checked at the same time as the second last string
        for(int i=0; currentEntry.size()>i-1; i++){
            String temp1 = currentEntry.get(i);
            String temp2 = currentEntry.get(i+1);
            if(isOperator(temp1) && isOperator(temp2)){
                return true;
            }
        }
        return false;
    }

    //to do - update
    //Function to check if string is an Operator
    boolean isOperator(String s){
        if(s=="+" || s=="-" || s=="*" || s=="/" ){
            return true;
        }
        else{
            return false;
        }
    }


}
