package com.booleanuk.core;

import java.util.ArrayList;

public class Inventory {
    ArrayList<Filling> allFillings = new ArrayList<>();
    ArrayList<Bagel> allBagels = new ArrayList<>();

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

        Bagel onion = new Bagel("Onion", "BGLO", 0.49);
        allBagels.add(onion);
        Bagel plain = new Bagel("Plain", "BGLP", 0.39);
        allBagels.add(plain);
        Bagel everything = new Bagel("Everything", "BGLE", 0.49);
        allBagels.add(everything);
        Bagel sesame = new Bagel("Sesame", "BGLS", 0.49);
        allBagels.add(sesame);
    }

    public ArrayList<Filling> getAllFillings() {
        return this.allFillings;
    }

    public boolean isBagelInInventory(String sku) {
        for (Bagel bagel : allBagels) {
            if (bagel.getSku().equalsIgnoreCase(sku)) {
                return true;
            }
        }
        return false;
    }

    public boolean isFillingInInventory(String sku) {
        for (Filling filling : allFillings) {
            if (filling.getSku().equalsIgnoreCase(sku)) {
                return true;
            }
        }
        return false;
    }
}
