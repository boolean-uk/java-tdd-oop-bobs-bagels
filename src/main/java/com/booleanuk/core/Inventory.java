package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    HashMap<Product, Integer> inventory; // <Product, the quantity of this product in stock>

    public Inventory() {
        this.inventory = new HashMap<>();

        // Some hardcoded products just for testing (will expand over time)
        this.inventory.put(new OnionBagel(), 1);
        this.inventory.put(new PlainBagel(), 1);
        this.inventory.put(new SmokedSalmonFilling(), 1);
    }

    public boolean productIsInStock(Product p) {
        for (Map.Entry<Product, Integer> kvp : this.inventory.entrySet()) {
            if (kvp.getKey().getSKU().equals(p.getSKU()) && kvp.getValue() > 0) return true;
        }
        return false;
    }

}
