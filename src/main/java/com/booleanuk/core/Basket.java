package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Basket {

    private int capacity;
    private ArrayList<Bagel> products = new ArrayList<>();

    public Basket(int capacity) {
        this.capacity = capacity;
    }

    public void addProduct(Bagel bagel)  {
        if (isFull()) {
            throw new NoSuchElementException("Basket is already full");
        }
        products.add(bagel);
    }

    public void removeProduct(Bagel bagel) {
        if (!products.contains(bagel)) {
            throw new NoSuchElementException("You dont have this product in your basket");
        }
        products.remove(bagel);
    }

    public boolean isFull() {
        return getProductsQuantity() == capacity;
    }

    public void changeCapacity(int newCapacity) {
        if (newCapacity < getProductsQuantity()) {
            throw new IllegalArgumentException("You cannot do it");
        }
        this.capacity = newCapacity;
    }

    public double getTotalCost() {
        double totalCost = 0.0;
        Map<String, Integer> bagelCounts = countBagels();

        for (Bagel bagel : products) {
            double bagelPrice = bagel.getPrice();
            if (bagelCounts.containsKey(bagel.getSku())) {
                int count = bagelCounts.get(bagel.getSku());
                double specialPrice = getBagelSpecialPrice(bagel.getSku(), count);
                if (specialPrice != -1.0) {
                    bagelPrice = specialPrice;
                    bagelCounts.put(bagel.getSku(), count - 1);
                }
            }
            totalCost += bagelPrice;
        }

        return totalCost;
    }

    private Map<String, Integer> countBagels() {
        Map<String, Integer> bagelCounts = new HashMap<>();
        for (Bagel bagel : products) {
            bagelCounts.put(bagel.getSku(), bagelCounts.getOrDefault(bagel.getSku(), 0) + 1);
        }
        return bagelCounts;
    }

    public double getBagelSpecialPrice(String sku, int count) {
        Map<String, Double> specialPrices = new HashMap<>();
        specialPrices.put("BGLO", 2.49);
        specialPrices.put("BGLP", 3.99);
        specialPrices.put("BGLE", 2.49);

        if (specialPrices.containsKey(sku) && count > 0) {
            int offerQuantity = getOfferQuantity(sku);
            if (count % offerQuantity == 0) {
                return specialPrices.get(sku) * (count / offerQuantity);
            }
        }

        return -1.0;
    }

    private int getOfferQuantity(String sku) {
        Map<String, Integer> offerQuantities = new HashMap<>();
        offerQuantities.put("BGLO", 6);
        offerQuantities.put("BGLP", 12);
        offerQuantities.put("BGLE", 6);

        return offerQuantities.getOrDefault(sku, 1);
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getProductsQuantity() {
        return products.size();
    }

    public ArrayList<Bagel> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Bagel> products) {
        this.products = products;
    }
}
