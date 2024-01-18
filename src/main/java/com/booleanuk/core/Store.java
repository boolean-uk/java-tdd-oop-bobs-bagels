package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

//TODO: check upper vs lowercase
public class Store {
    private HashMap<Integer, Basket> baskets;
    private HashMap<String, Double> prices;
    private HashMap<String, String> bagelCodes;
    private HashMap<String, String> coffeeCodes;
    private HashMap<String, String> fillingCodes;

    private int basketCapacity;

    public Store() {
        baskets = new HashMap<>();
        basketCapacity = 3;
        initilizePrices();
        initilizeCodes();
    }
    public int createBasket() {
        Basket basket = new Basket();
        baskets.put(basket.hashCode(), basket);
        return basket.hashCode();
    }

    public HashMap<Integer,Basket> getBaskets() {
        return new HashMap<>(baskets);
    }

    public String addBagelToBasket(String bagel, int basketId) {
        if(!bagelCodes.containsKey(bagel.toUpperCase())) {
            return "Bob's bagels doesn't have that bagel.";
        }
        Basket basket = baskets.get(basketId);

        if(basket.getNoOfBagels() >= basketCapacity) {
            return "You're basket is full!";
        }
        baskets.get(basketId).addBagel(bagel);
        return "Bagel added.";
    }

    public String addFilling(String filling, String bagel, int basketId) {
        if(!fillingCodes.containsKey(filling.toUpperCase())) {
            return "Bob's bagels doesn't have that filling.";
        }
        return baskets.get(basketId).addFilling(filling, bagel);
    }

    public boolean updateBasketCapacity(int newCapacity) {
        for(Basket basket: baskets.values()) {
            if(basket.getNoOfBagels()> newCapacity) {
                return false;
            }
        }
        basketCapacity = newCapacity;
        return true;
    }

    public double getCostOfBagel(String bagel) {
        if(!bagelCodes.containsKey(bagel.toUpperCase())) {
            return -1;
        }
        return prices.get(bagelCodes.get(bagel.toUpperCase()));
    }

    public double getCostOfFilling(String filling) {
        if(!fillingCodes.containsKey(filling.toUpperCase())) {
            return -1;
        }
        return prices.get(fillingCodes.get(filling.toUpperCase()));
    }

    public double getCostOfBasket(int basketId) {
        double cost = 0;
        ArrayList<Bagel> bagels = baskets.get(basketId).getBagels();
        for(Bagel bagel: bagels) {
            cost += getCostOfBagel(bagel.getName());
            for(String filling: bagel.getFillings()) {
                cost += getCostOfFilling(filling);
            }
        }

        return cost;
    }

    public boolean removeBagelFromBasket(String bagel, ArrayList<String> fillings, int basketId) {
        return baskets.get(basketId).removeBagel(bagel, fillings);
    }

    private void initilizePrices() {
        prices = new HashMap<>();
        prices.put("BGLO", 0.49);
        prices.put("BGLP", 0.39);
        prices.put("BGLE", 0.49);
        prices.put("BGLS", 0.49);
        prices.put("COFB", 0.99);
        prices.put("COFW", 1.19);
        prices.put("COFC", 1.29);
        prices.put("COFL", 1.29);
        prices.put("FILB", 0.12);
        prices.put("FILE", 0.12);
        prices.put("FILC", 0.12);
        prices.put("FILX", 0.12);
        prices.put("FILS", 0.12);
        prices.put("FILH", 0.12);

    }

    private void initilizeCodes() {
        bagelCodes = new HashMap<>();
        bagelCodes.put("ONION", "BGLO");
        bagelCodes.put("PLAIN", "BGLP");
        bagelCodes.put("EVERYTHING", "BGLE");
        bagelCodes.put("SESAME", "BGLS");

        coffeeCodes = new HashMap<>();
        coffeeCodes.put("BLACK","COFB");
        coffeeCodes.put("WHITE","COFW");
        coffeeCodes.put("CAPUCCINO","COFC");
        coffeeCodes.put("LATTE","COFL");

        fillingCodes = new HashMap<>();
        fillingCodes.put("BACON","FILB");
        fillingCodes.put("EGG","FILE");
        fillingCodes.put("CHEESE","FILC");
        fillingCodes.put("CREAM CHEESE","FILX");
        fillingCodes.put("SMOKED SALMON","FILS");
        fillingCodes.put("HAM","FILH");

    }

    public double getCostOfCoffee(String coffee) {
        if(!coffeeCodes.containsKey(coffee.toUpperCase())) {
            return  -1;
        }
        return prices.get(coffeeCodes.get(coffee.toUpperCase()));
    }

    //TODO: what do if nonexistent basketid
    public String addCoffeeToBasket(String coffee, int basketId) {
        if(!coffeeCodes.containsKey(coffee.toUpperCase())) {
            return  "Bob's bagels doesn't have that coffee.";
        }
        baskets.get(basketId).addCoffee(coffee);
        return "Coffee added.";
    }
}
