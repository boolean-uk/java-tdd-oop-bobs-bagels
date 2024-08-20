package com.booleanuk.extension;

import java.util.ArrayList;

public class Item {

    private String SKU;
    private int price;
    private String variant;
    private String name;
    private int id;
    private int discountPrice;

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Item itemObjekt){
            return itemObjekt.getId() == this.getId();
        }
        return false;
    }

    public ArrayList<Filling> getFillings() {
        return null;
    }

    public boolean removeFilling(int id){
        return false;
    }

    public int getTotal() {
        if (this.getDiscountPrice() != -1) {
            return this.discountPrice;
        }
        return this.price;
    }
}
