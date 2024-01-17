package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel extends Item {

    private ArrayList<Filling> fillings = new ArrayList<>();


    public Bagel(String variant) {
        super(variant);
        this.setName("Bagel");
        this.setPrice(0.39);
    }

    public boolean addFilling(Filling filling) {
        fillings.add(filling);
        return true;

    }
}
