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

    /*
    //Legacy double digit code - too complicated atm will finish after first completing assignment




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

     //*/

    //todo- make work for double digits
    //called when the equals button is pressed
    //goes through the validateInput function first
    int calculate(){
        //integer to be returned
        int total=0;

        /*
        //first and second number with the operation being used on the two of them
        int firstNum;
        String operator="";
        int secondNum;

        //first calculation between the first number - operation and second number
        firstNum = Integer.parseInt(currentEntry.get(0));
        operator = currentEntry.get(1);
        secondNum = Integer.parseInt(currentEntry.get(2));
        */

        //simplifying above code

        //first calculation between the first number - operation and second number
        //calls our mathHere function to do the calculation, first parsing the integers from the strings for our numbers
        total+= mathHere(Integer.parseInt(currentEntry.get(0)), currentEntry.get(1), Integer.parseInt(currentEntry.get(2)));

        //checks if the arraylist only had 3 inputs, if so sends the result
        if(currentEntry.size()==3){
            return total;
        }
        //else loops through the the rest of the arrayList until all operations are complete
        else if (currentEntry.size()>3){


            //loops once through rest of arraylist (starts at 4th index) -
            //ends one before the end of the arraylist as it will get operator at i and number at i+1
            //do I iterate by two? - yes
            for (int i=3; currentEntry.size()>i; i+=2) {

                //calculation between the first number(total) - operation and second number
                //calls our mathHere function to do the calculation, using the current total as the first number

                // replacing our total, and using it as first parsing the integers from the strings for our numbers
                total = mathHere(total, currentEntry.get(i), Integer.parseInt(currentEntry.get(i+1)));

                //we can assume that the arrayList is an odd number size from validationInput not allowing operators at the start/ beginning,
                //as well as no double digits/operators ie.  always the format of: n1 o1 n2 o2 n3 o3 n4 etc
            }

            return total;
        }
        else{//error catch
            return total;
        }


    }

    //cleans up calculator logic - Todo update for double digits
    //takes 2 numbers and an operator
    //calculates based on the operation and returns an int
    int mathHere(int n1, String o, int n2){
        int result=0;

        //Addition
        if(o == "+"){
            result = n1 + n2;
        }
        //Subtraction
        else if(o == "-"){
            result = n1 - n2;
        }
        //Multiplication
        else if(o == "*"){
            result = n1 * n2;
        }
        //Division
        else if(o == "/"){
            result = n1 / n2;
        }
        //Modulus
        if(o == "%"){
            result = n1 % n2;
        }
        //Power - casted into an integer
        else if(o == "^"){
            result = (int)Math.pow(n1, n2);//hopefully no error with this casting
        }
        //Min
        else if(o == "Min"){
            result = Math.min(n1, n2);
        }
        //MaX
        else if(o == "Max"){
            result = Math.max(n1, n2);
        }
        //todo - assignment part 2 operators

        return result;
    }


    //Validate Input Function
    String validateInput (){
        //checks if ArrayList is null, empty or has less than three inputs
        if(currentEntry==null || currentEntry.isEmpty() || currentEntry.size()<3){
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
        //todo - remove when adding double digit functionality
        else if(ifDoubleNumber()){
            return "Calculator currently does not support double digit numbers, sorry!";
        }
        else{
            return "Successful";
        }
    }

    //todo - remove this and update calculate function to work with double digits
    //checks if there's two numbers in a row throughout the whole ArrayList
    boolean ifDoubleNumber(){
        //running the loop size()-2 time as the last string is checked at the same time as the second last string
        //and size() starts counting at 1 vs index starts at 0
        for(int i=0; currentEntry.size()-2>i; i++){
            String temp1 = currentEntry.get(i);
            String temp2 = currentEntry.get(i+1);
            if(!isOperator(temp1) && !isOperator(temp2)){
                return true;
            }
        }

        return false;
    }

    //checks if there's two operators in a row throughout the whole ArrayList
    boolean ifDoubleOperator(){
        //running the loop size()-2 time as the last string is checked at the same time as the second last string
        //and size() starts counting at 1 vs index starts at 0
        for(int i=0; currentEntry.size()-2>i; i++){
            String temp1 = currentEntry.get(i);
            String temp2 = currentEntry.get(i+1);
            if(isOperator(temp1) && isOperator(temp2)){
                return true;
            }
        }

        return false;
    }

    //Function to check if string is an Operator
    boolean isOperator(String s){
        if(s=="+" || s=="-" || s=="*" || s=="/" || s=="%" || s=="^" || s=="Min" || s=="Max"){
            return true;
        }
        else{
            return false;
        }
    }


}
