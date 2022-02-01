package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    //lifecycle functions / events
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Ass1", "onCreate "+ R.string.app_name);

        Log.d("Ass1", "onCreate "+ R.string.welcome_msg);//how would I set this up with calcCurrentEntry text view? Should I if calculator will be accessing it?
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Ass1", "onStart");
    }

}