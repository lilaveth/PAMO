package com.example.bmicalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DailyCaloriesTest {
    @Test
    public void testBMICalculationFemale() {
        String gender = "female";
        double weight = 52;
        double height = 162;
        int age = 30;
        assertEquals(DailyCaloriesCalculator.calculateDailyCalories(gender, weight, height, age), 1312, 1);
    }

    @Test
    public void testBMICalculationMale() {
        String gender = "male";
        double weight = 80;
        double height = 174;
        int age = 27;
        assertEquals(DailyCaloriesCalculator.calculateDailyCalories(gender, weight, height, age), 1854, 1);
    }
}
