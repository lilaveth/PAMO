package com.example.bmicalculator;

import java.util.Locale;

public class DailyCaloriesCalculator {
    public static double calculateDailyCalories(String gender, double weight, double height, int age) {
        if (gender.equals("male")) {
            return 66.473 + (13.752 * weight) + (5.003 * height) - (6.775 * age);
        } else if (gender.equals("female")) {
            return 655.1 + (9.563 * weight) + (1.85 * height) - (4.676 * age);
        } else {
            System.out.println("Something went wrong");
            return 0.0d;
        }
    }
}
