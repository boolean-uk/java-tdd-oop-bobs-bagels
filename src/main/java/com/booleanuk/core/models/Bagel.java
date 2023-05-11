package com.booleanuk.core.models;

import java.util.ArrayList;
import java.util.Arrays;

public class Bagel {
    private String variant;
    private double price;
    private String SKU;
    private ArrayList<Filling> fillings;

    public Bagel(String variant, double price, String SKU ) {
        this.variant = variant;
        this.price = price;
        this.SKU = SKU;
        this.fillings = new ArrayList<>();
    }

    public void addFillings(Filling[] fillings) {
        this.fillings.addAll(Arrays.asList(fillings));
    }
}
