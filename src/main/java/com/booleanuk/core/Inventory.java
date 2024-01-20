package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private HashMap<String, Double> prices;
    private HashMap<Item, String> skuCodes;
    private final double TWELWE_BAGELS_DISCOUNT_PRICE = 3.99;
    private final double SIX_BAGELS_DISCOUNT_PRICE = 2.49;
    private final double COFFEE_AND_BAGEL_DISCOUNT = 1.25;

    public Inventory() {
        initializePrices();
        initializeCodes();
    }

    public double getCostOfItem(Item item) {
        if(!skuCodes.containsKey(item)) {
            return -1;
        }
        return prices.get(skuCodes.get(item));
    }

    public double getCostOfBasket(Basket basket) {
        double cost = 0;
        HashMap<String, Integer> noOfEachKind = new HashMap<>();
        ArrayList<Item> items = basket.getItems();

        //TODO: fix
        //If customer buys one coffee and one bagel
        if(items.size() == 2 && ((items.get(0) instanceof Coffee && items.get(1) instanceof Bagel) || (items.get(1) instanceof Coffee && items.get(0) instanceof Bagel))) {
            cost += COFFEE_AND_BAGEL_DISCOUNT;
            Bagel bagel = (Bagel) (items.get(0) instanceof Bagel? items.get(0) : items.get(1));
            for(Filling filling: bagel.getFillings()) {
                cost += getCostOfItem(filling);
            }
            return cost;
        }

        for(Item item: items) {
            if(item instanceof Bagel bagel) {
                if (noOfEachKind.containsKey(bagel.getName())) {
                    noOfEachKind.put(bagel.getName(), noOfEachKind.get(bagel.getName()) + 1);
                } else {
                    noOfEachKind.put(bagel.getName(), 1);
                }
                for (Filling filling : bagel.getFillings()) {
                    cost += getCostOfItem(filling);
                }
            } else {
                cost +=getCostOfItem(item);
            }
        }

        //See if discounts
        for(Map.Entry<String, Integer> e: noOfEachKind.entrySet()) {
            System.out.println(e.getKey()+" "+getCostForOfBundleOfBagels(new Bagel(e.getKey()), e.getValue()));

            cost += getCostForOfBundleOfBagels(new Bagel(e.getKey()), e.getValue());
        }

        return cost;
    }

    public double getCostForOfBundleOfBagels(Bagel bagel, int noOfBagels) {
        double cost = 0;
        while(noOfBagels-12 >= 0) {
            cost += TWELWE_BAGELS_DISCOUNT_PRICE;
            noOfBagels -= 12;
        }
        while(noOfBagels-6 >= 0) {
            cost += SIX_BAGELS_DISCOUNT_PRICE;
            noOfBagels -= 6;
        }
        cost += getCostOfItem(bagel)*noOfBagels;
        return cost;
    }

    private void initializePrices() {
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

    private void initializeCodes() {
        skuCodes = new HashMap<>();
        skuCodes.put(new Bagel("ONION"), "BGLO");
        skuCodes.put(new Bagel("PLAIN"), "BGLP");
        skuCodes.put(new Bagel("EVERYTHING"), "BGLE");
        skuCodes.put(new Bagel("SESAME"), "BGLS");

        skuCodes.put(new Coffee("BLACK"),"COFB");
        skuCodes.put(new Coffee("WHITE"),"COFW");
        skuCodes.put(new Coffee("CAPPUCCINO"),"COFC");
        skuCodes.put(new Coffee("LATTE"),"COFL");

        skuCodes.put(new Filling("BACON"),"FILB");
        skuCodes.put(new Filling("EGG"),"FILE");
        skuCodes.put(new Filling("CHEESE"),"FILC");
        skuCodes.put(new Filling("CREAM CHEESE"),"FILX");
        skuCodes.put(new Filling("SMOKED SALMON"),"FILS");
        skuCodes.put(new Filling("HAM"),"FILH");

    }

    public boolean hasItem(Item item) {

        return skuCodes.containsKey(item);
    }
}
