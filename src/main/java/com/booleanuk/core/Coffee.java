package com.booleanuk.core;

import java.util.Objects;

public class Coffee implements Item{
    private final String sku;
    private final String name;
    private final int price;

    public Coffee(String sku, String name, int price){
        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    public String getSKU() { return this.sku; }

    public int getPrice() { return this.price; }

    public String getName() { return this.name; }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;

        if (o == null || o.getClass() != this.getClass())
            return false;

        Coffee coffee = (Coffee) o;
        return (coffee.sku.equals(this.sku)
                && coffee.price == this.price
                && coffee.name.equals(this.name));
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.sku, this.price, this.name);
    }
}
