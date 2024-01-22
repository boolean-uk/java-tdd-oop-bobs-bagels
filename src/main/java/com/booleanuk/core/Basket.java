package com.booleanuk.core;

import com.booleanuk.core.items.Bagel;
import com.booleanuk.core.items.Coffee;
import com.booleanuk.core.items.Filling;
import com.booleanuk.extension.DiscountManager;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;

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
        setCapacity(capacity);
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
            if (item instanceof Bagel) {
                for (Filling filling : ((Bagel) item).getFilling()) {
                    cost += filling.getPrice();
                }
            }
        }

        double discount;
        try {
            discount = DiscountManager.calculateBasketBagelDiscounts(this);
        } catch (Exception e) {
            System.err.println("DiscountManager could not read file");
            discount = 0.0;
        }

        return cost - discount;
    }

    public HashMap<Item, Integer> getItemCount() {
        HashMap<Item, Integer> itemCount = new HashMap<>();
        for (Item item : this.basket) {
            if (itemCount.get(item) == null) {
                itemCount.put(item, 1);
                continue;
            }

            int currentCount = itemCount.get(item);
            itemCount.put(item, currentCount + 1);
        }
        return itemCount;
    }

    public void addFillingToBagel(Bagel bagel, Filling filling) {
        for (Item item : basket) {
            if (item == bagel) {
                ((Bagel) item).addFilling(new Filling(filling));
            }
        }
    }

    private Item createItemCopy(Item item) {
        if (item instanceof Bagel) {
            return new Bagel((Bagel) item);
        } else if (item instanceof Coffee) {
            return new Coffee((Coffee) item);
        } else if (item instanceof Filling) {
            return new Filling((Filling) item);
        }
        // Make generic Item copy
        return new Item(item);
    }

    public void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
    }
}
