package com.booleanuk.core;

import java.util.ArrayList;

public class Inventory {
    ArrayList<Bagel> bagels;
    ArrayList<Filling> fillings;
    ArrayList<Coffee> coffees;

    public Inventory() {
        bagels = new ArrayList<>();
        fillings = new ArrayList<>();
        coffees = new ArrayList<>();
    }

    public boolean bagelAvailable(BAGELTYPE type) { return true; }

    public boolean fillingAvailable(FILLINGTYPE type) { return true; }

    public boolean coffeeAvailable(COFFEETYPE type) { return true; }
}
