package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket {

    private int capasity = 10;
    private double totalCost;
    private String bagel = "BGLO";

    public ArrayList<Item> basketList = new ArrayList<>();
    public HashMap<String, Item> stockList = new HashMap<>() {{
        Item bagelOnion = new Item("BGLO", 0.49, "Bagel", "Onion");
        put("BGLO", bagelOnion);
        Item bagelPlain = new Item("BGLP", 0.39, "Bagel", "Plain");
        put("BGLP", bagelPlain);
        Item bagelEvery = new Item("BGLE", 0.49, "Bagel", "Everything");
        put("BGLE", bagelEvery);
        Item bagelSesame = new Item("BGLS", 0.49, "Bagel", "Sesame");
        put("BGLS", bagelSesame);
        Item coffeeBlack = new Item("COFB", 0.99, "Coffee", "Black");
        put("COFB", coffeeBlack);
        Item coffeeWhite = new Item("COFW", 1.19, "Coffee", "White");
        put("COFW", coffeeWhite);
        Item coffeeCapuccino = new Item("COFC", 1.29, "Coffee", "Capuccino");
        put("COFC", coffeeCapuccino);
        Item coffeeLatte = new Item("COFL", 1.29, "Coffee", "Latte");
        put("COFL", coffeeLatte);
        Item fillBacon = new Item("FILB", 0.12, "Filling", "Bacon");
        put("FILB", fillBacon);
        Item fillEgg = new Item("FILE", 0.12, "Filling", "Egg");
        put("FILE", fillEgg);
        Item fillCheese = new Item("FILC", 0.12, "Filling", "Egg");
        put("FILC", fillCheese);
        Item fillCream = new Item("FILX", 0.12, "Filling", "Cream Cheese");
        put("FILX", fillCream);
        Item fillSal = new Item("FILS", 0.12, "Filling", "Smoked Salmon");
        put("FILS", fillSal);
        Item fillHam = new Item("FILH", 0.12, "Filling", "Ham");
        put("FILH", fillHam);
    }};

    public Basket() {
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
                return false;
            }
        }
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

    }
}
