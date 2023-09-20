package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket {
    private int capacity;
    private ArrayList<Product> basket;

    public Basket(int capacity) {
        this.capacity = capacity;
        this.basket = new ArrayList<>(capacity);
    }

    public String addProduct(Product product) {
        if (basket.size() < capacity) {
            basket.add(product);
            return "Product added to the basket";
        }
        return "Basket is full";
    }

    public String removeProduct(Product product) {
        if (!basket.contains(product)) {
            return "This product does not exist in the basket";
        }
        basket.remove(product);
        return "Removed from the basket";
    }

    public boolean isBasketFull() {
        return basket.size() >= capacity;
    }

    public String setCapacity(int newCapacity) {
        capacity = newCapacity;
        basket.ensureCapacity(newCapacity);
        return "Capacity changed";
    }

    public double getTotalCost (Inventory inventory) {
        double totalCost = 0.0;
        HashMap<String, Integer> productCount = new HashMap<>();

        for (Product product : basket) {
            String SKU = product.getSKU();
            productCount.put(SKU, productCount.getOrDefault(SKU, 0) + 1);
        }

        for (String SKU : productCount.keySet()) {
            int count = productCount.get(SKU);
            Product product = inventory.getProductInventory().get(SKU);
            SpecialOffer offer = inventory.getSpecialOffer(SKU);

            if (offer != null && count >= offer.getQuantity()) {
                int fullOffers = count / offer.getQuantity();
                int remaining = count % offer.getQuantity();

                totalCost += (fullOffers * offer.getOfferPrice()) + (remaining * product.getPrice());
            } else {
                totalCost += count * product.getPrice();
            }
        }

        return totalCost;
    }

    public Receipt generateReceipt(String storeName, Inventory inventory) {
        Receipt receipt = new Receipt(storeName);
        HashMap<String, Integer> productCount = new HashMap<>();

        for (Product product : basket) {
            String SKU = product.getSKU();
            productCount.put(SKU, productCount.getOrDefault(SKU, 0) + 1);
        }

        for (String SKU : productCount.keySet()) {
            int count = productCount.get(SKU);
            Product product = inventory.getProductInventory().get(SKU);
            SpecialOffer offer = inventory.getSpecialOffer(SKU);

            if (offer != null && count >= offer.getQuantity()) {
                int fullOffers = count / offer.getQuantity();
                int remaining = count % offer.getQuantity();
                double cost = (fullOffers * offer.getOfferPrice()) + (remaining * product.getPrice());
                receipt.addItem(product, count, cost, offer.getOfferPrice());
            } else {
                double cost = count * product.getPrice();
                receipt.addItem(product, count, cost, 0.0);
            }
        }

        return receipt;
    }

}
