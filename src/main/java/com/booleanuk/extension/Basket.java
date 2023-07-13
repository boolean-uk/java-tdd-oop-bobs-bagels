package com.booleanuk.extension;

import com.booleanuk.extension.types.FillingType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {
    private int capacity;
    public final static int SIX_BAGELS_PRICE = 249;
    public final static int TWELVE_BAGELS_PRICE = 399;
    public final static int SINGLE_FILLING_PRICE = 12;
    public final static int COFFEE_PLUS_BAGEL = 125;

    private Map<Item,Integer> items;

    public Basket(int capacity) {
        this.capacity = capacity;
        this.items = new HashMap<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void changeCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        return this.getItemCount() >= capacity;
    }

    public boolean checkIfExists(Item item) {
        return items.keySet().contains(item);
    }

    public int getItemCount() {

        return items.values().stream().mapToInt(Integer::intValue).sum();
    }

    public int freeSpace() {
        return capacity - getItemCount();
    }

    public void clearBasket() {
        items.clear();
    }

    public Map<Item,Integer> getItems() {
        return items;
    }

    public void add(Item item) {
        if (isFull()) throw new IllegalStateException("You can't add this item");
        else{
            int quantity = items.getOrDefault(item,0);
            items.put(item,quantity + 1);
        }
    }

    public void remove(Item item) {
        if (checkIfExists(item)) items.remove(item);
        else throw new IllegalArgumentException("You can't remove this item");
    }

    public double getTotalCost() {
        long priceOfFillings = items.entrySet().stream().filter(entry -> entry.getKey() instanceof Bagel)
                .map(entry -> entry.getValue() * ((Bagel) entry.getKey()).getFillingType().getPrice())
                .reduce(0L, Long::sum);

        long priceOfItems = items.entrySet().stream().map(entry -> {
            if(entry.getKey() instanceof Bagel && entry.getValue() >= 6 && entry.getValue() < 12){
                return SIX_BAGELS_PRICE + (entry.getValue()%6)*entry.getKey().getPrice();
            }
            else if(entry.getKey() instanceof Bagel && entry.getValue() >= 12){
                return TWELVE_BAGELS_PRICE + (entry.getValue()%12)*entry.getKey().getPrice();
            }
            else return entry.getKey().getPrice() * entry.getValue();
        }).reduce(0L, Long::sum);

        return (priceOfFillings + priceOfItems) / 100.0;
    }
}
