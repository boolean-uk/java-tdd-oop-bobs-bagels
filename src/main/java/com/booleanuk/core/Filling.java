package com.booleanuk.core;

import java.util.Objects;

public class Filling implements Item {
    private final String sku;
    private final String name;
    private final int price;

    public Filling(String sku, String name, int price){
        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    public String getSKU() { return this.sku; }

    public int getPrice() {return this.price; }

    public String getName() { return this.name; }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;

        if (o == null || o.getClass() != this.getClass())
            return false;

        Filling filling = (Filling) o;
        return (filling.sku.equals(this.sku)
                && filling.price == this.price
                && filling.name.equals(this.name));
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.sku, this.price, this.name);
    }
}

