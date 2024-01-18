package com.booleanuk.core.model;

import lombok.*;

@Data
@AllArgsConstructor
public class Item {
    private final String SKU;
    private double price;
    private final String name;
    private final String variant;

    // Copy constructor to differentiate between individual bagels/items
    public Item(Item another) {
        this.SKU = another.SKU;
        this.price = another.price;
        this.name = another.name;
        this.variant = another.variant;
    }
}
