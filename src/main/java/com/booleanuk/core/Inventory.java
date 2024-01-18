package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private HashMap<String, Double> prices;
    private HashMap<String, String> bagelCodes;
    private HashMap<String, String> coffeeCodes;
    private HashMap<String, String> fillingCodes;
    private final double TWELWE_BAGELS_DISCOUNT_PRICE = 3.99;
    private final double SIX_BAGELS_DISCOUNT_PRICE = 2.49;
    private final double COFFEE_AND_BAGEL_DISCOUNT = 1.25;

    public Inventory() {
        initializePrices();
        initializeCodes();
    }

    public boolean hasBagel(String bagel) {
        return bagelCodes.containsKey(bagel.toUpperCase());
    }

    public boolean hasFilling(String filling) {
        return fillingCodes.containsKey(filling.toUpperCase());
    }

    public boolean hasCoffee(String coffee) {
        return coffeeCodes.containsKey(coffee.toUpperCase());
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

    public double getCostOfBasket(Basket basket) {
        double cost = 0;
        HashMap<String, Integer> noOfEachKind = new HashMap<>();
        ArrayList<Bagel> bagels = basket.getBagels();
        ArrayList<String> coffees = basket.getCoffees();

        //If customer buys one coffee and one bagel
        if(bagels.size() == 1 && coffees.size() == 1) {
            cost += COFFEE_AND_BAGEL_DISCOUNT;
            for(String filling: bagels.get(0).getFillings()) {
                cost += getCostOfFilling(filling);
            }
            return cost;
        }

        for(Bagel bagel: bagels) {
            if(noOfEachKind.containsKey(bagel.getName())) {
                noOfEachKind.put(bagel.getName(), noOfEachKind.get(bagel.getName())+1);
            } else {
                noOfEachKind.put(bagel.getName(), 1);
            }
            for(String filling: bagel.getFillings()) {
                cost += getCostOfFilling(filling);
            }
        }

        //See if discounts
        for(Map.Entry<String, Integer> e: noOfEachKind.entrySet()) {
            int noOfBagelsLeft = e.getValue();
            String name = e.getKey();
            while(noOfBagelsLeft-12 >= 0) {
                cost += TWELWE_BAGELS_DISCOUNT_PRICE;
                noOfBagelsLeft -= 12;
            }
            while(noOfBagelsLeft-6 >= 0) {
                cost += SIX_BAGELS_DISCOUNT_PRICE;
                noOfBagelsLeft -= 6;
            }
            cost += getCostOfBagel(name)*noOfBagelsLeft;
        }

        for(String coffee: coffees) {
            cost += getCostOfCoffee(coffee);
        }

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


}
