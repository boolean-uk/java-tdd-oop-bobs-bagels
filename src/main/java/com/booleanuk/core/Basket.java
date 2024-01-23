package com.booleanuk.core;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Item> items;

    public Basket() {
        items = new ArrayList<>();
    }

    public ArrayList<Item> getItems() {
        return new ArrayList<>(items);
    }

    public void add(Item item) {
        items.add(item);
    }

    public int getNoOfItems() {
        return items.size();
    }

    public boolean remove(Item item) {
        if(item.containsOtherItems()) {
            for (int i = 0; i < items.size(); i++) {
                if (item.getName().equals(items.get(i).getName()) && item.getContainedItems().equals(items.get(i).getContainedItems())) {
                    items.remove(i);
                    return true;
                }
            }
        } else {
            return items.remove(item);
        }
        return items.remove(item);
    }

    @Override
    public String toString() {
        return items.toString();
    }

}
