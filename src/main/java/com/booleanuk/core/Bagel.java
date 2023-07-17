package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bagel extends Product {
    private final List<Filling> fillings = new ArrayList<>();
    private double fillingsPrice = 0;

    public Bagel(String name, double price, String variant) {
        super(name, price, variant);
    }

    public void addFilling(Filling filling) {
        fillings.add(filling);
        fillingsPrice += filling.getPrice();
    }

    @Override
    public double getPrice() {
        double priceWithFillings = 0;
        priceWithFillings = fillingsPrice + price;
        return priceWithFillings;
    }

    public double getFillingsPrice() {
        return fillingsPrice;
    }

    public List<Filling> getFillings() {
        return fillings;
    }
}
