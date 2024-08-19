package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Objects;

public class Menu {
    private static final ArrayList<Item> menu = new ArrayList<>();

    static {
        initializeMenu();
    }

    private static void initializeMenu(){
        menu.add(new Bagel("BGLO", 0.49, "Bagel", "Onion"));
        menu.add(new Bagel("BGLP", 0.39, "Bagel", "Plain"));
        menu.add(new Bagel("BGLE", 0.49, "Bagel", "Everything"));
        menu.add(new Bagel("BGLS", 0.49, "Bagel", "Sesame"));
        menu.add(new Coffee("COFB", 0.99, "Coffee", "Black"));
        menu.add(new Coffee("COFW", 1.19, "Coffee", "White"));
        menu.add(new Coffee("COFC", 1.20, "Coffee", "Capuccino"));
        menu.add(new Coffee("COFL", 1.29, "Coffee", "Latte"));
        menu.add(new Filling("FILB", 0.12, "Filling", "Bacon"));
        menu.add(new Filling("FILE", 0.12, "Filling", "Egg"));
        menu.add(new Filling("FILC", 0.12, "Filling", "Cheese"));
        menu.add(new Filling("FILX", 0.12, "Filling", "Cream Cheese"));
        menu.add(new Filling("FILS", 0.12, "Filling", "Smoked Salmon"));
        menu.add(new Filling("FILH", 0.12, "Filling", "Ham"));
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
