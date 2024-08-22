package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Optional;


public class Order {
    private HashMap<String, Integer> basket = new HashMap<>();
    private ArrayList<Bagels> bagelsList = new ArrayList<>();
    private ArrayList<Coffee> coffeeList = new ArrayList<>();
    private final Store store;
    private int totalPrice;
    private Bagels lastAddedBagel;

    Order(Store store) {
        this.store = store;
    }

    public int getPricesBagelsSize() {
        return bagelsList.size();
    }

    public int getPricesCoffeesSize() {
        return coffeeList.size();
    }


    public Bagels getLastAddedBagel() {
        return lastAddedBagel;
    }

    public void setLastAddedBagel(Bagels lastAddedBagel) {
        this.lastAddedBagel = lastAddedBagel;
    }

    public ArrayList<Bagels> getBagelsList() {
        return bagelsList;
    }

    public ArrayList<Coffee> getCoffeeList() {
        return coffeeList;
    }

    public void addToTotalPrice(double price) {
        this.totalPrice += (int) (price * 100);
    }

    public boolean addProduct(Product product) {
        if (sizeOfBasket() == store.getCapacity()) {
            System.out.println("You reached max capacity");
            return false;
        }
        if (!store.findProductInInventory(product.getSKU())) {
            System.out.println("Didn't find the product you're trying to add in our inventory!");
            return false;
        }
        if (product instanceof Helper) {
            return ((Helper) product).addProduct(this);
        }

        return false;
    }

    public boolean containsKeyBasket(String SKU) {
        return basket.containsKey(SKU);
    }


    public boolean isBagelInBasket() {
        return (basket.keySet().stream().anyMatch(key -> key.startsWith("BGL")));

    }

    public double getPriceProduct(Product product) {
        return product.getPrice();
    }


    public void removeProduct(Product product) {
        if (!basket.containsKey(product.getSKU())) {
            throw new NoSuchElementException("Product not found in the basket");
        }
        coffeeList.remove(product);
        bagelsList.remove(product);
        basket.remove(product.getSKU());
    }

    public HashMap<String, Integer> getBasket() {
        return this.basket;
    }

    public double getTotalPrice() {
        int countBagels = bagelsList.size();
        int smallDiscountCount = 0;
        int bigDiscountCount = 0;
        int newAmountBig = 0;
        int newAmountSmall = 0;
        double getCoffeePrice = 0;
        double getBagelPrice = 0;
        int totalPriceClone = totalPrice;

        bigDiscountCount = countBagels / 12;
        if (bigDiscountCount > 0) {
            countBagels -= 12 * bigDiscountCount;
        }
        smallDiscountCount = countBagels / 6;
        if(smallDiscountCount != 0 || bigDiscountCount != 0) {
            countBagels %= smallDiscountCount + bigDiscountCount;
        }


        if (bigDiscountCount != 0) {
            for (int i = 0; i < bigDiscountCount * 12; i++) {
                newAmountBig += (int) (bagelsList.get(i).getPrice() * 100);
            }
            totalPriceClone -= newAmountBig;
            totalPriceClone += 399;
        }

        if (smallDiscountCount != 0) {
            for (int i = 0; i < smallDiscountCount * 6; i++) {
                newAmountSmall += (int) (bagelsList.get(i + (bigDiscountCount * 12) ).getPrice() * 100);
            }
            totalPriceClone -= newAmountSmall;
            totalPriceClone += 249;
        }

        for(int i = 0; i < countBagels; i++) {
            if (i < coffeeList.size() ) {
                getBagelPrice = bagelsList.get(i + bigDiscountCount * 12 + smallDiscountCount * 6).getPrice();
                getCoffeePrice = coffeeList.get(i).getPrice();
                totalPriceClone -= (int) ((getCoffeePrice + getBagelPrice) * 100);
                totalPriceClone += 125;
            }
        }
        return totalPriceClone / 100.0;
    }

    public int sizeOfBasket(){
        int result = 0;
        for(Integer i : basket.values()){
            result += i;
        }
        return result;
    }

    public double  bigDiscount() {
        int countBagels = bagelsList.size();
        int bigDiscountCount = 0;
        int newAmountBig = 0;


        bigDiscountCount = countBagels / 12;

        if (bigDiscountCount != 0) {
            for (int i = 0; i < bigDiscountCount * 12; i++) {
                newAmountBig += (int) (bagelsList.get(i).getPrice() * 100);
            }
            return (newAmountBig - 399) /100.0;

        }
        return 0;
    }

    public double smallDiscount() {
        int countBagels = bagelsList.size();
        int smallDiscountCount = 0;
        int bigDiscountCount = 0;
        int newAmountSmall = 0;


        bigDiscountCount = countBagels / 12;
        if (bigDiscountCount > 0) {
            countBagels -= 12 * bigDiscountCount;
        }
        smallDiscountCount = countBagels / 6;


        if (smallDiscountCount != 0) {
            for (int i = 0; i < smallDiscountCount * 6; i++) {
                newAmountSmall += (int) (bagelsList.get(i + (bigDiscountCount * 12) ).getPrice() * 100);
            }
            return (newAmountSmall - 249 )/ 100.0;

        }
        return 0;
    }

    public double coffeeAndBagelDiscount() {
        int countBagels = bagelsList.size();
        int smallDiscountCount = 0;
        int bigDiscountCount = 0;
        int newAmount = 0;
        double getCoffeePrice = 0;
        double getBagelPrice = 0;

        bigDiscountCount = countBagels / 12;
        if (bigDiscountCount > 0) {
            countBagels -= 12 * bigDiscountCount;
        }
        smallDiscountCount = countBagels / 6;

        if(smallDiscountCount != 0 || bigDiscountCount != 0) {
            countBagels %= 6;

        }

        for(int i = 0; i < countBagels; i++) {
            if (i < coffeeList.size() ) {
                getBagelPrice = bagelsList.get(i + bigDiscountCount * 12 + smallDiscountCount * 6).getPrice();
                getCoffeePrice = coffeeList.get(i).getPrice();
                newAmount += (int) ((getCoffeePrice + getBagelPrice) * 100);
            }
        }

        if(newAmount > 0 ) {
            return (newAmount - 125) / 100.0;
        }

        return 0;
    }

}

