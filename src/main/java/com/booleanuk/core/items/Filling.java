package com.booleanuk.core.items;

import com.booleanuk.core.Item;

public class Filling extends Item {
    public Filling(String SKU, double price, String name, String variant) {
        super(SKU, price, name, variant);
    }

    public Filling(Filling another) {
        super(another);
    }

    @Override
    public String toString() {
        return "Filling(" +
                "SKU=" + getSKU() +
                ", price=" + getPrice() +
                ", name=" + getName() +
                ", variant=" + getVariant() +
                ")";
    }
}
