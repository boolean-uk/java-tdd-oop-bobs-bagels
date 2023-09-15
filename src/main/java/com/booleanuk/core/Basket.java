package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private final HashMap<Product,Integer> items;
    private int capacity;

    public Basket(int maxCapacity) {
        this.items = new HashMap<>();
        this.capacity = maxCapacity;
        System.out.println("#Shop Basket initiating...");
    }

    public int getCapacity() {
        return capacity;
    }

    private int getSize() {
        int size = 0;
        for (int item: this.items.values()){
            size += item;
        }
        return size;
    }

    public boolean addProduct(Product product){
        if (this.getSize() == this.capacity){
            return false;
        }
        int quantity = this.items.getOrDefault(product,0);
        this.items.put(product,quantity+1);
        return true;
    }

    public boolean removeProduct(Product product){
        boolean flag = true;
        int quantity = this.items.getOrDefault(product, 0);
        switch (quantity){
            case 0 -> flag = false;
            case 1 -> this.items.remove(product);
            default -> this.items.replace(product, quantity-1);
        }
        return flag;
    }

    public boolean setCapacity(int newCapacity) {
        if (newCapacity > this.capacity){
            this.capacity = newCapacity;
            return true;
        }
        System.out.println("New capacity cannot be smaller than the current one.");
        return false;
    }

    public double getTotalCost() {
        double cost = 0.00d;
        if (this.items.isEmpty()) return cost;
        for (Map.Entry<Product,Integer> item: this.items.entrySet()) {
            cost += item.getKey().getCost() * item.getValue();
        }
        return cost;
    }
}
