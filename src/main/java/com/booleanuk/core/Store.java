package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

public class Store {
    private final String name;
    private final Inventory inventory;
    private ArrayList<Order> orders;

    public Store(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.name = name;
        this.inventory = new Inventory();
        this.orders = new ArrayList<>();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getName() {
        return name;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

}
