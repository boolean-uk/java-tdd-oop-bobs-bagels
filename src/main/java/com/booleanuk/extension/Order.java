package com.booleanuk.extension;

import java.util.Map;

public class Order {
    private final Map<Item, Integer> orderedItems;

    public Order(Map<Item, Integer>orderedItems) {
        this.orderedItems = orderedItems;
    }
}
