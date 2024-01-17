package com.booleanuk.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private final String SKU;
    private double price;
    private final String name;
    private final String variant;
}
