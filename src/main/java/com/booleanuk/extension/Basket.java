package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Basket {
    private Inventory inventory;
    private int capacity;
    private ArrayList<Item> items = new ArrayList<>();

    public Basket(Inventory inventory, int capacity) {
        this.inventory = inventory;
        this.capacity = capacity;
    }

    boolean addItem(Item item) {
        // if basket is not full and item is in stock
        if (items.size() < capacity && inventory.checkStock(item.getSku())) {
            items.add(item);
            inventory.removeStock(item.getSku(), 1); // remove item from stock
            return true;
        }
        return false;
    }

    boolean removeItem(SKU sku) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getSku() == sku) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }

    float getTotalCost() {
        float total = 0f;
        HashMap<Item, Integer> itemCounts = getItemCounts();

        // count how many black coffees in basket
        int nrOfBlackCoffees = 0;
        for (Item i : items) {
            if (i.getSku() == SKU.COFB) {
                nrOfBlackCoffees++;
            }
        }

        for (Map.Entry<Item, Integer> entry : itemCounts.entrySet()) {
            Item item = entry.getKey();
            Integer count = entry.getValue();

            // check for bagel discount
            if (item instanceof Bagel) {
                if (count >= 12) {
                    count -= 12;
                    total += 3.99f + (item.getPrice() * count);
                } else if (count >= 6) {
                    count -= 6;
                    total += 2.49f + (item.getPrice() * count);
                } else {
                    // check for black coffee
                    while (nrOfBlackCoffees > 0 && count > 0) {
                        nrOfBlackCoffees--;
                        count--;
                        total += 1.25f;
                    }
                    // add remaining bagels
                    total += item.getPrice() * count;
                }
            } else {
                if (item.getSku() != SKU.COFB)
                    total += item.getPrice() * count;
            }
        }

        // add remaining black coffees
        total += 0.99f * nrOfBlackCoffees;

        total = Math.round(total * 100) / 100.0f; // round to 2 decimals
        return total;
    }

    ArrayList<Item> getItems() {
        return items;
    }

    // count occurences for each item
    HashMap<Item, Integer> getItemCounts() {
        HashMap<Item, Integer> itemMap = new HashMap<>();
        for (Item item : items) {
            boolean itemExists = false;

            // check if this item exists in map
            for (Item key : itemMap.keySet()) {
                if (key.getSku() == item.getSku()) {
                    itemExists = true;
                    itemMap.put(key, itemMap.get(key) + 1);
                }
            }

            // if this is a new item
            if (!itemExists) {
                itemMap.put(item, 1);
            }
        }
        return itemMap;
    }
}
