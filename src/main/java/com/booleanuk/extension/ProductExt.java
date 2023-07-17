package com.booleanuk.extension;

public class ProductExt {

    private SkuExt skuExt;
    private String name;
    private double price;

    public ProductExt(SkuExt skuExt, String name, double price) {
        this.skuExt = skuExt;
        this.name = name;
        this.price = price;
    }

    public ProductExt(){

    }

    public SkuExt getSku() {
        return skuExt;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
