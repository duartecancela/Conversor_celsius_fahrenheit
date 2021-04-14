package com.example.conversorcelsius_fahrenheit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextInsertTemperature;
    TextView textViewResult;
    Button buttonConvert;

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

        // 4. Show the result
        String result = String.format("%.1f", temperatureInFahrenheit);
        textViewResult.setText(result);
    }

    private float convertFromCelsiusToFahrenheit(float temperatureInCelsius) {
        Toast.makeText(MainActivity.this, "Valor convertido!", Toast.LENGTH_SHORT).show();
        return temperatureInCelsius * 1.8f + 32f;
    }

}