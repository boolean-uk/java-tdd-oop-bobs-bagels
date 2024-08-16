package com.booleanuk.core;

public class Store {
    private final String name;
    private final Inventory inventory;

    public Store(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.name = name;
        this.inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getName() {
        return name;
    }

}
