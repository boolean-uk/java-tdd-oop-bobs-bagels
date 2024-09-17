package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.HashMap;

public class Bagel extends Product {
    private ArrayList<String> selectedFillings = new ArrayList<>();

    public Bagel(String name, double price, String SKU) {
        super(name, price, SKU);
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
        double totalPrice = getPrice();
        for (String filling : selectedFillings) {
            if (fillingInventory.containsKey(filling)) {
                totalPrice += fillingInventory.get(filling).getPrice();
            }
        }
        return totalPrice;
    }
}
