package com.booleanuk.core;

import java.util.HashMap;

public class Store {
    private HashMap<Integer, Basket> baskets;
    private HashMap<String, Double> inventory;

    public Store() {
        baskets = new HashMap<>();
        initilizeInventory();
    }
    public int createBasket() {
        Basket basket = new Basket();
        baskets.put(basket.hashCode(), basket);
        return basket.hashCode();
    }

    public HashMap<Integer,Basket> getBaskets() {
        return baskets;
    }

    public String addBagelToBasket(String bagel, int basketId) {
        String sku = "BGL" + bagel.toUpperCase().charAt(0);
        if(!inventory.containsKey(sku)) {
            return "Bob's bagels doesn't have that bagel.";
        }
        baskets.get(basketId).addBagel(new Bagel(bagel));
        return "Bagel added.";
    }

    private void initilizeInventory() {
        inventory = new HashMap<>();
        inventory.put("BGLO", 0.49);
        inventory.put("BGLP", 0.39);
        inventory.put("BGLE", 0.49);
        inventory.put("BGLS", 0.49);
        inventory.put("COFB", 0.99);
        inventory.put("COFW", 1.19);
        inventory.put("COFC", 1.29);
        inventory.put("COFL", 1.29);
        inventory.put("FILB", 0.12);
        inventory.put("FILE", 0.12);
        inventory.put("FILC", 0.12);
        inventory.put("FILX", 0.12);
        inventory.put("FILS", 0.12);
        inventory.put("FILH", 0.12);

    }
}
