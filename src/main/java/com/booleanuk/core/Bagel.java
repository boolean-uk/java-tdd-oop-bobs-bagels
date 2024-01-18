package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel extends Product {
    private ArrayList<Filling> fillings;

    public Bagel(String variant, double price) {
        super("Bagel", variant, price);
        this.fillings = new ArrayList<>();
    }
}
