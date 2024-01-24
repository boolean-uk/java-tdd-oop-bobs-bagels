package com.booleanuk.core;

import java.util.ArrayList;

public class Inventory {

    private static ArrayList<Product> allProducts = new ArrayList<>();

    public Inventory() {
        Filling bacon = new Filling("Bacon", "FILB");
        this.allProducts.add(bacon);
        Filling egg = new Filling("Egg", "FILE");
        this.allProducts.add(egg);
        Filling cheese = new Filling("Cheese", "FILC");
        this.allProducts.add(cheese);
        Filling creamCheese = new Filling("Cream Cheese", "FILX");
        this.allProducts.add(creamCheese);
        Filling smokedSalmon = new Filling("Smoked Salmon", "FILS");
        this.allProducts.add(smokedSalmon);
        Filling ham = new Filling("Ham", "FILH");
        this.allProducts.add(ham);

        Bagel onion = new Bagel("Onion", "BGLO", 0.49);
        this.allProducts.add(onion);
        Bagel plain = new Bagel("Plain", "BGLP", 0.39);
        this.allProducts.add(plain);
        Bagel everything = new Bagel("Everything", "BGLE", 0.49);
        this.allProducts.add(everything);
        Bagel sesame = new Bagel("Sesame", "BGLS", 0.49);
        this.allProducts.add(sesame);

        Coffee black = new Coffee("Black", "COFB", 0.99);
        this.allProducts.add(black);
        Coffee white = new Coffee("White", "COFW", 1.19);
        this.allProducts.add(white);
        Coffee cappuccino = new Coffee("Capuccino", "COFC", 1.29);
        this.allProducts.add(cappuccino);
        Coffee latte = new Coffee("Latte", "COFL", 1.29);
        this.allProducts.add(latte);
    }

    public ArrayList<Filling> getAllFillings() {
        ArrayList<Filling> allFillings =  new ArrayList<>();
        for (Product product : allProducts) {
            if (product instanceof Filling) {
                allFillings.add((Filling) product);
            }
        }
        return allFillings;
    }

    public boolean isProductInInventory(String sku) {
        for (Product product : this.allProducts) {
            if (product.getSku().equalsIgnoreCase(sku)) {
                return true;
            }
        }
        return false;
    }
}
