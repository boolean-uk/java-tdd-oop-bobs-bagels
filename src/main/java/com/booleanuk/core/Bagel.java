package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bagel extends Product {
    private final List<Filling> fillings = new ArrayList<>();

    public Bagel(String name, double price, String variant) {
        super(name, price, variant);
    }

    public void addFilling(Filling filling) {
        fillings.add(filling);
    }

    @Override
    public double getPrice() {
        int sum = 0;
        for (Filling filling : fillings) {
            sum += filling.getPrice();
        }
        return price + sum;
    }
}
