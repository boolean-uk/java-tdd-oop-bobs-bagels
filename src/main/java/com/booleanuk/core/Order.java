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
        if (!findProductInInventory(product.getSKU())) {
            return false;
        }
        if (product instanceof Fillings) {
            if (!isBagelInBasket()) {
                System.out.println("You have to choose a bagel first before you can add a filling");
                return false;
            }
        }
        basket.put(product.getSKU(), basket.getOrDefault(product.getSKU(), 0) + 1);
        return true;
    }

    public boolean findProductInInventory(String SKU) {
        for (int i = 0; i < store.inventory.length; i++) {
            if (store.inventory[i].getSKU().equals(SKU)) {
                return true;
            }
        }
        return false;
    }

    public boolean isBagelInBasket() {
        return (basket.keySet().stream().anyMatch(key -> key.startsWith("BGL")));

    }

    public double getPriceProduct(Product product) {
        return product.getPrice();
    }


    public void removeProduct(Product product) {

    }
}

