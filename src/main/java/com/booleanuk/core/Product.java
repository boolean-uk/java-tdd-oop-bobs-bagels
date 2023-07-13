package com.booleanuk.core;

public class Product {

    private String sku;
    private double price;
    private String name;
    private String variant;

    public Product(String sku, double price, String name, String variant) {
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;
    }

    public String getSku() {
        return sku;
    }

    public double getPrice() {
        return price;
    }

    protected void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getVariant() {
        return variant;
    }

    public Bagel toBagel(){
       return new Bagel(this.getSku(), this.getPrice(), this.getName(), this.getVariant(), null);
    }

    @Override
    public String toString() {
        return "Product{" +
                "sku='" + sku + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", variant='" + variant + '\'' +
                '}';
    }
}
