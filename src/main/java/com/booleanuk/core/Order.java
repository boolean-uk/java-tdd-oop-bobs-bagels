package com.booleanuk.core;

import java.util.*;

public class Order {
    private final ArrayList<Product> basket;
    private final Store store;
    private int maxBasketCapacity;
    private int currentBasketCapacity;

    public Order(Store store) {
        this.store = store;
        this.basket = new ArrayList<>();
        this.currentBasketCapacity = 0;
        this.maxBasketCapacity = 25;
    }

    public int getTotalSum() {
        return basket.isEmpty() ? 0 :  calculateTotalSum();
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
        basket.add(product);
        currentBasketCapacity++;
        return true;
    }

    public boolean removeProduct(Product product) {
        if (basket.contains(product)) {
            basket.remove(product);
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

    public List<Product> getBasket() {
        return basket;
    }

    public Store getStore() {
        return store;
    }

    private int calculateTotalSum() {
        int amountOfBagels = 0;
        int amountOfCoffees = 0;
        int resetAmount = 0;
        int totalFillingPrice = 0;

        // Lists to store individual prices of bagels and coffee
        ArrayList<Integer> bagelPrices = new ArrayList<>();
        ArrayList<Integer> coffeePrices = new ArrayList<>();

        // Iterate through the basket to calculate total reset amount and get number of bagels and coffees and there prices
        for (Product product : basket) {
            resetAmount += product.getPrice();

            // If the product is coffee, update coffee count and prices
            if (product instanceof Coffee coffee) {
                amountOfCoffees++;
                int coffeePrice = coffee.getPrice();
                coffeePrices.add(coffeePrice);
            }

            // If the product is a bagel, update the bagel count and prices
            if (product instanceof Bagel bagel) {
                amountOfBagels++;
                int fillingPrice = 0;

                // Calculate the total price of all fillings in the bagel
                if (bagel.getFillings() != null) {
                    for (Filling filling : bagel.getFillings()) {
                        fillingPrice += filling.getPrice();
                    }
                }

                // Subtract the filling price from the bagel price to get the base bagel price
                int bagelPrice = bagel.getPrice() - fillingPrice;

                // Add the total filling price to the overall filling price
                totalFillingPrice += fillingPrice;

                // Add the base bagel price to the list of bagel prices
                bagelPrices.add(bagelPrice);
            }

            // If the product is a filling, add the price to the total filling price
            if (product instanceof Filling filling) {
                totalFillingPrice += filling.getPrice();
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
            return resetAmount;
        } else {
            // Calculate the sum to add for remaining bagels and coffees (highest prices first)
            int sumToAdd = getSumToAdd(amountOfBagels, bagelPrices) + getSumToAdd(amountOfCoffees, coffeePrices) + totalFillingPrice;

            // Calculate the total sum with all applicable discounts
            return bagelCoffeePairs * 125 + numberOfTwelveBagelDiscounts * 399 + numberOfSixBagelDiscounts * 249 + sumToAdd;
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
