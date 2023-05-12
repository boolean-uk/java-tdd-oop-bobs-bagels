package com.booleanuk.core.models;

import java.util.ArrayList;
import java.util.Arrays;

public class Bagel {
    String variant;
     double price;
    String SKU;
    ArrayList<Filling> fillings;

    public Bagel(String variant, double price, String SKU ) {
        this.variant = variant;
        this.price = price;
        this.SKU = SKU;
        this.fillings = new ArrayList<>();
    }

    public void addFillings(Filling[] fillings) {
        this.fillings.addAll(Arrays.asList(fillings));
    }

    public double getPrice() {
        return price;
    }

    public ArrayList<Filling> getFillings() {
        return fillings;
    }

}
