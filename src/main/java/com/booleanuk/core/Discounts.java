package com.booleanuk.core;

public enum Discounts {
    SixBagels(0.45d), ThreeBagels(0.20d), CoffeeAndBagel(0.15d);
    private final double discountAmount;

    Discounts(double amount){
        this.discountAmount = amount;
    }

    double getAmount(){
        return this.discountAmount;
    }
}
