package com.booleanuk.core;

import java.util.HashMap;
import java.util.HashSet;

public class Item {
    private final IItemType itemType;
    public Item(IItemType itemType) {
        this.itemType = itemType;
    }
    public String getSku() {
        return itemType.getSku();
    }
    public double getPrice() {
        return itemType.getPrice();
    }
    public String getVariant() {
        return itemType.getVariant();
    }
}

