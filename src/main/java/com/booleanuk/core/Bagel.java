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
        double twoDecimalPrice = newPrice; // Messy, wouldn't do this normally.
        twoDecimalPrice = twoDecimalPrice * Math.pow(10, 2);
        twoDecimalPrice = Math.round(twoDecimalPrice) / Math.pow(10, 2);
        this.price = twoDecimalPrice;
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

    @Override
    public void setPrice(double price) {
        setBasePrice(price);
    }

    public void addFilling(Filling filling) {
        System.out.println(
                filling.getSku() + " " + filling.getName() + " " + filling.getVariant() + ": " + filling.getPrice()
        );
        this.fillings.add(filling);
        updatePrice();
    }

    public ArrayList<Filling> getFillings() {
        return this.fillings;
    }
}
