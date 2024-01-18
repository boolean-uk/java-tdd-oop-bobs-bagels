package com.booleanuk.core.models.item;

import com.booleanuk.core.models.Item;

public class Coffee extends Item {
    public Coffee(String SKU, double price, String name, String variant) {
        super(SKU, price, name, variant);
    }

    public Coffee(Coffee another) {
        super(another);
    }

    @Override
    public String toString() {
        return "Coffee(" +
                "SKU=" + getSKU() +
                ", price=" + getPrice() +
                ", name=" + getName() +
                ", variant=" + getVariant() +
                ")";
    }
}