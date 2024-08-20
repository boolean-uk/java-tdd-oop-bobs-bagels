package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel extends Item {
    ArrayList<Filling> fillings = new ArrayList<>();
    Integer totalPriceIncludingFillings;

    public Bagel(String sku, Integer price, String name, String variant){
        super(sku, price, name, variant);
        totalPriceIncludingFillings = price;
    }

    public String addFilling(Filling filling){
        if (filling != null){
            fillings.add(filling);
            return filling.variant + " added to your bagel.";
        }
        else
            return "Invalid filling. Please try again";
    }
    public ArrayList<Filling> getFillings() { return new ArrayList<Filling>();}
}

