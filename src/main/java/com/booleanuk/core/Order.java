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
            prices.add(product);
            basket.put(product.getSKU(), basket.getOrDefault(product.getSKU(), 0) + 1);
            this.totalPrice += (int) (product.getPrice() * 100);

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
            prices.add(product);
            basket.put(product.getSKU(), basket.getOrDefault(product.getSKU(), 0) + 1);
            this.totalPrice += (int) (product.getPrice() * 100);
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

    public double getTotalPrice() {
        int count = 0;
        int pointer = 0;
        int smallDiscountCount = 0;
        int bigDiscountCount = 0;
        int newAmountBig = 0;
        int newAmountSmall = 0;
        boolean bigDiscount = false;
        boolean smallDiscout = false;
        boolean bagelFound = false;
        System.out.println(prices.get(1).getSKU());

        while (pointer < prices.size()) {
            count++;
            if (prices.get(pointer).getSKU().contains("BGL")) {
                bagelFound = true;
                if (count % 12 == 0) {
                    if (count == 12) {
                        smallDiscountCount--;
                        bigDiscount = true;
                        bigDiscountCount++;
                        count -= count;
                    }
                }
                if (count % 6 == 0) {
                    if (count == 6) {
                        smallDiscountCount++;
                        smallDiscout = true;

                    }
                }

            }
            if(prices.get(pointer).getSKU().contains("COF") && bagelFound && count % 6 != 0) { {
            }

            }

            pointer++;
        }
        System.out.println(smallDiscountCount + " S");
        System.out.println(bigDiscountCount + " B");

        if (bigDiscount) {
            for (int i = 0; i < 12 * bigDiscountCount; i++) {
                newAmountBig += (int) (prices.get(i).getPrice() * 100);
            }
            System.out.println(newAmountBig + " Big amount"); // 588
            System.out.println("Total before any discount +" + totalPrice);
            totalPrice -= newAmountBig;
            System.out.println("Total after big discount +" + totalPrice);
            totalPrice += 399 * bigDiscountCount;
            System.out.println("Total + big discount " + totalPrice);


        }
        if (smallDiscout) {
            for (int i = 0; i < 6 * smallDiscountCount; i++) {
                newAmountSmall += (int) (prices.get(i + bigDiscountCount * 12).getPrice() * 100);
            }
            System.out.println(newAmountSmall + " Small amount"); // 294
            totalPrice -= newAmountSmall;
            System.out.println("Total after taking small discount +" + totalPrice);
            totalPrice += 249 * smallDiscountCount;
            System.out.println("Total + small discount " + totalPrice);
        }

        return totalPrice / 100.0;

    }

    public void printBasket() {
        for (Map.Entry<String, Integer> entry : basket.entrySet()) {
            String sku = entry.getKey();
            Integer quantity = entry.getValue();
            System.out.println("Product SKU: " + sku + ", Quantity: " + quantity);
        }
    }

    public int isDiscount() {
        int count = 0;
        int smallDiscount = 0;
        int bigDiscount = 0;

        while (count < prices.size()) {
            count++; // 18
            if (count % 12 == 0) {
                bigDiscount++;
            } else if (count % 6 == 0) {
                smallDiscount++;
            }

        }
        System.out.println(bigDiscount + " Big " + smallDiscount + " Small");

        return -1;

    }

}

