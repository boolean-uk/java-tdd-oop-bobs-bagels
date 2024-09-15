package com.booleanuk.core;

import java.util.ArrayList;

public abstract class BobsInvetory {

    public static ArrayList<Bagel> bagels = new ArrayList<>();
    public static ArrayList<Coffee> coffees = new ArrayList<>();
    public static ArrayList<Filling> fillings = new ArrayList<>();


    public static void resetBagelsAndCoffee() {
        BobsInvetory.bagels = new ArrayList<>();
        BobsInvetory.coffees = new ArrayList<>();
        BobsInvetory.fillings = new ArrayList<>();
    }

    //At runtime change the invetory Items
    public static void add(Item item) {
        if (item instanceof Bagel) bagels.add((Bagel) item);
        if (item instanceof Coffee) coffees.add((Coffee) item);
        if (item instanceof Filling) fillings.add((Filling) item);
    }

    public static boolean isBagelInInvetory(BAGELTYPE type) {
        return bagels.stream().anyMatch(x -> x.getType() == type);
    }

    public static boolean isCoffeeInInvetory(COFFEETYPE type) {
        return coffees.stream().anyMatch(x -> x.getType() == type);
    }

    public static boolean isFillingInInvetory(FILLINGTYPE type) {
        return fillings.stream().anyMatch(x -> x.getType() == type);
    }
}
