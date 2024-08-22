package com.booleanuk.core;

import java.util.ArrayList;

public class Menu {

    public final static ArrayList<Item> menu = new ArrayList<>();

    static {
        populateMenu();
    }

    private static void populateMenu() {
        {
            menu.add(new Item("BGLO", 0.49f, "Bagel", "Onion"));
            menu.add(new Item("BGLP", 0.39f, "Bagel", "Plain"));
            menu.add(new Item("BGLE", 0.49f, "Bagel", "Everything"));
            menu.add(new Item("BGLS", 0.49f, "Bagel", "Sesame"));
            menu.add(new Item("COFB", 0.99f, "Coffee", "Black"));
            menu.add(new Item("COFW", 1.19f, "Coffee", "White"));
            menu.add(new Item("COFC", 1.29f, "Coffee", "Cappuccino"));
            menu.add(new Item("COFL", 1.29f, "Coffee", "Latte"));
            menu.add(new Item("FILB", 0.12f, "Filling", "Bacon"));
            menu.add(new Item("FILE", 0.12f, "Filling", "Egg"));
            menu.add(new Item("FILC", 0.12f, "Filling", "Cheese"));
            menu.add(new Item("FILX", 0.12f, "Filling", "Cream cheese"));
            menu.add(new Item("FILS", 0.12f, "Filling", "Smoked salmon"));
            menu.add(new Item("FILH", 0.12f, "Filling", "Ham"));
        }
    };

    public static boolean itemExistsMenu(String itemSKU){
        for (Item item : menu){
            if (item.getItemSKU().equals(itemSKU)){
                return true;
            }
        }
        return false;
    }

    public static Item getMenuItem(String itemSKU){
        if (itemExistsMenu(itemSKU)){
            for (Item item : menu){
                if (item.getItemSKU().equals(itemSKU)){
                    return item;
                }
            }
        }
        return null;
    }

    public static String getItemCost(String itemSKU){
        if (itemExistsMenu(itemSKU)){
            for (Item item : menu){
                if (item.getItemSKU().equals(itemSKU)){
                    return String.format("%.2f", item.getItemPrice());
                }
            }
        }
        return null;
    }

}
