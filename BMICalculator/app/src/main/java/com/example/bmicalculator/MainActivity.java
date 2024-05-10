package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Toolbar actionBar;

    private EditText weightEditText;
    private EditText heightEditText;
    public static final NumberFormat BMI = NumberFormat.getIntegerInstance();

    private TextView BMIResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        actionBar = (Toolbar) findViewById(R.id.toolbarBMI);

        setSupportActionBar(actionBar);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"#FFFFFF\">" + getString(R.string.app_name) + "</font>"));
        actionBar.setNavigationIcon(R.drawable.baseline_arrow_back_24);
        actionBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        weightEditText = findViewById(R.id.editTextWeight);
        heightEditText = findViewById(R.id.editTextHeight);

        BMIResult = findViewById(R.id.textViewBMIResult);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        final Button calculateButton = findViewById(R.id.buttonCalculate);
        final Button continueButton = findViewById(R.id.continueButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calculateBMI();
            }
        });

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DailyCaloriesActivity.class);
                startActivity(intent);
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