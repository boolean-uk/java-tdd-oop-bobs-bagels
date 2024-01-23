package com.booleanuk.core;

import java.util.ArrayList;

public class Inventory {
    ArrayList<Filling> allFillings = new ArrayList<>();

    public Inventory() {
        Filling bacon = new Filling("Bacon", "FILB");
        this.allFillings.add(bacon);
        Filling egg = new Filling("Egg", "FILE");
        this.allFillings.add(egg);
        Filling cheese = new Filling("Cheese", "FILC");
        this.allFillings.add(cheese);
        Filling creamCheese = new Filling("Cream Cheese", "FILX");
        this.allFillings.add(creamCheese);
        Filling smokedSalmon = new Filling("Smoked Salmon", "FILS");
        this.allFillings.add(smokedSalmon);
        Filling ham = new Filling("Ham", "FILH");
        this.allFillings.add(ham);
    }

    public ArrayList<Filling> getAllFillings() {
        return this.allFillings;
    }

    public boolean isBagelInInventory(String sku) {
        //if()
        return true;
    }

    public boolean isFillingInInventory(String sku) {
        for(Filling filling : allFillings) {
            if (filling.getSku().equals(sku)) {
                return true;
            }
        }
        return false;
    }
}
