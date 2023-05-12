package com.booleanuk.core;

import java.util.List;

public class Inventory {

    List<Bagel> existingBagels = List.of(
            new Bagel("Onion", 0.49, this),
            new Bagel("Plain", 0.39, this),
            new Bagel("Everything", 0.49, this),
            new Bagel("Sesame", 0.49, this)
    );

    List<Filling> existingFillings = List.of(
            new Filling("Bacon", 0.12),
            new Filling("Egg", 0.12),
            new Filling("Cheese", 0.12),
            new Filling("Cream Cheese", 0.12),
            new Filling("Smoked Salmon", 0.12),
            new Filling("Ham", 0.12)
    );

    List<Coffee> existingCoffees = List.of(
            new Coffee("Black", 0.99),
            new Coffee("White", 1.19),
            new Coffee("Capuccino", 1.29),
            new Coffee("Latte", 1.29)
    );

    public boolean contains(Bagel bagel){
        for (Bagel b : existingBagels) {
            if (b.getVariant().equals(bagel.getVariant())) {
                return true;
            }
        }

        return false;
    }

    public boolean contains(Filling filling){
        for (Filling f : existingFillings) {
            if (f.getVariant().equals(filling.getVariant())) {
                return true;
            }
        }

        return false;
    }

    public boolean contains(Coffee coffee){
        for (Coffee c : existingCoffees) {
            if (c.getVariant().equals(coffee.getVariant())) {
                return true;
            }
        }

        return false;
    }
}
