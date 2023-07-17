package com.booleanuk.extension;

import java.util.Objects;

public class Product {
    private final String sku;
    private final int price;
    private final String name;
    private final String variant;

    public Product(String sku, int price, String name, String variant) {
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;
    }

    public String sku() {
        return sku;
    }

    public int price() {
        return price;
    }

    public String name() {
        return name;
    }

    public String variant() {
        return variant;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Product) obj;
        return Objects.equals(this.sku, that.sku) &&
                this.price == that.price &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.variant, that.variant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, price, name, variant);
    }

    @Override
    public String toString() {
        return "Product[" +
                "sku=" + sku + ", " +
                "price=" + price + ", " +
                "name=" + name + ", " +
                "variant=" + variant + ']';
    }

}
