package com.booleanuk.core;

import java.util.HashSet;
import java.util.Set;

public class Inventory {

    private static Set<Filling> allFillings = new HashSet<>();
    private static Set<Bagel> allBagels =new HashSet<>();
    private static Set<Coffee> allCoffees = new HashSet<>();


    public Inventory() {
        addToInventory();
    }

    private static void addToInventory() {
        allBagels.add(new Bagel("Onion", 0.49, "BGLO", BagelVariant.ONION));
        allBagels.add(new Bagel("Plain", 0.39, "BGLP", BagelVariant.PLAIN));
        allBagels.add(new Bagel("Everything", 0.49, "BGLE", BagelVariant.EVERYTHING));
        allBagels.add(new Bagel("Sesame", 0.49, "BGLS", BagelVariant.SESAME));
        allCoffees.add(new Coffee("Black",0.99,"COFB",CoffeeVariant.BLACK));
        allCoffees.add(new Coffee("White",1.19,"COFW",CoffeeVariant.WHITE));
        allCoffees.add(new Coffee("Capuccino",1.29,"COFC",CoffeeVariant.CAPUCCINO));
        allCoffees.add(new Coffee("Latte",1.29,"COFL",CoffeeVariant.LATTE));
        allFillings.add(new Filling("Bacon",0.12,"FILB",FillingVariant.BACON));
        allFillings.add(new Filling("Egg",0.12,"FILB",FillingVariant.EGG));
        allFillings.add(new Filling("Cheese",0.12,"FILB",FillingVariant.CHEESE));
        allFillings.add(new Filling("Cream Cheese",0.12,"FILB",FillingVariant.CREAM_CHEESE));
        allFillings.add(new Filling("Smoked Salmon",0.12,"FILB",FillingVariant.SMOKED_SALMON));
        allFillings.add(new Filling("Ham",0.12,"FILB",FillingVariant.HAM));
    }
}
