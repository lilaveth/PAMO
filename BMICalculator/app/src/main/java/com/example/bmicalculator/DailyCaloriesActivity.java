package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class DailyCaloriesActivity extends AppCompatActivity {
    private TextView dailyCalTextView;
    private Toolbar actionBar;
    private TextView genderTextView;
    private RadioGroup genderRadioGroup;
    private RadioButton maleRadio;
    private RadioButton femaleRadio;
    String gender;
    private EditText ageEditText;
    private EditText weightEditText;
    private EditText heightEditText;
    private TextView dailyCalRes;
    private Button calculateDailyCalButton;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_daily_calories);

        actionBar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(actionBar);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"#FFFFFF\">" + getString(R.string.app_name) + "</font>"));
        actionBar.setNavigationIcon(R.drawable.baseline_arrow_back_24);
        actionBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        dailyCalTextView = findViewById(R.id.dailyCalTextView);

        genderTextView = findViewById(R.id.genderTextView);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        maleRadio = (RadioButton) genderRadioGroup.findViewById(R.id.maleRadio);
        maleRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                gender = "male";
            }
        });
        femaleRadio = (RadioButton) genderRadioGroup.findViewById(R.id.femaleRadio);
        femaleRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                gender = "female";
            }
        });
        ageEditText = findViewById(R.id.ageEditText);
        weightEditText = findViewById(R.id.weightEditText);
        heightEditText = findViewById(R.id.heightEditText);
        calculateDailyCalButton = findViewById(R.id.calculateDailyCalButton);
        dailyCalRes = findViewById(R.id.dailyCalRes);
        nextButton = findViewById(R.id.nextButton);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        calculateDailyCalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateDailyCalories();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DailyCaloriesActivity.this, RecipeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void calculateDailyCalories() {
        double dailyCalories;
        String ageStr = ageEditText.getText().toString();
        String weightStr = weightEditText.getText().toString();
        String heightStr = heightEditText.getText().toString();

        if (!ageStr.isEmpty() && !weightStr.isEmpty() && !heightStr.isEmpty()) {
            int age = Integer.parseInt(ageStr);
            double weight = Double.parseDouble(weightStr);
            double height = Double.parseDouble(heightStr);

            if (gender.equals("male")) {
                dailyCalories = 66.473 + (13.752 * weight) + (5.003 * height) - (6.775 * age);
            } else if (gender.equals("female")) {
                dailyCalories = 655.1 + (9.563 * weight) + (1.85 * height) - (4.676 * age);
            } else {
                dailyCalories = 0.0d;
                System.out.println("Something went wrong");
            }

            dailyCalRes.setText(String.format(Locale.getDefault(), "%.0f", dailyCalories) + " kcal");
        }
    }
}