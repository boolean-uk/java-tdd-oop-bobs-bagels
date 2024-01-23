package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel {
    String name;
    String sku;
    String uniqueID;
    double price;
    ArrayList<Filling> fillings;

    public Bagel(String name, String sku, double price) {
        this.name = name;
        this.sku = sku;
        this.uniqueID = "abc";  //If there are more than one e.g. sesame bagel, this ID could be used to navigate to the right bagel. Currently not in use
        this.price = price;
        this.fillings = new ArrayList<>();
    }

    public double getPrice() {
        return this.price;
    }

    public boolean addFilling(Filling filling) {
        this.fillings.add(filling);
        return true;
    }

    public String getSku() {
        return this.sku;
    }
}
