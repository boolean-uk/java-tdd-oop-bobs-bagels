package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Product> inventoryList;

    public Inventory() {
        inventoryList = new ArrayList<>();
        inventoryList.add(new Product("BGLO", 0.49, "Bagel", "Onion"));
        inventoryList.add(new Product("BGLP", 0.39, "Bagel", "Plain"));
    }

    public List<Product> getInventoryList() {
        return inventoryList;
    }
}
