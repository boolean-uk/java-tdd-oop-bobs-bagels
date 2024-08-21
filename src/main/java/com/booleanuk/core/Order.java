package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;


public class Order {
    private HashMap<String, Integer> basket = new HashMap<>();
    private ArrayList<Product> pricesBagels = new ArrayList<>();
    private ArrayList<Product> pricesCoffees = new ArrayList<>();
    private final Store store;
    private int totalPrice;
    private Bagels lastAddedBagel;

    public int getPricesBagelsSize() {
        return pricesBagels.size();
    }

    public int getPricesCoffeesSize() {
        return pricesCoffees.size();
    }

    Order(Store store) {
        this.store = store;
    }

    private Bagels getLastAddedBagel() {
        return lastAddedBagel;
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
        //bagels
        if (product instanceof Bagels) {
            basket.put(product.getSKU(), basket.getOrDefault(product.getSKU(), 0) + 1);
            this.totalPrice += (int) (product.getPrice() * 100);
            pricesBagels.add(product);
            lastAddedBagel = (Bagels) product;


            //fillings
        } else if (product instanceof Fillings) {
            if (!isBagelInBasket()) {
                System.out.println("You have to choose a bagel first before you can add a filling");
                return false;
            }
            this.totalPrice += (int) (product.getPrice() * 100);
            Bagels lastBagel = getLastAddedBagel();
            lastBagel.addFilling((Fillings) product);

            //coffee
        } else {
            basket.put(product.getSKU(), basket.getOrDefault(product.getSKU(), 0) + 1);
            this.totalPrice += (int) (product.getPrice() * 100);
            pricesCoffees.add(product);

        }

        return true;
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
        pricesBagels.remove(product);
        basket.remove(product.getSKU());
    }

    public HashMap<String, Integer> getBasket() {
        return this.basket;
    }

    public double getTotalPrice() {
        int countBagels = pricesBagels.size();
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
                newAmountBig += (int) (pricesBagels.get(i).getPrice() * 100);
            }
            totalPriceClone -= newAmountBig;
            totalPriceClone += 399;
        }

        if (smallDiscountCount != 0) {
            for (int i = 0; i < smallDiscountCount * 6; i++) {
                newAmountSmall += (int) (pricesBagels.get(i + (bigDiscountCount * 12) ).getPrice() * 100);
            }
            totalPriceClone -= newAmountSmall;
            totalPriceClone += 249;
        }

        for(int i = 0; i < countBagels; i++) {
            if (i < pricesCoffees.size() ) {
                getBagelPrice = pricesBagels.get(i + bigDiscountCount * 12 + smallDiscountCount * 6).getPrice();
                getCoffeePrice = pricesCoffees.get(i).getPrice();
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
        int countBagels = pricesBagels.size();
        int bigDiscountCount = 0;
        int newAmountBig = 0;


        bigDiscountCount = countBagels / 12;

        if (bigDiscountCount != 0) {
            for (int i = 0; i < bigDiscountCount * 12; i++) {
                newAmountBig += (int) (pricesBagels.get(i).getPrice() * 100);
            }
            return (newAmountBig - 399) /100.0;

        }
        return 0;
    }

    public double smallDiscount() {
        int countBagels = pricesBagels.size();
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
                newAmountSmall += (int) (pricesBagels.get(i + (bigDiscountCount * 12) ).getPrice() * 100);
            }
            return (newAmountSmall - 249 )/ 100.0;

        }
        return 0;
    }

    public double coffeeAndBagelDiscount() {
        int countBagels = pricesBagels.size();
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
            if (i < pricesCoffees.size() ) {
                getBagelPrice = pricesBagels.get(i + bigDiscountCount * 12 + smallDiscountCount * 6).getPrice();
                getCoffeePrice = pricesCoffees.get(i).getPrice();
                newAmount += (int) ((getCoffeePrice + getBagelPrice) * 100);
            }
        }

        if(newAmount > 0 ) {
            return (newAmount - 125) / 100.0;
        }

        return 0;
    }

}

