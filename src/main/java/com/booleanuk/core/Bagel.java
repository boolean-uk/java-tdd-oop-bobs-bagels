package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Collection;

public class Bagel extends Item {

    private ArrayList<Filling> fillings = new ArrayList<>();


    public Bagel(String variant) {
        super(variant);
        this.setName("Bagel");
        this.setPriceOfBagel(variant);
        this.setSkuCode("BGL" + variant.toUpperCase().charAt(0));
    }

    public boolean addFilling(Filling filling) {
        this.fillings.add(filling);
        return true;

    }

    private void setPriceOfBagel(String variant) {
        if(variant.equalsIgnoreCase("Plain")) {
            this.setPrice(0.39);
        } else {
            this.setPrice(0.49);
        }
    }

    public boolean removeFilling(Filling filling) {
        this.fillings.remove(filling);
        return true;
    }

    public ArrayList<Filling> getFillings() {
        return this.fillings;
    }
}
