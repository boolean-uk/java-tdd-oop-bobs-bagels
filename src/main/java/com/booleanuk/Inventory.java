package com.booleanuk;

import java.util.List;

public class Inventory {
    List<Item> existingItems = List.of(
            new Bagel("Onion", 0.49, this),
            new Bagel("Plain", 0.39, this),
            new Bagel("Everything", 0.49, this),
            new Bagel("Sesame", 0.49, this),
            new Filling("Bacon", 0.12),
            new Filling("Egg", 0.12),
            new Filling("Cheese", 0.12),
            new Filling("Cream Cheese", 0.12),
            new Filling("Smoked Salmon", 0.12),
            new Filling("Ham", 0.12),
            new Coffee("Black", 0.99),
            new Coffee("White", 1.19),
            new Coffee("Capuccino", 1.29),
            new Coffee("Latte", 1.29)
    );

    public boolean contains(Item item) {
        return existingItems.contains(item);
    }
}
