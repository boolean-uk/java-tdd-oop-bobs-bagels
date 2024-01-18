package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel extends Product {
    private ArrayList<Filling> fillings;
    private double basePrice;

    public Bagel(String variant, double price) {
        super("Bagel", variant, price);
        this.fillings = new ArrayList<>();
        this.basePrice = price;
    }

    private void updatePrice() {
        double newPrice = basePrice;
        for(Filling filling : fillings) {
                newPrice += filling.getPrice();
        }
        this.price = newPrice;
    }

}
