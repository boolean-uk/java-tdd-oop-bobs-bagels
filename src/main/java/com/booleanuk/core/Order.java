package com.booleanuk.core;

import java.util.*;

public class Order {
    private final ArrayList<Product> basket;
    private Map<Integer, Integer> twelveBagelDiscounts;
    private Map<Integer, Integer> sixBagelDiscounts;
    private Map<Integer, Integer> coffeeBagelPairsDiscount;
    private Map<Product, Integer> nonDiscountedProductsMap;
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
        return basket.isEmpty() ? 0 : calculateTotalSum();
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
        Product product;
        try {
            product = inventory.getProduct(SKU);
        } catch (IllegalArgumentException e) {
            return -1;
        }
        if (product == null) {
            System.out.println("Product not found in the inventory");
            return -1;
        }

        return product.getPrice();
    }

    public boolean addProduct(Product product) {
        if (isBasketFull()) {
            System.out.println("Basket is full");
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

    public Map<Integer, Integer> getTwelveBagelDiscounts() {
        return twelveBagelDiscounts;
    }

    public Map<Integer, Integer> getSixBagelDiscounts() {
        return sixBagelDiscounts;
    }

    public Map<Integer, Integer> getCoffeeBagelPairsDiscount() {
        return coffeeBagelPairsDiscount;
    }

    public Map<Product, Integer> getNonDiscountedProductsMap() {
        return nonDiscountedProductsMap;
    }

    public Store getStore() {
        return store;
    }

    private int calculateTotalSum() {
        ArrayList<Product> bagels = new ArrayList<>();
        ArrayList<Product> coffees = new ArrayList<>();
        ArrayList<Product> fillings = new ArrayList<>();
        int resetAmount = 0;
        int totalBagelFillingPrice = 0;

        // Iterate through the basket to calculate total reset amount and get number of bagels and coffees and there prices
        for (Product product : basket) {
            resetAmount += product.getPrice();

            // If the product is coffee, update coffee count and prices
            if (product instanceof Coffee coffee) {
                coffees.add(coffee);
            }

            // If the product is a bagel, update the bagel count and prices
            if (product instanceof Bagel bagel) {
                bagels.add(bagel);
                int fillingPrice = 0;

                // Calculate the total price of all fillings in the bagel
                if (bagel.getFillings() != null) {
                    for (Filling filling : bagel.getFillings()) {
                        fillingPrice += filling.getPrice();
                        fillings.add(filling);
                    }
                }

                // Add the total filling price to the overall filling price
                totalBagelFillingPrice += fillingPrice;
                resetAmount += fillingPrice;
            }

            // If the product is a filling, add the price to the total filling price and add the filling to the fillings list
            if (product instanceof Filling filling) {
                fillings.add(filling);
                totalBagelFillingPrice += filling.getPrice();
            }
        }

        // Comparator to compare Product prices
        Comparator<Product> priceComparator = Comparator.comparingInt(Product::getPrice);

        // Sort the coffees and bagels list by price using the comparator
        coffees.sort(priceComparator);
        bagels.sort(priceComparator);

        // Calculate the number of 12-bagel and 6-bagel discounts and update the amount
        // of bagels to only have the remaining bagels
        int numberOfBagels = bagels.size();
        int numberOfTwelveBagelDiscounts = numberOfBagels / 12;
        numberOfBagels -= numberOfTwelveBagelDiscounts * 12;
        int numberOfSixBagelDiscounts = numberOfBagels / 6;

        // Create maps to store the discounted products
        twelveBagelDiscounts = new HashMap<>();
        sixBagelDiscounts = new HashMap<>();
        coffeeBagelPairsDiscount = new HashMap<>();

        fillBagelDiscountMaps(numberOfTwelveBagelDiscounts, 12, bagels);
        fillBagelDiscountMaps(numberOfSixBagelDiscounts, 6, bagels);
        int bagelCoffeePairs = fillCoffeeBagelPairsDiscount(bagels, coffees);

        // Create maps to store the non-discounted products
        nonDiscountedProductsMap = new HashMap<>();

        fillNonDiscountedProducts(fillings);
        fillNonDiscountedProducts(bagels);
        fillNonDiscountedProducts(coffees);

        // Calculate the sum to add for remaining bagels and coffees (highest prices first)
        int sumToAdd = getSumToAdd(bagels) + getSumToAdd(coffees) + totalBagelFillingPrice;

        // Remove the fillings that belongs to the bagels that are not discounted from the nonDiscountedProductsMap
        // because they are displayed on the receipt as part of the bagel
        for (Product bagel : bagels) {
            if (bagel instanceof Bagel b && b.getFillings() != null) {
                for (Filling filling : b.getFillings()) {
                    if (nonDiscountedProductsMap.containsKey(filling) && nonDiscountedProductsMap.get(filling) == 1) {
                        nonDiscountedProductsMap.remove(filling);
                    } else if (nonDiscountedProductsMap.containsKey(filling) && nonDiscountedProductsMap.get(filling) > 1) {
                        nonDiscountedProductsMap.put(filling, nonDiscountedProductsMap.get(filling) - 1);
                    }
                }
            }
        }

        // If no discounts apply, set totalSum to resetAmount
        if (numberOfTwelveBagelDiscounts == 0 && numberOfSixBagelDiscounts == 0 && bagelCoffeePairs == 0) {
            return resetAmount;
        } else {
            // Calculate the total sum with all applicable discounts
            return bagelCoffeePairs * 125 + numberOfTwelveBagelDiscounts * 399 + numberOfSixBagelDiscounts * 249 + sumToAdd;
        }
    }

    private void fillNonDiscountedProducts(ArrayList<Product> products) {
        for (Product product : products) {
            nonDiscountedProductsMap.put(product, nonDiscountedProductsMap.getOrDefault(product, 0) + 1);
        }
    }

    private int getSumToAdd(ArrayList<Product> amountOfProducts) {
        int sumToAdd = 0;
        if (!amountOfProducts.isEmpty()) {
            for (Product amountOfProduct : amountOfProducts) {
                sumToAdd += amountOfProduct.getPrice();
            }
        }
        return sumToAdd;
    }

    private void fillBagelDiscountMaps(int numberOfDiscounts, int discountSize, ArrayList<Product> bagels) {
        for (int i = 0; i < numberOfDiscounts; i++) {
            int totalCost = 0;
            for (int j = 0; j < discountSize && !bagels.isEmpty(); j++) {
                Product product = bagels.removeFirst();
                totalCost += getProductPrice(product.getSKU());
            }

            if (discountSize == 12) {
                twelveBagelDiscounts.put(numberOfDiscounts, totalCost);
            } else {
                sixBagelDiscounts.put(numberOfDiscounts, totalCost);
            }
        }
    }

    private int fillCoffeeBagelPairsDiscount(ArrayList<Product> amountOfBagels, ArrayList<Product> amountOfCoffees) {
        // Calculate the number of bagel and coffee pairs for discounts
        int pairs = Math.min(amountOfBagels.size(), amountOfCoffees.size());
        for (int i = 0; i < pairs; i++) {
            int totalCost = 0;
            totalCost += amountOfCoffees.removeFirst().getPrice();
            totalCost += amountOfBagels.removeFirst().getPrice();
            coffeeBagelPairsDiscount.put(pairs, totalCost);
        }
        return pairs;
    }

}
