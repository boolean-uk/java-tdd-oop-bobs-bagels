package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {

    private Map<String, Item> inventory = new HashMap<>();

    public InventoryManager() {
        initializeInventory();
    }

    /**
     * Logic: Initialize Bob's Bagels current stockpile of Items
     * Iterating for-loop, just modify array-elements to change stockpile
     * Remember to ensure arrays of same length
     */
    public void initializeInventory() {
        String[] SKU = new String[]{"BGLO", "BGLP", "BGLE", "BGLS", "COFB", "COFW", "COFC", "COFL", "FILB", "FILE", "FILC", "FILX", "FILS", "FILH"};
        double[] price = new double[]{.49, .39, .49, .49, .99, 1.19, 1.29, 1.29, .12, .12, .12, .12, .12, .12};
        Item.Name[] name = new Item.Name[]{Item.Name.BAGEL, Item.Name.BAGEL, Item.Name.BAGEL, Item.Name.BAGEL, Item.Name.COFFEE, Item.Name.COFFEE, Item.Name.COFFEE, Item.Name.COFFEE, Item.Name.FILLING, Item.Name.FILLING, Item.Name.FILLING, Item.Name.FILLING, Item.Name.FILLING, Item.Name.FILLING};
        Item.Variant[] variant = new Item.Variant[]{Item.Variant.ONION, Item.Variant.PLAIN, Item.Variant.EVERYTHING, Item.Variant.SESAME, Item.Variant.BLACK, Item.Variant.WHITE, Item.Variant.CAPUCCINO, Item.Variant.LATTE, Item.Variant.BACON, Item.Variant.EGG, Item.Variant.CHEESE, Item.Variant.CREAM_CHEESE, Item.Variant.SMOKED_SALMON, Item.Variant.HAM};

        for (int i = 0; i < SKU.length; i++) {
            this.inventory.put(SKU[i], new Item(SKU[i], price[i], name[i], variant[i], null));
        }
    }

    public StringBuilder costEachFilling() {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (Map.Entry<String, Item> entry : getInventory().entrySet()) {
            String key = entry.getKey();
            Item value = entry.getValue();
            String str = "";
            if (value.getName() == Item.Name.FILLING) {
                str = "Item: {" +
                        "SKU: '" + key + '\'' +
                        ", price: " + value.getPrice() +
                        '}';
                sb.append(str + "\n");
                System.out.println(str);
            }
        }
        return sb;
    }

    /**
     * Getters for member variables
     */

    public Map<String, Item> getInventory() {
        return this.inventory;
    }

    /**
     * Setters for member variables
     */

    public void setInventory(Map<String, Item> inventory) {
        this.inventory = inventory;
    }
}
