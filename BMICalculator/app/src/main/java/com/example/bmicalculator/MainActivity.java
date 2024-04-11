package com.example.bmicalculator;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText weightEditText;
    private EditText heightEditText;
    public static final NumberFormat BMI = NumberFormat.getIntegerInstance();

    private TextView BMIResult;

//    private final TextWatcher bmiTextWatcher = new TextWatcher() {
//
//        @Override
//        public void onTextChanged(CharSequence s, int start,
//                                  int before, int count) {
//            calculateAndDisplayBMI();
//        }
//
//        @Override
//        public void afterTextChanged(Editable s) { }
//
//        @Override
//        public void beforeTextChanged(
//                CharSequence s, int start, int count, int after) { }
//    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        weightEditText = findViewById(R.id.editTextWeight);
        heightEditText = findViewById(R.id.editTextHeight);

        BMIResult = findViewById(R.id.textViewBMIResult);

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        final Button calculateButton = findViewById(R.id.buttonCalculate);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightStr = weightEditText.getText().toString();
        String heightStr = heightEditText.getText().toString();

        if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
            double weight = Double.parseDouble(weightStr);
            double height = Double.parseDouble(heightStr) / 100;

            if (height > 0) {
                double BMI = weight / (height * height);
                BMIResult.setText(String.format(Locale.getDefault(), "%.1f", BMI));
            }
        }
    }
}