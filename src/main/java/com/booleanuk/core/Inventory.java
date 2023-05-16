package com.booleanuk.core;

import java.util.ArrayList;

public abstract class Inventory {
    private static ArrayList<Item> items = new ArrayList<>();
//    private static ArrayList<Bagel> bagels = new ArrayList<>();
//    private static ArrayList<Filling> fillings = new ArrayList<>();
//    private static ArrayList<Coffee> coffees = new ArrayList<>();

    public static ArrayList<Item> getItems() { return items; }
//    public static ArrayList<Bagel> getBagels() { return bagels; }
//    public static ArrayList<Filling> getFillings() { return fillings; }
//    public static ArrayList<Coffee> getCoffees() { return coffees; }

    public static void reset() {
        items = new ArrayList<>();
//        bagels = new ArrayList<>();
//        fillings = new ArrayList<>();
//        coffees = new ArrayList<>();
    }

    public static void add(Item item) {
        items.add(item);
//        if(item instanceof Bagel) bagels.add((Bagel) item);
//        if(item instanceof Filling) fillings.add((Filling) item);
//        if(item instanceof Coffee) coffees.add((Coffee) item);
    }

    public static boolean itemAvailable(Item item) {
        return items.stream().anyMatch(x -> x.SKU.equals(item.SKU));
    }

//    public static boolean bagelAvailable(BAGELTYPE type) { return bagels.stream().anyMatch(x -> x.getType() == type); }
//
//    public static boolean fillingAvailable(FILLINGTYPE type) { return fillings.stream().anyMatch(x -> x.getType() == type); }
//
//    public static boolean coffeeAvailable(COFFEETYPE type) { return coffees.stream().anyMatch(x -> x.getType() == type); }
}
