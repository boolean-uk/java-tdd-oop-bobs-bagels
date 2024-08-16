package com.booleanuk.core;

public class Store {
    private final String name;

    public Store(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
