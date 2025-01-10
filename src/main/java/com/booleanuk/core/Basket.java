package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Basket {

    private int capasity = 10;
    private double totalCost;
    private HashMap<String, Item> basketList;
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
        put("CFOW", coffeeWhite);
        Item coffeeCapuccino = new Item("COFC", 1.29, "Coffee", "Capuccino");
        put("COFC", coffeeCapuccino);
        Item coffeeLatte = new Item("COFL", 1.29, "Coffee", "Latte");
        put("BGLO", coffeeLatte);
        Item fillBacon = new Item("FILB", 0.12, "Filling", "Bacon");
        put("BGLO", fillBacon);
        Item fillEgg = new Item("FILE", 0.12, "Filling", "Egg");
        put("BGLO", fillEgg);
        Item fillCheese = new Item("FILC", 0.12, "Filling", "Egg");
        put("BGLO", fillCheese);
        Item fillCream = new Item("FILX", 0.12, "Filling", "Cream Cheese");
        put("BGLO", fillCream);
        Item fillSal = new Item("FILS", 0.12, "Filling", "Smoked Salmon");
        put("BGLO", fillSal);
        Item fillHam = new Item("FILH", 0.12, "Filling", "Ham");
        put("BGLO", fillHam);
    }};

    public Basket() {
    }
}
