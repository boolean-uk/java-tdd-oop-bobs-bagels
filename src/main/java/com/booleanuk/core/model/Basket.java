package com.booleanuk.core.model;

import com.booleanuk.core.model.item.Bagel;
import com.booleanuk.core.model.item.Coffee;
import com.booleanuk.core.model.item.Filling;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Basket {
    private static final int DEFAULT_CAPACITY = 12;
    private ArrayList<Item> basket;
    private int capacity;

    public Basket() {
        this.basket = new ArrayList<>();
        this.capacity = 12;
    }
    public Basket(int capacity) {
        this.basket = new ArrayList<>();
        this.capacity = capacity;
    }

    public Item addItem(Item item) {
        if (basket.size() >= capacity) {
            return null;
        }
        Item itemCopy = createItemCopy(item); // Make copy of inventory item
        basket.add(itemCopy);
        return itemCopy;
    }

    public boolean removeItem(Item item) {
        return basket.remove(item);
    }

    public double getTotalCost() {
        double cost = 0;
        for (Item item : basket) {
            cost += item.getPrice();
        }
        return cost;
    }

    private Item createItemCopy(Item item) {
        if (item instanceof Bagel) {
            return new Bagel((Bagel) item);
        } else if (item instanceof Coffee) {
            return new Coffee((Coffee) item);
        } else if (item instanceof Filling) {
            return new Filling((Filling) item);
        } else {
            // Make generic Item copy
            return new Item(item);
        }
    }
}
