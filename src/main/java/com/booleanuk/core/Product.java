package com.booleanuk.core;

public class Product {
    private String SKU;
    private float price;
    private ProductName name;
    private Enum variant;

    public Product(float price, Enum variant) {
        this.price = price;
        this.name = setName();
        this.variant = variant;
        this.SKU = setSKU(name, variant);
    }


    public String getSKU() {
        return this.SKU;
    }

    public String setSKU(ProductName name, Enum variant) {
        String productCode = name.toString().substring(0,2);
        String variantCode = variant.toString().substring(0,2);
        String hashCode = productCode + variantCode;

        return hashCode.toUpperCase();
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Enum getName() {
        return this.name;
    }

    public ProductName setName() {
        return ProductName.DEFAULT;
    }

    public Enum getVariant() {
        return variant;
    }

    public void setVariant(Enum variant) {
        this.variant = variant;
    }
}
