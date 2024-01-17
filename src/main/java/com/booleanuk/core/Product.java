package com.booleanuk.core;

import java.util.Objects;

public class Product {
    String sku;
    double price;
    String name;
    String variant;

    public Product(String sku, double price, String name, String variant){
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;
    }
    public String getSKU(){
        return sku;
    }
    public void setSKU(String sku){
        this.sku = sku;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public String getName(){
        return name;
    }
    public void setName(){
        this.name = name;
    }

    public String getVariant(){
        return variant;
    }
    public void setVariant(){
        this.variant = variant;
    }
    @Override
    public String toString(){
        return getVariant() + " "+getName();
    }

    @Override
    public boolean equals(Object object){
        if(this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Product product = (Product) object;
        return Double.compare(price, product.price) == 0 && Objects.equals(sku, product.sku) && Objects.equals(name, product.name) && Objects.equals(variant, product.variant);

    }
}
