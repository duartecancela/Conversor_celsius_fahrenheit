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
        float temperatureInFahrenheit = convertFromCelsiusToFahrenheit(temperatureToConvert);
        float temperatureInCelsius = convertFahrenheitToCelsius(temperatureToConvert);

        // 4. Show the result
        //String resultF = String.format("%.1f", temperatureInFahrenheit);
        //String resultC = String.format("%.1f", temperatureInCelsius);
        //textViewResult.setText(resultF);

        // Test type conversion
        if(editTextSelection.getText().toString().equalsIgnoreCase("C-F")) {
            Toast.makeText(MainActivity.this, "Resultado de Celsius para Fahrenheit", Toast.LENGTH_SHORT).show();
            String result = String.format("%.1f", temperatureInFahrenheit);
            textViewResult.setText(result);

        } else if (editTextSelection.getText().toString().equalsIgnoreCase("F-C")) {
            Toast.makeText(MainActivity.this, "Resultado de Fahrenheit para Celsius", Toast.LENGTH_SHORT).show();
            String result = String.format("%.1f", temperatureInFahrenheit);
            textViewResult.setText(result);
        } else {
            Toast.makeText(MainActivity.this, "Coloque F-C ou C-F", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    private float convertFromCelsiusToFahrenheit(float temperatureInCelsius) {
        Toast.makeText(MainActivity.this, "Valor convertido de Celsius para Fahrenheit!", Toast.LENGTH_SHORT).show();
        return temperatureInCelsius * 1.8f + 32f;
    }

    private float convertFahrenheitToCelsius(float temperatureInFahrenheit) {
        Toast.makeText(MainActivity.this, "Valor convertido de Fahrenheit to Celsius", Toast.LENGTH_SHORT).show();
        return temperatureInFahrenheit - 32f / 1.8f;
    }
}