package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel extends Product{
    private ArrayList<Filling> fillings;

    public Bagel(String name, String sku, double price) {
        super(name, sku, price);
        this.fillings = new ArrayList<>();
    }

    public boolean addFilling(Filling filling) {
        this.fillings.add(filling);
        return true;
    }

}
