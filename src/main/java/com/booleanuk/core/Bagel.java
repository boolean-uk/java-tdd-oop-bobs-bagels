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
        price += filling.getPrice();
    }
}
