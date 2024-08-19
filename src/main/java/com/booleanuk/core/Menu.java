package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Objects;

public class Menu {
    private static final ArrayList<Item> menu = new ArrayList<>();

    static {
        initializeMenu();
    }

    private static void initializeMenu(){
        menu.add(new Bagel("BGLO", 49, "Bagel", "Onion"));
        menu.add(new Bagel("BGLP", 39, "Bagel", "Plain"));
        menu.add(new Bagel("BGLE", 49, "Bagel", "Everything"));
        menu.add(new Bagel("BGLS", 49, "Bagel", "Sesame"));
        menu.add(new Coffee("COFB", 99, "Coffee", "Black"));
        menu.add(new Coffee("COFW", 119, "Coffee", "White"));
        menu.add(new Coffee("COFC", 120, "Coffee", "Capuccino"));
        menu.add(new Coffee("COFL", 129, "Coffee", "Latte"));
        menu.add(new Filling("FILB", 12, "Filling", "Bacon"));
        menu.add(new Filling("FILE", 12, "Filling", "Egg"));
        menu.add(new Filling("FILC", 12, "Filling", "Cheese"));
        menu.add(new Filling("FILX", 12, "Filling", "Cream Cheese"));
        menu.add(new Filling("FILS", 12, "Filling", "Smoked Salmon"));
        menu.add(new Filling("FILH", 12, "Filling", "Ham"));
    }

    public static Item getItemFromMenu(String name, String variant){
        for (Item i : menu){
            if (Objects.equals(i.variant, variant) & Objects.equals(i.name, name))
            {
                switch (name) {
                    case "Bagel" -> {
                        return new Bagel(i.sku, i.price, i.name, i.variant);
                    }
                    case "Coffee" -> {
                        return new Coffee(i.sku, i.price, i.name, i.variant);
                    }
                    case "Filling" -> {
                        return new Filling(i.sku, i.price, i.name, i.variant);
                    }
                }
            }
        }
        return null;
    }
}
