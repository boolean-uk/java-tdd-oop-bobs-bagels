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
        applyDiscount();
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
            applyDiscount();
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

    private void applyDiscount() {
        int count = 0;
        int totalPrice = 0;
        ArrayList<Integer> bagelsPrice = new ArrayList();
        Inventory inventory = new Inventory();
        for (Map.Entry<String, Integer> entry : basket.entrySet()) {
            if (entry.getKey().startsWith("BGL")) {
                count += entry.getValue();
                int bagelPrice = inventory.getProduct(entry.getKey()).getPrice();
                totalPrice += entry.getValue() * bagelPrice;
                for (int i = 0; i < entry.getValue(); i++) {
                    bagelsPrice.add(bagelPrice);
                }
            }
        }
        System.out.println("Total price: " + totalPrice);
        System.out.println("Count: " + count);
        int x = 0;
        int y = 0;
        if (count >= 12)
            do {
                x++;
                count -= 12;
            } while (count > 12);
        if (count >= 6) {
            y ++;
        }


        int sumToAdd = 0;
        if (count >= 0) {
            // Sort the list in descending order
            Collections.sort(bagelsPrice, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            System.out.println("Bagels price: " + bagelsPrice);
            for (int i = 0; i < count; i++) {
                sumToAdd += bagelsPrice.get(i);
            }
        }
        int newSum = x * 399 + y * 249 +  sumToAdd;
        totalSum = newSum;
    }
}
