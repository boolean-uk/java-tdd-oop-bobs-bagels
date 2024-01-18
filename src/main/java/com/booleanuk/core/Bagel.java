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

    public double getBasePrice() {
        return this.basePrice;
    }

    public void setBasePrice(double price) {
        this.basePrice = price;
        updatePrice();
    }

    @Override
    public double getPrice() {
        updatePrice();
        return this.price;
    }

    public void addFilling(Filling filling) {
        this.fillings.add(filling);
        updatePrice();
    }

    public ArrayList<Filling> getFillings() {
        return this.fillings;
    }
}
