package com.example.conversorcelsius_fahrenheit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    EditText editTextInsertTemperature;
    TextView textViewResult;
    Button buttonConvert;
    EditText editTextSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
    }

    private  void initializeViews() {
        editTextInsertTemperature = findViewById(R.id.editTextInsertTemperature);
        textViewResult = findViewById(R.id.textViewResult);
        buttonConvert = findViewById(R.id.buttonConvert);
        editTextSelection = findViewById(R.id.editTextSelection);
    }

    public void onClickTemperatureConvert(View view) {
        //Toast.makeText(MainActivity.this, "Botão pressionado", Toast.LENGTH_SHORT).show();

        // 1. get text from input
         String textFromInput = editTextInsertTemperature.getText().toString();
         //Toast.makeText(MainActivity.this, textFromInput, Toast.LENGTH_SHORT).show();

        // 2. Validate data supplied by the user
        if (textFromInput.length() == 0) {
            Toast.makeText(MainActivity.this, "Insira um  valor na caixa de texto!", Toast.LENGTH_SHORT).show();
            return;
        }

        // 3. Convert
        float temperatureToConvert = Float.parseFloat(textFromInput);

        // 4. Show the result
        // Test type conversion
        if(editTextSelection.getText().toString().equalsIgnoreCase("C-F")) {
            String toastMessage = getResources().getString(R.string.notify_c_f);
            Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT).show();
            float temperatureInFahrenheit = convertFromCelsiusToFahrenheit(temperatureToConvert);
            String result = String.format("%.1f", temperatureInFahrenheit);
            textViewResult.setText(result);

        } else if (editTextSelection.getText().toString().equalsIgnoreCase("F-C")) {
            String toastMessage = getResources().getString(R.string.notify_f_c);
            Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT).show();
            float temperatureInCelsius = convertFahrenheitToCelsius(temperatureToConvert);
            String result = String.format("%.1f", temperatureInCelsius);
            textViewResult.setText(result);
        } else {
            String toastMessage = getResources().getString(R.string.notify_f_or_c_empty);
            Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT).show();
            return;
        }
    }

    private float convertFromCelsiusToFahrenheit(float temperatureInCelsius) {
        return temperatureInCelsius * 1.8f + 32f;
    }

    private float convertFahrenheitToCelsius(float temperatureInFahrenheit) {
        return (temperatureInFahrenheit - 32f) / 1.8f;
    }
}