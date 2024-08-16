package com.booleanuk.core;

import java.util.HashMap;

public class Order {
   HashMap<String, Integer> basket = new HashMap<>();

    public void addProduct (Product product) {
        if (basket.isEmpty() ||!basket.containsKey(product.getSKU())) {
            {basket.put(product.getSKU(), 1);}
        } else basket.put(product.getSKU(), basket.get(product.getSKU()) + 1);
    }

}
