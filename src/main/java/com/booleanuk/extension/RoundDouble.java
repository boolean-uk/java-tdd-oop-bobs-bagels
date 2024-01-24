package com.booleanuk.extension;

public abstract class RoundDouble { // Helper class

    public static double round(double number, int decimalPlaces) {
        double roundedNumber = number;
        roundedNumber = roundedNumber * Math.pow(10, decimalPlaces);
        roundedNumber = Math.round(roundedNumber) / Math.pow(10, 2);
        return roundedNumber;
    }



}
