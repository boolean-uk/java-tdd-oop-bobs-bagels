package com.booleanuk.extension;

import java.util.Objects;

public class Product {
    private String sku;
    private double price;
    private String name;
    private String variant;

    private String[] comboSku;
    private int quantity;



    public Product(String sku, double price, String name, String variant){
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;
    }
    public Product(String[] comboSku, double price, String name, String variant){
        this.comboSku = comboSku;
        this.price = price;
        this.name = name;
        this.variant = variant;

    }
    public Product(String sku, double price, String name, String variant, int quantity){
        this.sku = sku;
        this.price = price;
        this.name = name;
        this.variant = variant;
        this.quantity = quantity;
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
        if(comboSku != null){
            return getName() +" " + getPrice();
        }
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

    public String[] getComboSku() {
        return comboSku;
    }

    public void setComboSku(String[] comboSku) {
        this.comboSku = comboSku;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
