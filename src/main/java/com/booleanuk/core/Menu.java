package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Objects;

public class Menu {
    private static ArrayList<Item> menu = new ArrayList<>();

    static {
        initializeMenu();
    }

    private static void initializeMenu(){
        menu.add(new Bagel("bglo", 0.49, "bagel", "onion"));
        menu.add(new Bagel("bglp", 0.39, "bagel", "plain"));
        menu.add(new Bagel("bgle", 0.49, "bagel", "everything"));
        menu.add(new Bagel("bgls", 0.49, "bagel", "sesame"));
        menu.add(new Coffee("cofb", 0.99, "coffee", "black"));
        menu.add(new Coffee("cofw", 1.19, "coffee", "white"));
        menu.add(new Coffee("cofc", 1.20, "coffee", "capuccino"));
        menu.add(new Coffee("cofl", 1.29, "coffee", "latte"));
        menu.add(new Filling("filb", 0.12, "filling", "bacon"));
        menu.add(new Filling("file", 0.12, "filling", "egg"));
        menu.add(new Filling("filc", 0.12, "filling", "cheese"));
        menu.add(new Filling("filx", 0.12, "filling", "cream cheese"));
        menu.add(new Filling("fils", 0.12, "filling", "smoked salmon"));
        menu.add(new Filling("filh", 0.12, "filling", "ham"));
    }

    public static Item getItemFromMenu(String name, String variant){
        name = name.toLowerCase();
        variant = variant.toLowerCase();

        for (Item i : menu){
            if (Objects.equals(i.variant, variant) & Objects.equals(i.name, name))
            {
                switch (name) {
                    case "bagel" -> {
                        return new Bagel(i.sku, i.price, i.name, i.variant);
                    }
                    case "coffee" -> {
                        return new Coffee(i.sku, i.price, i.name, i.variant);
                    }
                    case "filling" -> {
                        return new Filling(i.sku, i.price, i.name, i.variant);
                    }
                }
            }
        }
        return null;
    }
}
