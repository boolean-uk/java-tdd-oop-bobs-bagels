package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Coffee implements Product{
    private  String id;
    private String name;
    private double price;
    private String variant;


    public Coffee(String id, double price, String variant) {
        this.id = id;
        this.name = "Coffee";
        this.price = price;
        this.variant = variant;
    }

    public String getId() {
        return id;
    }
    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getVariant() {
        return variant;
    }

    @Override
    public boolean addFillings(ArrayList<Filling> fillings) {
        return false;
    }

    @Override
    public ArrayList<Filling> getFillings() {
        return null;
    }
}
