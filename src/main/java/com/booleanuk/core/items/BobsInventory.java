package com.booleanuk.core.items;

import java.util.List;

public class BobsInventory implements Inventory {
    List<Item> items = List.of(
            new Bagel("Onion", 0.49),
            new Bagel("Plain", 0.39),
            new Bagel("Everything", 0.49),
            new Bagel("Sesame", 0.49),
            new BagelFilling("Bacon", 0.12),
            new BagelFilling("Egg", 0.12),
            new BagelFilling("Cheese", 0.12),
            new BagelFilling("Cream Cheese", 0.12),
            new BagelFilling("Smoked Salmon", 0.12),
            new BagelFilling("Ham", 0.12),
            new Coffee("Black", 0.99),
            new Coffee("White", 1.19),
            new Coffee("Cappuccino", 1.29),
            new Coffee("Latte", 1.29)
    );

    @Override
    public boolean contains(Item item) {
        return items.stream().anyMatch(i -> i.variant().equals(item.variant()));
    }

    @Override
    public void expand(List<Item> items) {
        this.items.addAll(items);
    }
}
