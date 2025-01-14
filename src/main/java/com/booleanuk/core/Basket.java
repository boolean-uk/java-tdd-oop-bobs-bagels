package com.booleanuk.core;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class Basket {

    private int capasity = 20;
    private double totalCost;

    private ArrayList<Item> basketList = new ArrayList<>();

    private HashMap<String, Item> stockList = new HashMap<>() {{
        Item bagelOnion = new Bagel("BGLO", 0.49, "Bagel", "Onion");
        put("BGLO", bagelOnion);
        Item bagelPlain = new Bagel("BGLP", 0.39, "Bagel", "Plain");
        put("BGLP", bagelPlain);
        Item bagelEvery = new Bagel("BGLE", 0.49, "Bagel", "Everything");
        put("BGLE", bagelEvery);
        Item bagelSesame = new Bagel("BGLS", 0.49, "Bagel", "Sesame");
        put("BGLS", bagelSesame);
        Item coffeeBlack = new Coffee("COFB", 0.99, "Coffee", "Black");
        put("COFB", coffeeBlack);
        Item coffeeWhite = new Coffee("COFW", 1.19, "Coffee", "White");
        put("COFW", coffeeWhite);
        Item coffeeCapuccino = new Coffee("COFC", 1.29, "Coffee", "Capuccino");
        put("COFC", coffeeCapuccino);
        Item coffeeLatte = new Coffee("COFL", 1.29, "Coffee", "Latte");
        put("COFL", coffeeLatte);
        Item fillBacon = new Filling("FILB", 0.12, "Filling", "Bacon");
        put("FILB", fillBacon);
        Item fillEgg = new Filling("FILE", 0.12, "Filling", "Egg");
        put("FILE", fillEgg);
        Item fillCheese = new Filling("FILC", 0.12, "Filling", "Egg");
        put("FILC", fillCheese);
        Item fillCream = new Filling("FILX", 0.12, "Filling", "Cream Cheese");
        put("FILX", fillCream);
        Item fillSal = new Filling("FILS", 0.12, "Filling", "Smoked Salmon");
        put("FILS", fillSal);
        Item fillHam = new Filling("FILH", 0.12, "Filling", "Ham");
        put("FILH", fillHam);
    }};

    public Basket() {
    }

    public int getCapasity() {
        return capasity;
    }

    public ArrayList<Item> getBasketList() {
        return basketList;
    }

    public HashMap<String, Item> getStockList() {
        return stockList;
    }

    public boolean addToBasket(String id) {
        if (basketList.size() != capasity) {
            if (stockList.containsKey(id)) {
                if(id.substring(0,2).equals("FI")) {
                    if(basketList.size() != 0) {
                        for (int i = 0; i <= basketList.size(); i++) {
                            if (basketList.get(i).getId().substring(0,2).equals("BG")) {
                                basketList.add(stockList.get(id));
                                return true;
                            } else {
                                System.out.println("You need a bagel to buy filling!");
                                return false;
                            }
                        }
                    } else {
                        System.out.println("You can't just buy fillings!");
                        return false;
                    }
                }
                basketList.add(stockList.get(id));
                return true;
            } else {
                System.out.println("Item does not exist in our inventory.");
                return false;
            }
        }
        System.out.println("Cannot add more items!");
        return false;
    }

    public boolean removeItem(String id) {
        if(basketList.size() != 0) {
            for (int i = 0; i < basketList.size(); i++) {
                if (basketList.get(i).getId().equals(id)) {
                    basketList.remove(i);
                    return true;
                } else {
                    System.out.println("Item not in basket!");
                    return false;
                }
            }
        }
        System.out.println("No items in basket!");
        return false;
    }

    public ArrayList<Item> listOfItems() {
        return basketList;
    }

    public double getTotalCost() {
        for (int i = 0; i < basketList.size(); i++) {
            totalCost += basketList.get(i).getPrice();
        }
        return totalCost;
    }

    public int changeCapasity(int c) {
        this.capasity = c;
        return c;
    }

    public double discountPrice() {
        int bagelCount = 0;
        int coffeeCount = 0;
        for (int i = 0; i < basketList.size(); i++) {
            if (basketList.get(i).getId().substring(0, 1).equals("B")) {
                bagelCount++;
            } else if (basketList.get(i).getId().substring(0, 1).equals("C")) {
                coffeeCount++;
            }
        }

        int remain;
        double totalDiscount = 0; 

        remain = bagelCount / 12; // 18 = 1,5;
        
        if (remain >= 1) {
            totalDiscount += 3.99;
            bagelCount = bagelCount - 12;
        }

        remain = bagelCount / 6;

        if(remain >= 1) {
            totalDiscount += 2.49;
            bagelCount = bagelCount - 6;
        }

        if (bagelCount >= 1 && coffeeCount >= 1) {
            totalDiscount += 1.25;
            bagelCount--;
            coffeeCount--;
        }

        if(bagelCount != 0) {
            for (int i = 0; i < basketList.size(); i++) {
                if (basketList.get(i).getId().substring(0,1).equals("B")) {
                    totalDiscount += basketList.get(i).getPrice();
                }
            }
        }

        if(coffeeCount != 0) {
            for (int i = 0; i < basketList.size(); i++) {
                if (basketList.get(i).getId().substring(0,1).equals("C")) {
                    totalDiscount += basketList.get(i).getPrice();
                }
            }
        }
        return totalDiscount;
    }
}
