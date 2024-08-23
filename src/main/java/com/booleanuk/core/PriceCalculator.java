package com.booleanuk.core;

public class PriceCalculator {

    // TODO: How to write a class comment?
    // This class should calculate price.
    // The aim is to fix so InventoryItem and basket have a common approach on rounding numbers

    // Use double or float, float saves memory, double is easier to work with

    public double round(float total, int numOfDecimals) {

        // TODO: Should I use float or double?
        // change here or change on objects
        // Now the object has float on price, and totalCost has double

        // Resource: https://www.baeldung.com/java-round-decimal-number

        double scale = Math.pow(10, numOfDecimals);
        double rounded = Math.round(total * scale) / scale;

        return rounded;
    }
}
