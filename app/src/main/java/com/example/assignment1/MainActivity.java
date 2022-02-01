package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //should the below commented out code be in calculator?
    //TextView calculatorCurrentEntry;//example - how to access xml objects in java code

    //lifecycle functions / events
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Ass1", "onCreate "+ R.string.app_name);

        //calculatorCurrentEntry = (TextView) findViewById(R.id.calcCurrentEntry);//temp - how to access textView in java code

        //((TextView) findViewById(R.id.calcCurrentEntry)).setText(R.string.welcome_msg);// Should I do this if calculator will be accessing it?


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Ass1", "onStart");
    }

}