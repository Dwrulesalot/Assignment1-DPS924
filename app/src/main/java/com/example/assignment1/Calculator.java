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
    //goes through the validateInput function first
    int calculate(){
        //integer to be returned
        int total=0;

        //first and second number with the operation being used on the two of them
        int firstNum= -1;
        String operator="";
        int secondNum= -1;

        //bool to track first vs subsequent operations
        boolean isFirstCalculation = true;

        //makes grouping double digits easier to be parsed all at once rather then one after another adding a decimal place each time.
        String tempDoubleDigit="";

        //loops once through full arrayList
        for (int i=0; currentEntry.size()>i; i++) {
            //tweaked assignment instruction to allow this to work for double digits
            if(isFirstCalculation){

                if(!isOperator(currentEntry.get(i))){
                    tempDoubleDigit += currentEntry.get(i);
                }
                //if first num hasn't been set yet set the operator for the first calculation
                else if(firstNum == -1){
                    operator = currentEntry.get(i);
                    firstNum = Integer.parseInt(tempDoubleDigit);
                    tempDoubleDigit = "";//resetting string for second number
                }
                //sets second number, does the first calculation and
                else{

                }

            }
            else{//second half first num is total(of first calculation) then you're seeing if the next number is a double digit to then calculate total OPERATOR secondNum

            }



            /*
            until isOperator(currentEntry.get(i))
                tempDoubleDigit+=currentEntry.get(i)
                        then operator = currentEntry.get(i) when true
                        firstNum=parseInt(tempDoubleDigit)
                        tempDoubleDigit ="";
            until isOperator(currentEntry.get(i)) OR currentEntry.size()>i
                tempDoubleDigit+=currentEntry.get(i)
                secondNum=parseInt(tempDoubleDigit)
                        */

            //tempted to make all these operations their own methods/functions
            if (operator=="+"){

            }
            else if(operator=="-"){

            }
            else if(operator=="*"){

            }
            else if(operator=="/"){

            }


            //first iteration - tweaked to allow this to work for double digits
            if(i==0){
                //if the second string is an operator
                if(isOperator(currentEntry.get(i+1))){

                    //Since validation checked there's no repeating operations we'll check how long the second number is (before we hit the next operation)
                    //We also validated the last String in the ArrayList is a number and not an operation.

                }
            }
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
        //checks if last input is an operator
        else if (isOperator(currentEntry.get(currentEntry.size()-1))){//is size()-1 the right index?
            return "Calculation cannot end with an operation!";
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
