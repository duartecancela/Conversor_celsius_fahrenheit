package com.example.conversorcelsius_fahrenheit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextInsertTemperature;
    TextView textViewResult;
    Button buttonConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private  void initializeViews() {
        editTextInsertTemperature = findViewById(R.id.editTextInsertTemperature);
        textViewResult = findViewById(R.id.textViewResult);
        buttonConvert = findViewById(R.id.buttonConvert);
    }

    public void onClickTemperatureConvert(View view) {
        System.out.println("Convert");

        // 1. get text from input
        // 2. Validate data suplied by the user
        // 2. Convert
        // 3. Show the result
    }


}