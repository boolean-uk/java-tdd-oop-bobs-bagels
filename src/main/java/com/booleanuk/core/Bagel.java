package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel extends Item {

    private ArrayList<Filling> fillings = new ArrayList<>();


    public Bagel(String variant) {
        super(variant);
        this.setName("Bagel");
        this.setPriceOfBagel(variant);
    }

    public boolean addFilling(Filling filling) {
        fillings.add(filling);
        return true;

    }

    private void setPriceOfBagel(String variant) {
        if(variant.equalsIgnoreCase("Plain")) {
            this.setPrice(0.39);
        } else {
            this.setPrice(0.49);
        }
    }
}
