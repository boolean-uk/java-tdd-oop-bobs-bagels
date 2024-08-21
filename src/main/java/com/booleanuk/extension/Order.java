package com.booleanuk.extension;

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
            totalPrice -= newAmountBig;
            totalPrice += 399;
        }

        if (smallDiscountCount != 0) {
            for (int i = 0; i < smallDiscountCount * 6; i++) {
                newAmountSmall += (int) (pricesBagels.get(i + (bigDiscountCount * 12) ).getPrice() * 100);
            }
            totalPrice -= newAmountSmall;
            totalPrice += 249;
        }

        for(int i = 0; i < countBagels; i++) {
            if (i < pricesCoffees.size()) {
                getBagelPrice = pricesBagels.get(i + bigDiscountCount * 12 + smallDiscountCount * 6).getPrice();
                getCoffeePrice = pricesCoffees.get(i).getPrice();
                totalPrice -= (int) ((getCoffeePrice + getBagelPrice) * 100);
                totalPrice += 125;
            }
        }
        return totalPrice / 100.0;
    }

    public String getCoffeeDiscounts() {
        int counter = pricesBagels.size();
        int bigDiscountCount = 0;

        bigDiscountCount = counter / 12;
        if (bigDiscountCount > 0) {
            counter -= 12 * bigDiscountCount;
        }

        int smallest = Math.min(counter, pricesCoffees.size());

        if(smallest != 0) {
            return "Coffee & Bagel" + "       " +smallest + "           $" + 1.25;
        }

        return "";
    }

    public String getBagelTwelveDiscount() {
        int counter = pricesBagels.size();
        int bigDiscountCount = 0;

        bigDiscountCount = counter / 12;

        if(bigDiscountCount != 0) {
            return "Bagel x12" + "            " + bigDiscountCount + "           $" + 3.99;
        }

        return "";
    }

    public String getBagelSixDiscount() {
        int counter = pricesBagels.size();
        int bigDiscountCount = 0;
        int smallDiscountCount = 0;

        bigDiscountCount = counter / 12;
        if (bigDiscountCount > 0) {
            counter -= 12 * bigDiscountCount;
        }
        smallDiscountCount = counter / 6;

        if(smallDiscountCount != 0) {
            return "Bagel x6" + "             " + smallDiscountCount + "           $" + 3.99;
        }

        return "";
    }

}

