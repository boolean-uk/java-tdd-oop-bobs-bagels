package com.booleanuk.core;

import java.util.HashMap;

public class Order {

    HashMap<String, Integer> basket = new HashMap<>();
    Store store = new Store();

    public boolean addProduct(Product product) {
        if (store.getCapacity() == basket.size()) {
            System.out.println("You reached max capacity");
            return false;
        }
        for (int i = 0; i < store.inventory.length; i++) {
            if (store.inventory[i].getSKU().equals(product.getSKU())) {
                if (basket.isEmpty() || !basket.containsKey(product.getSKU())) {
                    basket.put(product.getSKU(), 1);
                    return true;
                } else {
                    basket.put(product.getSKU(), basket.get(product.getSKU()) + 1);
                    return true;
                }
            }
        }
        return false;
    }


    public void removeProduct(Product product) {


    }
}

