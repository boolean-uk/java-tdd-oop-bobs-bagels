package com.booleanuk.core;

import java.util.ArrayList;

public class Menu {

    private final ArrayList<Item> menu= new ArrayList<>(){
        {
            add(new Item("BGLO", 0.49f, "Bagel", "Onion"));
            add(new Item("BGLP", 0.39f, "Bagel", "Plain"));
            add(new Item("BGLE", 0.49f, "Bagel", "Everything"));
            add(new Item("BGLS", 0.49f, "Bagel", "Sesame"));
            add(new Item("COFB", 0.99f, "Bagel", "Black"));
            add(new Item("COFW", 1.19f, "Bagel", "White"));
            add(new Item("COFC", 1.29f, "Bagel", "Cappuccino"));
            add(new Item("COFL", 1.29f, "Bagel", "Latte"));
            add(new Item("FILB", 0.12f, "Bagel", "Bacon"));
            add(new Item("FILE", 0.12f, "Bagel", "Egg"));
            add(new Item("FILC", 0.12f, "Bagel", "Cheese"));
            add(new Item("FILX", 0.12f, "Bagel", "Cream cheese"));
            add(new Item("FILS", 0.12f, "Bagel", "Smoked salmon"));
            add(new Item("FILH", 0.12f, "Bagel", "Ham"));
        }
    };

    public ArrayList<Item> getMenu(){
        return this.menu;
    }

    public boolean itemExistsMenu(String itemSKU){
        for (Item item : menu){
            if (item.getItemSKU().equals(itemSKU)){
                return true;
            }
        }
        return false;
    }

    public Item getMenuItem(String itemSKU){
        if (itemExistsMenu(itemSKU)){
            for (Item item : menu){
                if (item.getItemSKU().equals(itemSKU)){
                    return item;
                }
            }
        }
        return null;
    }

    public String getItemCost(String itemSKU){
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
