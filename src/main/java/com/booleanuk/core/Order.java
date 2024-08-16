package com.booleanuk.core;

import java.util.HashMap;
import java.util.Scanner;


public class Order {

    HashMap<String, Integer> basket = new HashMap<>();
    Store store = new Store();
    Scanner in = new Scanner(System.in);

    public boolean addProduct(Product product) {
        if (store.getCapacity() == basket.size()) {
            System.out.println("You reached max capacity");
            return false;
        }
            if (findProductInInventory(product.getSKU())) {
                if(product.getSKU().startsWith("FIL")) {
                    if(!addFilling()) {
                        System.out.println("You have to choose a bagel first before you can add a filling");
                        return false;
                    }
                }
                if (!basket.containsKey(product.getSKU())) {
                    basket.put(product.getSKU(), 1);
                    return true;
                } else {
                    basket.put(product.getSKU(), basket.get(product.getSKU()) + 1);
                    return true;
                }
            }

        return false;
    }

    public boolean findProductInInventory(String SKU) {
        for (int i = 0; i < store.inventory.length; i++) {
            if (store.inventory[i].getSKU().equals(SKU)) {
                return true;
            }
        }
        return false;
    }

    public boolean addFilling() {
        return (basket.keySet().stream().anyMatch(key -> key.startsWith("BGL")));

    }

    public double getPriceProduct(Product product) {
        return product.getPrice();
    }


    public void removeProduct(Product product) {

    }
}

