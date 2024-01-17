package com.booleanuk.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;

// TODO Do something to differentiate  between individual bagels??
// Try "implements Cloneable"

@Data
@AllArgsConstructor
public class Item {
    private final String SKU;
    private double price;
    private final String name;
    private final String variant;
}
