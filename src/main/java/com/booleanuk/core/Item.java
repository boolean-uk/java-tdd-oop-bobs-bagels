package com.booleanuk.core;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    protected final String SKU;
    protected double price;
    protected final String name;
    protected final String variant;

    // Copy constructor to differentiate between individual bagels/items
    public Item(Item another) {
        this.SKU = another.SKU;
        this.price = another.price;
        this.name = another.name;
        this.variant = another.variant;
    }
}
