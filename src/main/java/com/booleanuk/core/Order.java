package com.booleanuk.core;

import java.util.HashMap;

public class Order {
   HashMap<String, Integer> basket = new HashMap<>();
    Store store = new Store();
    public void addProduct (Product product) {
        for(int i = 0; i < store.inventory.length; i++) {
            if(store.inventory[i].getSKU().equals(product.getSKU())) {
                if (basket.isEmpty() ||!basket.containsKey(product.getSKU())) {
                    {basket.put(product.getSKU(), 1);}
                } else basket.put(product.getSKU(), basket.get(product.getSKU()) + 1);
            }
        }

    }

}
