package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private HashMap<String, Double> prices;
    private HashMap<Item, String> skuCodes;
//    private final double TWELWE_BAGELS_DISCOUNT_PRICE = 3.99;
//    private final double SIX_BAGELS_DISCOUNT_PRICE = 2.49;
    private final double COFFEE_AND_BAGEL_DISCOUNT = 1.25;
    private HashMap<String, ArrayList<Discount>> bundleDiscounts;

    public Inventory() {
        initializePrices();
        initializeCodes();
        initializeDiscounts();

    }

    public double getCostOfItem(Item item) {
        if(!skuCodes.containsKey(item)) {
            return -1;
        }
        return prices.get(skuCodes.get(item));
    }

    public double getCostOfBasket(Basket basket) {
        double cost = 0;
        HashMap<String, Integer> bundlesItems = new HashMap<>();
        ArrayList<Item> items = basket.getItems();

        //TODO: fix
        //If customer buys one coffee and one bagel
        if(items.size() == 2 && ((items.get(0) instanceof Coffee && items.get(1) instanceof Bagel) || (items.get(1) instanceof Coffee && items.get(0) instanceof Bagel))) {
            cost += COFFEE_AND_BAGEL_DISCOUNT;
            Bagel bagel = (Bagel) (items.get(0) instanceof Bagel? items.get(0) : items.get(1));
            for(Item item: bagel.getContainedItems()) {
                cost += getCostOfItem(item);
            }

            return cost;
        }

        String sku;
        for(Item item: items) {

            //Check if the item has discounts
            sku = skuCodes.get(item);
            if(bundleDiscounts.containsKey(sku)) {
                if (bundlesItems.containsKey(sku)) {
                    bundlesItems.put(sku, bundlesItems.get(sku) + 1);
                } else {
                    bundlesItems.put(sku, 1);
                }
            }else {
                cost +=getCostOfItem(item);
            }
            //check if the item contains other items and add those to the cost
            if(item.containsOtherItems()) {
                for (Item containedItem : item.getContainedItems()) {
                    cost += getCostOfItem(containedItem);
                }
            }
        }

        //See if discounts
        for(Map.Entry<String, Integer> e: bundlesItems.entrySet()) {
            cost += getCostForOfBundle(e.getKey(), e.getValue());
        }

        return cost;
    }

    public double getCostForOfBundle(Item item, int quantity) {
        return getCostForOfBundle(skuCodes.get(item), quantity);
    }

    //TODO: generalize?
    public double getCostForOfBundle(String sku, int quantity) {
        double cost = 0;

        for(Discount discount: bundleDiscounts.get(sku)) {
            while(quantity-discount.getQuantity() >= 0) {
                cost += discount.getCost();
                quantity -= discount.getQuantity();
            }
        }

        cost += prices.get(sku)*quantity;
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

    private void initializeDiscounts() {
        bundleDiscounts = new HashMap<>();

        //TODO: this is dependent on inserting highest quantity first, how can we assure this?
        //sort with implemented compare method?
        ArrayList<Discount> discountData = new ArrayList<>(Arrays.asList(new Discount(3.99, 12), new Discount(2.49, 6)));

        bundleDiscounts.put("BGLO", discountData);
        bundleDiscounts.put("BGLP", discountData);
        bundleDiscounts.put("BGLE", discountData);
        bundleDiscounts.put("BGLS", discountData);

    }

    public boolean hasDiscount(Item item) {
        return bundleDiscounts.containsKey(skuCodes.get(item));
    }

    public boolean hasItem(Item item) {

        return skuCodes.containsKey(item);
    }

}
