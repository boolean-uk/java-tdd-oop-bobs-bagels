package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Bagel {
    private ArrayList<Filling> fillings;
    //private HashMap<Filling, Integer> fillings;
    private String id;
    private String name;
    private double price;
    private String variant;
    private static final Inventory inventory = new Inventory();

    public Bagel(String id, Filling[] fillings){
        this(id);
        for (Filling filling : fillings){
            this.addFilling(filling);
        }
    }
    public Bagel(String id) throws IllegalStateException {
        this.id = id;
        this.name = "Bagel";
        this.fillings = new ArrayList<>();
        switch (id) {
            case "BGLO" -> {
                this.variant = "Onion";
                this.price = 0.49;
            }
            case "BGLP" -> {
                this.variant = "Plain";
                this.price = 0.39;
            }
            case "BGLE" -> {
                this.variant = "Everything";
                this.price = 0.49;
            }
            case "BGLS" -> {
                this.variant = "Sesame";
                this.price = 0.49;
            }
            default -> throw new IllegalStateException("Unexpected value: " + id);
        }
    }

    public void addFilling(Filling filling){
        this.fillings.add(filling);
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

    public String getId(){
        return this.id;
    }
}
