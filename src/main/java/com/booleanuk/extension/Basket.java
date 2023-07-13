package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {
    private int capacity;
    private final static int SIX_BAGELS_PRICE = 249 + 72;
    private final static int TWELVE_BAGELS_PRICE = 399 + 144;
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
        List<Long> listOfPrices = items.entrySet().stream().map(entry -> {
            if(entry.getKey() instanceof Bagel && entry.getValue() >= 6 && entry.getValue() < 12){
                return SIX_BAGELS_PRICE + (entry.getValue()%6)*entry.getKey().getPrice();
            }
            else if(entry.getKey() instanceof Bagel && entry.getValue() >= 12){
                return TWELVE_BAGELS_PRICE + (entry.getValue()%12)*entry.getKey().getPrice();
            }
            else return entry.getKey().getPrice() * entry.getValue();
        }).toList();
        return listOfPrices.stream().reduce(0L, Long::sum) / 100.0;
    }
}
