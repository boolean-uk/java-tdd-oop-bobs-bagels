package com.booleanuk.core;

public class Bagel {
    String name;
    String productID;
    String uniqueID;
    double price;
    public Bagel(String name, String productID, double price) {
        this.name = name;
        this.productID = productID;
        this.uniqueID = "abc";  //If there are more than one e.g. sesame bagel, this ID can be used to navigate to the right bagel
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }
}
