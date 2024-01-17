package com.booleanuk.core;

import java.util.HashMap;

public class Store {
    private HashMap<Integer, Basket> baskets;
    private HashMap<String, Double> prices;
    HashMap<String, String> bagelCodes;
    HashMap<String, String> coffeeCodes;
    HashMap<String, String> fillingCodes;

    private int basketCapacity;

    public Store() {
        baskets = new HashMap<>();
        initilizePrices();
        initilizeCodes();
        basketCapacity = 3;
    }
    public int createBasket() {
        Basket basket = new Basket();
        baskets.put(basket.hashCode(), basket);
        return basket.hashCode();
    }

    public HashMap<Integer,Basket> getBaskets() {
        return baskets;
    }

    public String addBagelToBasket(String bagel, int basketId) {
        if(!bagelCodes.containsKey(bagel.toUpperCase())) {
            return "Bob's bagels doesn't have that bagel.";
        }
        Basket basket = baskets.get(basketId);

        if(basket.getNoOfBagels() >= basketCapacity) {
            return "You're basket is full!";
        }
        baskets.get(basketId).addBagel(new Bagel(bagel));
        return "Bagel added.";
    }

    public String addFilling(String filling, String bagel, int basketId) {
        if(!fillingCodes.containsKey(filling.toUpperCase())) {
            return "Bob's bagels doesn't have that filling.";
        }
        return baskets.get(basketId).addFilling(filling, bagel);
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
}
