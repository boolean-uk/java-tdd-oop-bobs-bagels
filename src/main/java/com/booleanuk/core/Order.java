package com.booleanuk.core;

import java.util.*;

public class Order {
    private final Map<String, Integer> basket;
    private int totalSum;
    private int maxBasketCapacity = 25;
    private int currentBasketCapacity;

    public Order() {
        this.totalSum = 0;
        this.basket = new HashMap<>();
        this.currentBasketCapacity = 0;
    }

    public int getTotalSum() {
        applyDiscounts();
        return totalSum;
    }

    public int getProductPrice(String SKU) {
        if (SKU == null) {
            throw new IllegalArgumentException("SKU cannot be null");
        }

        if (SKU.isEmpty()) {
            System.out.println("Product not found in the inventory");
            return -1;
        }
        Inventory inventory = new Inventory();
        Product product = inventory.getProduct(SKU);
        if (product == null) {
            System.out.println("Product not found in the inventory");
            return -1;
        }

        return product.getPrice();
    }

    public boolean addProduct(Product product) {
        if (isBasketFull()) {
            return false;
        }
        if (basket.containsKey(product.getSKU())) {
            basket.put(product.getSKU(), basket.get(product.getSKU()) + 1);
        } else {
            basket.put(product.getSKU(), 1);
        }
        totalSum += product.getPrice();
        currentBasketCapacity++;
        return true;
    }

    public boolean removeProduct(Product product) {
        if (basket.containsKey(product.getSKU())) {
            int productCount = basket.get(product.getSKU());
            if (productCount > 1) {
                basket.put(product.getSKU(), productCount - 1);
            } else {
                basket.remove(product.getSKU());
            }
            totalSum -= product.getPrice();
            currentBasketCapacity--;
            return true;
        }
        System.out.println("Product not found in the basket");
        return false;
    }

    private boolean isBasketFull() {
        return currentBasketCapacity >= maxBasketCapacity;
    }

    public void incrementBasketCapacity() {
        int sizeToIncrement = 5;
        maxBasketCapacity += sizeToIncrement;
    }

    public int getMaxBasketCapacity() {
        return maxBasketCapacity;
    }

    public Map<String, Integer> getBasket() {
        return basket;
    }

    private void applyDiscounts() {
        int amountOfBagels = 0;
        int amountOfCoffees = 0;
        int resetAmount = 0;

        // Lists to store individual prices of bagels and coffee
        ArrayList<Integer> bagelPrices = new ArrayList<>();
        ArrayList<Integer> coffeePrices = new ArrayList<>();

        // Create an instance of Inventory to get product prices
        Inventory inventory = new Inventory();

        // Iterate through the basket to calculate total reset amount and get number of bagels and coffees and there prices
        for (Map.Entry<String, Integer> entry : basket.entrySet()) {
            resetAmount += entry.getValue() * inventory.getProduct(entry.getKey()).getPrice();

            // If the product is coffee, update coffee count and prices
            if (entry.getKey().startsWith("COF")) {
                amountOfCoffees += entry.getValue();
                int coffeePrice = inventory.getProduct(entry.getKey()).getPrice();
                for (int i = 0; i < entry.getValue(); i++) {
                    coffeePrices.add(coffeePrice);
                }
            }
            // If the product is a bagel, update bagel count and prices
            if (entry.getKey().startsWith("BGL")) {
                amountOfBagels += entry.getValue();
                int bagelPrice = inventory.getProduct(entry.getKey()).getPrice();
                for (int i = 0; i < entry.getValue(); i++) {
                    bagelPrices.add(bagelPrice);
                }
            }
        }

        // Calculate the number of 12-bagel and 6-bagel discounts and update the amount
        // of bagels to only have the remaining bagels
        int numberOfTwelveBagelDiscounts = amountOfBagels / 12;
        amountOfBagels %= 12;
        int numberOfSixBagelDiscounts = amountOfBagels / 6;
        amountOfBagels %= 6;

        // Calculate the number of bagel and coffee pairs for discounts
        int bagelCoffeePairs = Math.min(amountOfBagels, amountOfCoffees);
        // Adjust the remaining bagels and coffees after applying pair discounts
        amountOfBagels -= bagelCoffeePairs;
        amountOfCoffees -= bagelCoffeePairs;

        // If no discounts apply, set totalSum to resetAmount
        if (numberOfTwelveBagelDiscounts == 0 && numberOfSixBagelDiscounts == 0 && bagelCoffeePairs == 0) {
            totalSum = resetAmount;
        } else {
            // Calculate the sum to add for remaining bagels and coffees (highest prices first)
            int sumToAdd = getSumToAdd(amountOfBagels, bagelPrices);
            sumToAdd += getSumToAdd(amountOfCoffees, coffeePrices);

            // Calculate the total sum with all applicable discounts
            totalSum = bagelCoffeePairs * 125 + numberOfTwelveBagelDiscounts * 399 + numberOfSixBagelDiscounts * 249 + sumToAdd;
        }
    }

    private int getSumToAdd(int amountOfProducts, ArrayList<Integer> ProductPrices) {
        int sumToAdd = 0;
        if (amountOfProducts > 0) {
            // Sort the list in descending order to get the highest prices first
            ProductPrices.sort(Comparator.reverseOrder());
            for (int i = 0; i < amountOfProducts; i++) {
                sumToAdd += ProductPrices.get(i);
            }
        }
        return sumToAdd;
    }

}
