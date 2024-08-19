package com.booleanuk.core;

import java.util.HashMap;
import java.util.NoSuchElementException;


public class Order {

    private HashMap<String, Integer> basket = new HashMap<>();
    private final Store store;
    private int totalPrice;

    Order(Store store) {
        this.store = store;
    }

    public boolean addProduct(Product product) {
        if (store.getCapacity() == basket.size()) {
            System.out.println("You reached max capacity");
            return false;
        }
        if (!store.findProductInInventory(product.getSKU())) {
            return false;
        }
        if (product instanceof Fillings) {
            if (!isBagelInBasket()) {
                System.out.println("You have to choose a bagel first before you can add a filling");
                return false;
            }
        }
        basket.put(product.getSKU(), basket.getOrDefault(product.getSKU(), 0) + 1);
        this.totalPrice += (int) (product.getPrice() * 100);
        return true;
    }

    public int sizeOfBasket() {
        return basket.size();
    }

    public boolean containsKeyBasket(String SKU) {
        return basket.containsKey(SKU);
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
        return totalPrice / 100.0;
    }
}

