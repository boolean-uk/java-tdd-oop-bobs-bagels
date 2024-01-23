package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel {
    String name;
    String productID;
    String uniqueID;
    double price;
    ArrayList<Filling> fillings;
    public Bagel(String name, String productID, double price) {
        this.name = name;
        this.productID = productID;
        this.uniqueID = "abc";  //If there are more than one e.g. sesame bagel, this ID can be used to navigate to the right bagel
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
}
