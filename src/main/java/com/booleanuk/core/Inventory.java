package com.booleanuk.core;

import java.util.HashMap;

public class Inventory {
    private HashMap<String, Product> products;

    public Inventory(){
        products = new HashMap<String, Product>();
        populateInventory();
    }

    private void populateInventory() {

    }
}
