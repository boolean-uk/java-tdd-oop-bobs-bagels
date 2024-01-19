package com.booleanuk.core;

import java.util.ArrayList;

public class Bagel {
    private ArrayList<Filling> fillings;
    private String id;
    private String name;
    private double price;
    private String variant;
;

    public Bagel(String id, double price, String variant, ArrayList<Filling> fillings){
        this(id, price, variant);
        this.fillings = fillings;
    }

    public Bagel(String id, double price, String variant) {
        this.id = id;
        this.name = "Bagel";
        this.price = price;
        this.variant = variant;

        this.fillings = new ArrayList<>();
    }
    public void addFilling(Filling filling){
        this.fillings.add(filling);
    }
    public String getId(){
        return this.id;
    }
    public double getPrice() {
        return this.price;
    }

    public ArrayList<Filling> getFillings() {
        return this.fillings;
    }

    public String getName() {
        return this.name;
    }

    public String getVariant() {
        return this.variant;
    }
}
