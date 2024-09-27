package com.booleanuk.core;

import java.util.HashMap;

public class Basket {
    private HashMap<Item, Integer> basketContent;
    private int basketCapacity;
    private BobsBagelsShop shop;

    public Basket(BobsBagelsShop shop, int basketCapacity) {
        this.basketContent = new HashMap<>();
        this.basketCapacity = basketCapacity;
        this.shop = shop;
    }

    public HashMap<Item, Integer> getBasketContent() {
        return this.basketContent;
    }

    public int getBasketCapacity() {
        return this.basketCapacity;
    }

    public String add(Item item) {
        boolean skuNotInInventory = this.shop.getInventory().keySet().stream().noneMatch(i -> i.getSku().equals(item.getSku()));
        if (this.getBasketContent().size() >= this.getBasketCapacity()) {
            return "Basket is full.";
        }
        else if (skuNotInInventory) {
            return "Chosen item not in stock.";
        }
        else {
            if(item.getClass() == Bagel.class) {
                if (!((Bagel) item).getFillings().isEmpty()) {
                    for (Filling filling : ((Bagel) item).getFillings()) {
                        this.add(filling);
                    }
                }
            }
            if (this.basketContent.containsKey(item)){
                this.basketContent.replace(item, this.basketContent.get(item) + 1);
            }
            else {
                this.basketContent.put(item, 1);
            }
            this.shop.removeFromInventory(item);
            return "Item " + item.getSku() + " added to basket.";
        }
    }

    public String remove(Item item) {
        if (this.basketContent.containsKey(item)) {
            if(item.getClass() == Bagel.class) {
                if (!((Bagel) item).getFillings().isEmpty()) {
                    for (Filling filling : ((Bagel) item).getFillings()) {
                        this.remove(filling);
                    }
                }
            }
            if (this.basketContent.get(item) == 1) {
                this.basketContent.remove(item);
            }
            else {
                this.basketContent.replace(item, this.basketContent.get(item) - 1);
            }
            this.shop.addToInventory(item);
            return "Item " + item.getSku() + " removed from basket.";
        }
        else {
            return "Item " + item.getSku() +" not in basket.";
        }
    }

    public double totalCost() {
        if (this.basketContent.isEmpty()){
            return 0.0;
        }
        else {
            double totalPrice = 0.0;
            for (Item item : this.basketContent.keySet()) {
                totalPrice += (item.getPrice() * this.basketContent.get(item));
            }
            return ((int) Math.round(totalPrice*100))/100.0;
        }
    }

    public int checkSize() {
        int size = 0;
        for (Item item : this.basketContent.keySet()) {
            size += this.basketContent.get(item);
        }
        return size;
    }

    public String changeCapacity(int newCapacity) {
        if (newCapacity < 0) {
            return "New capacity must be non negative.";
        }
        else if (newCapacity >= this.checkSize()) {
            this.basketCapacity = newCapacity;
            return "New basket capacity is " + newCapacity +".";
        }
        else {
            return "New capacity must be larger than number of items currently in basket.";
        }
    }

    public HashMap<Item, int[]> discountPerItem() {
        HashMap<Item, int[]> mapPriceAndSavings = new HashMap<>();
        if (this.basketContent.isEmpty()){
            return mapPriceAndSavings;
        }
        for (Item item: this.basketContent.keySet()) {
            int[] priceAndSavings = new int[2];
            int amount = this.basketContent.get(item);
            double fullPrice = item.getPrice() * amount;

            // Assumption only one discount available per item variant with specific fillings.
            if (item.getName().equals("Bagel") && amount >= 12) {
                priceAndSavings[0] = (int) Math.round((3.99 + (amount - 12) * item.getPrice())*100);
            }
            else if (item.getName().equals("Bagel") && amount >= 6) {
                priceAndSavings[0] = (int) Math.round((2.29 + (amount - 6) * item.getPrice())*100);
            }
            // Bagel & Black Coffee discount not working correctly yet.
            // If more "single" bagels than black coffees, every "single" bagel gets discount.
            else if (item.getName().equals("Bagel") && this.basketContent.keySet().stream().anyMatch(i -> i.getVariant().equals("Black"))) {
                int coffeeAmount = this.basketContent.keySet().stream().filter(i -> i.getVariant().equals("Black")).mapToInt(i -> this.basketContent.get(i)).sum();
                if (amount <= coffeeAmount) {
                    priceAndSavings[0] = (int) Math.round((1.25*(1.0/4) * amount) * 100);
                }
                else {
                    priceAndSavings[0] = (int) Math.round(((1.25*(1.0/4) * coffeeAmount) + ((amount-coffeeAmount) * item.getPrice())) * 100);
                }
            }
            else if (item.getVariant().equals("Black") && this.basketContent.keySet().stream().anyMatch(i -> i.getName().equals("Bagel"))) {
                int bagelAmount = this.basketContent.keySet().stream().filter(i -> i.getName().equals("Bagel")).mapToInt(i -> this.basketContent.get(i)).sum();
                if (amount <= bagelAmount) {
                    priceAndSavings[0] = (int) Math.round((1.25*(3.0/4)*amount)*100);
                }
                else {
                    priceAndSavings[0] = (int) Math.round((1.25*(3.0/4)*bagelAmount + (amount-bagelAmount) * item.getPrice())*100);
                }
            }
            else {
                priceAndSavings[0] = (int) Math.round((amount * item.getPrice())*100);
            }
            double savings = fullPrice - priceAndSavings[0]/100.0;
            priceAndSavings[1] = (int) Math.round(savings*100);
            mapPriceAndSavings.put(item, priceAndSavings);
        }
        return mapPriceAndSavings;
    }

    public double totalCostWithDiscount(HashMap<Item, int[]> mapPriceAndSavings) {
        double price = 0.0;
        for (int[] priceAndSaving: mapPriceAndSavings.values()) {
            price += (priceAndSaving[0])/100.0;
        }
        return ((int) Math.round(price*100))/100.0;
    }
}
