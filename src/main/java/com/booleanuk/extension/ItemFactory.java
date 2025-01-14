package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ItemFactory {
    private String id;
    private final HashMap<String, ArrayList<Object>> inventory = new HashMap<>() {{
        put("BGLP", new ArrayList<>(Arrays.asList(0.39, "Bagel", "Plain")));
        put("BGLE", new ArrayList<>(Arrays.asList(0.49, "Bagel", "Everything")));
        put("BGLO", new ArrayList<>(Arrays.asList(0.49, "Bagel", "Onion")));
        put("BGLS", new ArrayList<>(Arrays.asList(0.49, "Bagel", "Sesame")));
        put("COFB", new ArrayList<>(Arrays.asList(0.99, "Coffee", "Black")));
        put("COFW", new ArrayList<>(Arrays.asList(1.19, "Coffee", "White")));
        put("COFC", new ArrayList<>(Arrays.asList(1.29, "Coffee","Cappuccino")));
        put("COFL", new ArrayList<>(Arrays.asList(1.29, "Coffee", "Latte")));
        put("FILB", new ArrayList<>(Arrays.asList(0.12, "Filling", "Bacon")));
        put("FILE", new ArrayList<>(Arrays.asList(0.12, "Filling", "Egg")));
        put("FILC", new ArrayList<>(Arrays.asList(0.12, "Filling", "Cheese")));
        put("FILX", new ArrayList<>(Arrays.asList(0.12, "Filling", "Cream Cheese")));
        put("FILS", new ArrayList<>(Arrays.asList(0.12, "Filling", "Smoked Salmon")));
        put("FILH", new ArrayList<>(Arrays.asList(0.12, "Filling", "Ham")));
    }};


    //private internal setters
    private double setPrice() {
        return (double) inventory.get(this.id).getFirst();
    }

    private String setDescription() {
        return (String) inventory.get(this.id).get(2);
    }

    // create and return new instance of bagel, coffee or filling based on what the provided SKU (id) was
    public Item createItem(String id) {
        this.id = id;
        if (this.inventory.containsKey(this.id)) {
            if (this.id.startsWith("B")) {
                return new Bagel(this.id, setPrice(), setDescription());

            } else if (this.id.startsWith("C")) {
                return new Coffee(this.id, setPrice(), setDescription());

            } else if (this.id.startsWith("F")) {
                return new Filling(this.id, setPrice(), setDescription());
            }
        }
        return null;
    }

}
