package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bagle {

    String SKU;
    double price;
    String variant;
    Filling filling;
    //List<String> fillings;

    public Bagle(String SKU, double price, String variant) {
        this.SKU = SKU;
        this.price = price;
        this.variant = variant;
        //fillings = new ArrayList<>();
    }

    public String getSKU() {
        return SKU;
    }

    public double getPrice() {
        return price;
    }

    public String getVariant() {
        return variant;
    }
/*
    public void addFilling(String filling) {
        fillings.add(filling);
    }

 */
}
