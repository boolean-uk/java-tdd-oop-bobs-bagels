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
        applyBagelsDiscount();
        return totalSum;
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

    private void applyBagelsDiscount() {
        int amountOfBagels = 0;

        int amountOfCoffee = 0;

        int resetAmount = 0;
        ArrayList<Integer> bagelsPrice = new ArrayList();
        ArrayList<Integer> coffeesPrice = new ArrayList();

        Inventory inventory = new Inventory();
        for (Map.Entry<String, Integer> entry : basket.entrySet()) {
            resetAmount += entry.getValue() * inventory.getProduct(entry.getKey()).getPrice();

            if (entry.getKey().startsWith("COF")) {
                amountOfCoffee += entry.getValue();
                int coffeePrice = inventory.getProduct(entry.getKey()).getPrice();
                for (int i = 0; i < entry.getValue(); i++) {
                    coffeesPrice.add(coffeePrice);
                }
            }
            if (entry.getKey().startsWith("BGL")) {
                amountOfBagels += entry.getValue();
                int bagelPrice = inventory.getProduct(entry.getKey()).getPrice();
                for (int i = 0; i < entry.getValue(); i++) {
                    bagelsPrice.add(bagelPrice);
                }
            }
        }
        System.out.println("Amount of bagels: " + amountOfBagels);
        System.out.println("Amount of coffee: " + amountOfCoffee);

        int twelveBagelDiscounts = amountOfBagels / 12;
        amountOfBagels %= 12;
        int sixBagelDiscounts = amountOfBagels / 6;
        amountOfBagels %= 6;

        int bagelCoffeePairs = Math.min(amountOfBagels, amountOfCoffee);
        if (twelveBagelDiscounts == 0 && sixBagelDiscounts == 0 && bagelCoffeePairs == 0) {
            totalSum = resetAmount;
            System.out.println("No discount applied" + resetAmount + " " + totalSum);
        } else if (twelveBagelDiscounts == 0 && sixBagelDiscounts == 0 && bagelCoffeePairs > 0) {
            amountOfBagels -= bagelCoffeePairs;
            amountOfCoffee -= bagelCoffeePairs;
            int sumToAdd = 0;
            if (amountOfBagels >= 0) {
                // Sort the list in descending order
                bagelsPrice.sort(Comparator.reverseOrder());
                System.out.println("Bagels price: " + bagelsPrice);
                for (int i = 0; i < amountOfBagels; i++) {
                    sumToAdd += bagelsPrice.get(i);
                }
            }
            if (amountOfCoffee >= 0) {
                // Sort the list in descending order
                coffeesPrice.sort(Comparator.reverseOrder());
                System.out.println("Coffees price: " + coffeesPrice);
                for (int i = 0; i < amountOfCoffee; i++) {
                    sumToAdd += coffeesPrice.get(i);
                }
            }

            System.out.println("Bagel coffee pairs: " + bagelCoffeePairs);
            System.out.println("Sum to add: " + sumToAdd);
            totalSum = bagelCoffeePairs * 125 + sumToAdd;

        } else {
            int sumToAdd = 0;
            if (amountOfBagels >= 0) {
                // Sort the list in descending order
                bagelsPrice.sort(Comparator.reverseOrder());
                System.out.println("Bagels price: " + bagelsPrice);
                for (int i = 0; i < amountOfBagels; i++) {
                    sumToAdd += bagelsPrice.get(i);
                }
            }
            System.out.println(amountOfBagels + " bagels left");
            System.out.println("Sum to add: " + sumToAdd);
            int newSum = twelveBagelDiscounts * 399 + sixBagelDiscounts * 249 + sumToAdd;
            totalSum = newSum;
        }
    }


    private void applyCoffeeDiscount() {
        int coffeeCount = 0;
        int totalPrice = 0;
        Inventory inventory = new Inventory();

        for (Map.Entry<String, Integer> entry : basket.entrySet()) {
            if (entry.getKey().startsWith("COF")) {
                coffeeCount += entry.getValue();
                totalPrice += entry.getValue() * inventory.getProduct(entry.getKey()).getPrice();
            }
        }
        if (coffeeCount != 0) {

        }
    }

}
