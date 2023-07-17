package com.booleanuk.extension;

public class FillingExt {

    private SkuExt skuExt;
    private String name;
    private double price;


    public FillingExt(SkuExt skuExt, String name, double price) {
        this.skuExt = skuExt;
        this.name = name;
        this.price = price;
    }

    public SkuExt getSku() {
        return skuExt;
    }

    public void setSku(SkuExt skuExt) {
        this.skuExt = skuExt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "FillingExt{" +
                "sku=" + skuExt +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}


