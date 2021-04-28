package com.example.conversorcelsius_fahrenheit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText editTextInsertTemperature;
    TextView textViewResult;
    Button buttonConvert;
    Spinner spinnerConvertionType;

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
        spinnerConvertionType = findViewById(R.id.spinnerCovertionType);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.conversion_types_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerConvertionType.setAdapter(adapter);
    }

    public void onClickTemperatureConvert(View view) {

        // 1. get text from input
        String textFromInput = editTextInsertTemperature.getText().toString();

        String textFromSpinner = spinnerConvertionType.getSelectedItem().toString();;
        Toast.makeText(this, textFromSpinner, Toast.LENGTH_SHORT).show();

        // 2. Validate data supplied by the user
        if (textFromInput.length() == 0) {
            Toast.makeText(MainActivity.this, "Insira um  valor na caixa de texto!", Toast.LENGTH_SHORT).show();
            return;
        }

        // 3. Convert
        float temperatureToConvert = Float.parseFloat(textFromInput);

        // 4. Show the result
        // Test type conversion
        if(textFromSpinner.equalsIgnoreCase("Celsius-Fahrenheit")) {
            String toastMessage = getResources().getString(R.string.notify_c_f);
            Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT).show();
            float temperatureInFahrenheit = convertFromCelsiusToFahrenheit(temperatureToConvert);
            String result = String.format("%.1f", temperatureInFahrenheit);
            textViewResult.setText(result);

        } else if (textFromSpinner.equalsIgnoreCase("Fahrenheit-Celsius")) {
            String toastMessage = getResources().getString(R.string.notify_f_c);
            Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT).show();
            float temperatureInCelsius = convertFahrenheitToCelsius(temperatureToConvert);
            String result = String.format("%.1f", temperatureInCelsius);
            textViewResult.setText(result);
        }
    }

    private float convertFromCelsiusToFahrenheit(float temperatureInCelsius) {
        return temperatureInCelsius * 1.8f + 32f;
    }

    private float convertFahrenheitToCelsius(float temperatureInFahrenheit) {
        return (temperatureInFahrenheit - 32f) / 1.8f;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}