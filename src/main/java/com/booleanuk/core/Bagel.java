package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bagel extends Product {
    public final List<Filling> fillings = new ArrayList<>();

    public Bagel(String name, double price, String variant) {
        super(name, price, variant);
    }

    public void addFilling(Filling filling) {
        fillings.add(filling);
    }

    @Override
    public double getPrice() {
        double sum = 0;
        for (Filling filling : fillings) {
            sum += filling.getPrice();
        }
        sum += price;
        price = sum;
        return sum;
    }

}
