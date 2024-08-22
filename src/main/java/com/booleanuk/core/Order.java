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
    private static final int TWELVE_BAGEL_DISCOUNT_SIZE = 12;
    private static final int SIX_BAGEL_DISCOUNT_SIZE = 6;
    private static final int BAGEL_COFFEE_PAIR_DISCOUNT_PRICE = 125;
    private static final int TWELVE_BAGEL_DISCOUNT_PRICE = 399;
    private static final int SIX_BAGEL_DISCOUNT_PRICE = 249;

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
        int totalFillingPrice = 0;

        // Iterate through the basket to calculate total reset amount and separate bagels, fillings and coffees
        for (Product product : basket) {
            resetAmount += product.getPrice();

            if (product instanceof Coffee coffee) {
                coffees.add(coffee);
            }
            if (product instanceof Bagel bagel) {
                bagels.add(bagel);

                // Calculate the total price of all fillings in the bagel
                if (bagel.getFillings() != null) {
                    int fillingPrice = 0;
                    for (Filling filling : bagel.getFillings()) {
                        fillingPrice += filling.getPrice();
                        fillings.add(filling);
                    }
                    // Add the total filling price to the overall filling price
                    totalFillingPrice += fillingPrice;
                    resetAmount += fillingPrice;
                }
            }

            // If the product is a filling, add the price to the total filling price and add the filling to the fillings list
            if (product instanceof Filling filling) {
                fillings.add(filling);
                totalFillingPrice += filling.getPrice();
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
        int numberOfTwelveBagelDiscounts = numberOfBagels / TWELVE_BAGEL_DISCOUNT_SIZE;
        numberOfBagels -= numberOfTwelveBagelDiscounts * TWELVE_BAGEL_DISCOUNT_SIZE;
        int numberOfSixBagelDiscounts = numberOfBagels / SIX_BAGEL_DISCOUNT_SIZE;

        // Create maps to store the discounted products
        twelveBagelDiscounts = new HashMap<>();
        sixBagelDiscounts = new HashMap<>();
        coffeeBagelPairsDiscount = new HashMap<>();

        fillBagelDiscountMaps(numberOfTwelveBagelDiscounts, TWELVE_BAGEL_DISCOUNT_SIZE, bagels);
        fillBagelDiscountMaps(numberOfSixBagelDiscounts, SIX_BAGEL_DISCOUNT_SIZE, bagels);
        int bagelCoffeePairs = fillCoffeeBagelPairsDiscount(bagels, coffees);

        // Create maps to store the non-discounted products
        nonDiscountedProductsMap = new HashMap<>();

        fillNonDiscountedProducts(fillings);
        fillNonDiscountedProducts(bagels);
        fillNonDiscountedProducts(coffees);

        // Calculate the sum to add for remaining bagels and coffees (highest prices first)
        int sumToAdd = getSumToAdd(bagels) + getSumToAdd(coffees) + totalFillingPrice;

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
            return bagelCoffeePairs * BAGEL_COFFEE_PAIR_DISCOUNT_PRICE + numberOfTwelveBagelDiscounts * TWELVE_BAGEL_DISCOUNT_PRICE + numberOfSixBagelDiscounts * SIX_BAGEL_DISCOUNT_PRICE + sumToAdd;
        }
    }

    private void fillNonDiscountedProducts(ArrayList<Product> products) {
        for (Product product : products) {
            nonDiscountedProductsMap.put(product, nonDiscountedProductsMap.getOrDefault(product, 0) + 1);
        }
    }

    // Calculate the sum of the prices of all products in the given list, witch only contains non-discounted products
    private int getSumToAdd(ArrayList<Product> products) {
        int sumToAdd = 0;
        if (!products.isEmpty()) {
            for (Product amountOfProduct : products) {
                sumToAdd += amountOfProduct.getPrice();
            }
        }
        return sumToAdd;
    }

    private void fillBagelDiscountMaps(int numberOfDiscounts, int discountSize, ArrayList<Product> bagels) {
        // Loop through the number of discounts to be applied
        for (int i = 0; i < numberOfDiscounts; i++) {
            int totalCost = 0;
            // Calculate the total cost of the bagels for the given discount size (6 or 12).
            // This total cost will be used later to determine the savings from the discount.
            for (int j = 0; j < discountSize && !bagels.isEmpty(); j++) {
                Product product = bagels.removeFirst(); // Remove the first bagel from the list to separate the bagels that are in a discount from the bagels that is not
                totalCost += product.getPrice(); // Add the price of the bagel to the total cost
            }

            // Check if the discount size is 12 and add the total cost to the twelveBagelDiscounts map
            if (discountSize == TWELVE_BAGEL_DISCOUNT_SIZE) {
                twelveBagelDiscounts.put(numberOfDiscounts, totalCost);
            } else {
                // Otherwise, add the total cost to the sixBagelDiscounts map
                sixBagelDiscounts.put(numberOfDiscounts, totalCost);
            }
        }
    }
    private int fillCoffeeBagelPairsDiscount(ArrayList<Product> amountOfBagels, ArrayList<Product> amountOfCoffees) {
        // Calculate the number of bagel and coffee pairs for discounts
        int pairs = Math.min(amountOfBagels.size(), amountOfCoffees.size());
        for (int i = 0; i < pairs; i++) {
            // This total cost will be used later to determine the savings from the discount.
            int totalCost = 0;
            // Remove the first coffee from the list to separate the coffees that are in a discount
            // from the coffees that is not and add its price to the total cost
            totalCost += amountOfCoffees.removeFirst().getPrice();

            // Remove the first bagel from the list to separate the coffees that are in a discount
            // from the bagel that is not and add its price to the total cost
            totalCost += amountOfBagels.removeFirst().getPrice();

            // Add the total cost of the pair to the coffeeBagelPairsDiscount map
            coffeeBagelPairsDiscount.put(pairs, totalCost);
        }
        return pairs;
    }

}
