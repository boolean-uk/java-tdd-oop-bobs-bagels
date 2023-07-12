package com.booleanuk.core;

import java.util.Objects;

public abstract class Item {
    String SKU;
    String name;
    Double price;
    String variant;

    public Item(String SKU, String name, Double price, String variant) {
        this.SKU = SKU;
        this.name = name;
        this.price = price;
        this.variant = variant;
    }
    public Double checkPrice() {
        return this.price;
    }

    public String getName(){
        return this.name;
    }

    public String getVariant() {
        return variant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(SKU, item.SKU) && Objects.equals(getName(), item.getName()) && Objects.equals(price, item.price) && Objects.equals(getVariant(), item.getVariant());
    }

    @Override
    public int hashCode() {
        return Objects.hash(SKU, getName(), price, getVariant());
    }
}
