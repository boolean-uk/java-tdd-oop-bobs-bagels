package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Bagel {

    private String type;
    private double price;
    private ArrayList<String> selectedFillings = new ArrayList<>();

    public Bagel(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public ArrayList<String> getFillings() {
        return new ArrayList<>(selectedFillings);
    }

    public boolean addFilling(String filling, HashMap<String, Filling> fillingsInventory) {
        if (fillingsInventory.containsKey(filling)) {
            selectedFillings.add(filling);
            return true;
        }
        return false;
    }

    public double calculateBagelsCost(HashMap<String, Filling> fillingInventory) {
        double totalPrice = price;
        for (String filling : selectedFillings) {
            if (fillingInventory.containsKey(filling)) {
                totalPrice += fillingInventory.get(filling).getCost();
            }
        }
        return totalPrice;
    }

}