package com.booleanuk.core;

import java.util.*;


public class Order {
    private HashMap<String, Integer> basket = new HashMap<>();
    private ArrayList<Product> prices = new ArrayList<>();
    private final Store store;
    private int totalPrice;
    private Bagels lastAddedBagel;

    Order(Store store) {
        this.store = store;
    }

    private Bagels getLastAddedBagel() {
        return lastAddedBagel;
    }

    public boolean addProduct(Product product) {
        if (store.getCapacity() == basket.size()) {
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
            prices.add(product);
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
            prices.add(product);

        }

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
        prices.remove(product);
        basket.remove(product.getSKU());
    }


    public void printBasket() {
        for (Map.Entry<String, Integer> entry : basket.entrySet()) {
            String sku = entry.getKey();
            Integer quantity = entry.getValue();
            System.out.println("Product SKU: " + sku + ", Quantity: " + quantity);
        }
    }

    public double getTotalPrice() {
        int count = 0;
        int smallDiscountCount = 0;
        int bigDiscountCount = 0;
        int newAmountBig = 0;
        int newAmountSmall = 0;
        boolean isCoffee = false;
        double getCoffeePrice = 0;
        double getBagelPrice = 0;

        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i).getSKU().contains("BGL")) {
                count++;

            }
            if (prices.get(i).getSKU().contains("COF")) {
                getCoffeePrice = prices.get(i).getPrice();
                isCoffee = true;
                prices.remove(i);
            }
        }
        bigDiscountCount = count / 12;
        if (bigDiscountCount > 0) {
            count -= 12 * bigDiscountCount;
        }
        smallDiscountCount = count / 6;
        if(smallDiscountCount != 0 || bigDiscountCount != 0) {
            count %= smallDiscountCount + bigDiscountCount;
        }

        if (bigDiscountCount != 0) {
            for (int i = 0; i < bigDiscountCount * 12; i++) {
                newAmountBig += (int) (prices.get(i).getPrice() * 100);
            }
            totalPrice -= newAmountBig;
            totalPrice += 399;
        }

        if (smallDiscountCount != 0) {
            for (int i = 0; i < smallDiscountCount * 6; i++) {
                newAmountSmall += (int) (prices.get(i + bigDiscountCount * 12 ).getPrice() * 100);
            }
            totalPrice -= newAmountSmall;
            totalPrice += 249;

        }
        if (isCoffee && count != 0) {
            getBagelPrice = prices.getLast().getPrice();
            totalPrice -= (int) ((getCoffeePrice + getBagelPrice) * 100);
            totalPrice += 125;
        }
        return totalPrice / 100.0;

    }
}

