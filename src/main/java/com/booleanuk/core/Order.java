package com.booleanuk.core;

import java.util.HashMap;
import java.util.NoSuchElementException;


public class Order {

    HashMap<String, Integer> basket = new HashMap<>();
    private final Store store = new Store();
    private double totalPrice;

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
        this.totalPrice += product.getPrice();
        return true;
    }

    private boolean findProductInInventory(String SKU) {
        for (int i = 0; i < store.inventory.length; i++) {
            if (store.inventory[i].getSKU().equals(SKU)) {
                return true;
            }
        }
        return false;
    }

    private boolean isBagelInBasket() {
        return (basket.keySet().stream().anyMatch(key -> key.startsWith("BGL")));

    }

    public double getPriceProduct(Product product) {
        return product.getPrice();
    }


    public void removeProduct(Product product) {
        if (!basket.containsKey(product.getSKU())) {
            throw new NoSuchElementException("Product not found in the basket");
        }
        basket.remove(product.getSKU());
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

