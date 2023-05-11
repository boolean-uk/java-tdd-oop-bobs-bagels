package com.booleanuk.core;

import java.util.ArrayList;

public abstract class Inventory {
    static ArrayList<Bagel> bagels = new ArrayList<>();
    static ArrayList<Filling> fillings = new ArrayList<>();
    static ArrayList<Coffee> coffees = new ArrayList<>();

//    public Inventory() {
//        bagels = new ArrayList<>();
//        fillings = new ArrayList<>();
//        coffees = new ArrayList<>();
//    }

    public static void reset() {
        bagels = new ArrayList<>();
        fillings = new ArrayList<>();
        coffees = new ArrayList<>();
    }

    public static boolean bagelAvailable(BAGELTYPE type) {
        if(bagels.stream().anyMatch(x -> x.getType() == type)) return true;
        return false;
    }

    public static boolean fillingAvailable(FILLINGTYPE type) {
        if(fillings.stream().anyMatch(x -> x.getType() == type)) return true;
        return false;
    }

    public static boolean coffeeAvailable(COFFEETYPE type) {
        if(coffees.stream().anyMatch(x -> x.getType() == type)) return true;
        return false;
    }
}
